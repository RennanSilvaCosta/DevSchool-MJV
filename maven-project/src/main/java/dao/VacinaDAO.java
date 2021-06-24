package dao;

import connectordb.FactoryConnector;
import model.Usuario;
import model.Vacina;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VacinaDAO {

    private Connection connection;

    public VacinaDAO() {
        this.connection = FactoryConnector.getConnection();
    }

    public int saveVacina(Vacina vac) throws SQLException {
        String sql = "INSERT INTO tb_vacina (nome_vacina, nome_usuario, data_aplicacao) VALUES (?,?,?);";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, vac.getNomeVacina());
        pstmt.setString(2, vac.getUsuario().getNomeUsuario());
        pstmt.setDate(3, Date.valueOf(vac.getDataAplicacao()));

        return pstmt.executeUpdate();
    }

    public int updateVacina(Vacina vac) throws SQLException {
        String sql = "UPDATE tb_vacina SET nome_vacina=?, nome_usuario=?, data_aplicacao=? WHERE id=?;";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, vac.getNomeVacina());
        pstmt.setString(2, vac.getUsuario().getNomeUsuario());
        pstmt.setDate(3, Date.valueOf(vac.getDataAplicacao()));
        pstmt.setInt(6, vac.getId());

        return pstmt.executeUpdate();
    }

    public List<Vacina> getAll() throws SQLException {
        String sql = "SELECT * FROM tb_vacina;";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        List<Vacina> vacs = new ArrayList<>();

        while (rs.next()) {
            Usuario user = new Usuario();
            Vacina vac = new Vacina();
            vac.setUsuario(user);
            vac.setId(rs.getInt(1));
            vac.setNomeVacina(rs.getString(2));
            vac.getUsuario().setNomeUsuario(rs.getString(3));
            vac.setDataAplicacao(LocalDate.parse(String.valueOf(rs.getDate(4))));
            vacs.add(vac);
        }
        rs.close();
        return vacs;
    }

    public int deleteVacina(Integer id) throws SQLException {
        String sql = "DELETE FROM tb_vacina WHERE id_vacina=?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, id);
        return pstmt.executeUpdate();
    }

}
