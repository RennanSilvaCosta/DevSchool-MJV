package bo;

import dao.UsuarioDAO;
import model.Usuario;

import java.sql.SQLException;

public class ValidateBO {

    UsuarioDAO dao = new UsuarioDAO();

    public boolean validateCpf(String cpf) throws SQLException {
        Usuario user = dao.getByCpf(cpf);
        return user.getId() == null;
    }

    public boolean valdiateEmail(String email) throws SQLException {
        Usuario user = dao.getByEmail(email);
        return user.getId() == null;
    }
}
