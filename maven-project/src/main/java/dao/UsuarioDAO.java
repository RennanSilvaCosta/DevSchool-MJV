package dao;

import connectordb.FactoryConnector;
import model.Usuario;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {

    private Connection connection;

    public UsuarioDAO() {
        this.connection = FactoryConnector.getConnection();
    }

    public int saveUsuario(Usuario user) throws SQLException {
        String sql = "INSERT INTO tb_usuario (nome_usuario,email,cpf,data_nascimento,telefone) VALUES (?,?,?,?,?);";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, user.getNomeUsuario());
        pstmt.setString(2, user.getEmail());
        pstmt.setString(3, user.getCpf());
        pstmt.setDate(4, Date.valueOf(user.getDataNascimento()));
        pstmt.setString(5, user.getTelefone());

        return pstmt.executeUpdate();
    }

    public int updateUsuario(Usuario user) throws SQLException {
        String sql = "UPDATE tb_usuario SET nome_usuario=?, email=?, cpf=?, data_nascimento=?, telefone=? WHERE id=?;";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, user.getNomeUsuario());
        pstmt.setString(2, user.getEmail());
        pstmt.setString(3, user.getCpf());
        pstmt.setDate(4, Date.valueOf(user.getDataNascimento()));
        pstmt.setString(5, user.getTelefone());
        pstmt.setInt(6, user.getId());

        return pstmt.executeUpdate();
    }

}
