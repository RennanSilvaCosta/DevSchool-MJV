package service;

import dao.UsuarioDAO;
import model.Usuario;

import java.sql.SQLException;
import java.util.List;

public class UsuarioService {

    UsuarioDAO dao = new UsuarioDAO();

    public void saveUsuario(Usuario user) {
        try {
            if (dao.saveUsuario(user) == 1) {
                String resposta = String.format("Usuario inserido com sucesso:\nNome: %s\nCPF: %s\nEmail: %s\nData de nascimento: %s\nTel: %s",
                        user.getNomeUsuario(), user.getCpf(), user.getEmail(), user.getDataNascimento(), user.getTelefone());
                System.out.println(resposta);
            }
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
    }

    public void updateUsuario(Usuario user) {
        try {
            dao.updateUsuario(user);
            System.out.println("Atualizaou");
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
    }

    public List<Usuario> getAll() {
        try {
            return dao.getAll();
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
        return null;
    }

    public void deleteUsuario(Integer id) {
        try {
            if (dao.deleteUsuario(id) == 1) {
                System.out.println("Usuario deletado com sucesso!");
            }
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
    }

    public Usuario getByCpf(String cpf) {
        try {
            return dao.getByCpf(cpf);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}