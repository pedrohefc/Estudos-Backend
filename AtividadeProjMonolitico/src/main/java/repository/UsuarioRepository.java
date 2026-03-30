package repository;

import entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void salvar(Usuario usuario) {
        em.persist(usuario);
    }
}
