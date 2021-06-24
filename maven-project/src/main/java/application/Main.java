package application;

import model.Usuario;
import service.UsuarioService;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        UsuarioService us = new UsuarioService();
        Usuario user = new Usuario();

        user.setNomeUsuario("Rennan Silva Costa");
        user.setCpf("44488899922");
        user.setEmail("rennan@teste.com");
        user.setDataNascimento(LocalDate.now());
        user.setTelefone("1144557899");

        us.saveUsuario(user);

        List<Usuario> users = us.getAll();

        for (Usuario usuario: users) {
            System.out.println(usuario.getId() + " " + usuario.getNomeUsuario());
        }
    }
}
