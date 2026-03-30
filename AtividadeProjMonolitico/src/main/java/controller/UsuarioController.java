package controller;

import entity.Usuario;
import service.UsuarioService;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

@Named
@RequestScoped
public class UsuarioController {

    private Usuario usuario = new Usuario();

    @Inject
    private UsuarioService service;

    public void salvar() {
        try {
            service.cadastrarUsuario(usuario);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Usuário salvo com sucesso!"));

            usuario = new Usuario(); // limpa o formulário

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
