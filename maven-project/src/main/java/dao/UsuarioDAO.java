package dao;

import connectordb.FactoryConnector;
import model.Usuario;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public List<Usuario> getAll() throws SQLException {
        String sql = "SELECT * FROM tb_usuario;";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        List<Usuario> users = new ArrayList<>();

        while (rs.next()) {
            Usuario user = new Usuario();
            user.setId(rs.getInt(1));
            user.setNomeUsuario(rs.getString(2));
            user.setEmail(rs.getString(3));
            user.setCpf(rs.getString(4));
            user.setTelefone(rs.getString(5));
            user.setDataNascimento(LocalDate.parse(String.valueOf(rs.getDate(6))));
            users.add(user);
        }
        rs.close();
        return users;
    }

    public int deleteUsuario(Integer id) throws SQLException {
        String sql = "DELETE FROM tb_usuario WHERE id_usuario=?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, id);
        return pstmt.executeUpdate();
    }

    public Usuario getByCpf(String cpf) throws SQLException {
        String sql = "SELECT * FROM tb_usuario WHERE cpf=?;";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, cpf);
        ResultSet rs = pstmt.executeQuery();

        Usuario user = new Usuario();

        if (rs.next()) {
            user.setId(rs.getInt(1));
            user.setNomeUsuario(rs.getString(2));
            user.setEmail(rs.getString(3));
            user.setCpf(rs.getString(4));
            user.setTelefone(rs.getString(5));
            user.setDataNascimento(LocalDate.parse(String.valueOf(rs.getDate(6))));
        }
        rs.close();
        return user;
    }

}
