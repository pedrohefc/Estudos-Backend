package generics;

import anotacao.TipoChave;
import doMain.Persistente;
import exception.TipoChaveNaoEncontradaException;

import java.lang.reflect.*;
import java.util.*;

public abstract class GenericDAO<T extends Persistente> implements IGenericDAO<T> {

    private SingletonMap singletonMap;

    public abstract Class<T> getTipoClasse();

    public abstract void atualiarDados(T entity, T entityCadastrado);

    public GenericDAO() {
        this.singletonMap = SingletonMap.getInstance();
    }

    private Map<Long, T> getMapa() {
        Map<Class, Map<Long, ?>> mapaGeral = (Map<Class, Map<Long, ?>>) singletonMap.getMap();

        Map<Long, T> mapa = (Map<Long, T>) mapaGeral.get(getTipoClasse());

        if (mapa == null) {
            mapa = new HashMap<>();
            mapaGeral.put(getTipoClasse(), mapa);
        }

        return mapa;
    }

    public Long getChave(T entity) throws TipoChaveNaoEncontradaException {
        Field[] fields = entity.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(TipoChave.class)) {
                TipoChave tipoChave = field.getAnnotation(TipoChave.class);
                String nomeMetodo = tipoChave.value();

                try {
                    Method method = entity.getClass().getMethod(nomeMetodo);
                    return (Long) method.invoke(entity);
                } catch (Exception e) {
                    throw new TipoChaveNaoEncontradaException(
                            "Chave principal do objeto " + entity.getClass() + " não encontrada", e
                    );
                }
            }
        }

        throw new TipoChaveNaoEncontradaException(
                "Chave principal do objeto " + entity.getClass() + " não encontrada"
        );
    }

    @Override
    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException {
        Map<Long, T> mapa = getMapa();
        Long chave = getChave(entity);

        if (mapa.containsKey(chave)) {
            return false;
        }

        mapa.put(chave, entity);
        return true;
    }

    @Override
    public void excluir(Long valor) {
        Map<Long, T> mapa = getMapa();
        mapa.remove(valor);
    }

    @Override
    public void alterar(T entity) throws TipoChaveNaoEncontradaException {
        Map<Long, T> mapa = getMapa();
        Long chave = getChave(entity);

        T objetoCadastrado = mapa.get(chave);
        if (objetoCadastrado != null) {
            atualiarDados(entity, objetoCadastrado);
        }
    }

    @Override
    public T consultar(Long valor) {
        return getMapa().get(valor);
    }

    @Override
    public Collection<T> buscarTodos() {
        return getMapa().values();
    }
}
