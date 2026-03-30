package service;

import entity.Usuario;
import repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;

import jakarta.inject.Inject;

@ApplicationScoped
public class UsuarioService {

    @Inject
    private UsuarioRepository repository;

    public void cadastrarUsuario(Usuario usuario) {

        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            throw new RuntimeException("Nome é obrigatório");
        }

        if (usuario.getEmail() == null || !usuario.getEmail().contains("@")) {
            throw new RuntimeException("Email inválido");
        }

        repository.salvar(usuario);
    }
}
