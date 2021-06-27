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
    private String sql = null;

    public VacinaDAO() {
        this.connection = FactoryConnector.getConnection();
    }

    public int saveVacina(Vacina vac) throws SQLException {
        sql = "INSERT INTO tb_vacina (nome_vacina, data_aplicacao, id_usuario) VALUES (?,?,?);";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, vac.getNomeVacina());
        pstmt.setDate(2, Date.valueOf(vac.getDataAplicacao()));
        pstmt.setInt(3, vac.getUsuario().getId());

        return pstmt.executeUpdate();
    }

    public int updateVacina(Vacina vac) throws SQLException {
        sql = "UPDATE tb_vacina SET nome_vacina=?, data_aplicacao=? WHERE id=?;";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, vac.getNomeVacina());
        pstmt.setDate(2, Date.valueOf(vac.getDataAplicacao()));
        pstmt.setInt(3, vac.getId());

        return pstmt.executeUpdate();
    }

    public List<Vacina> findAllAplicacoes() throws SQLException {
        sql = "SELECT * FROM tb_vacina inner join tb_usuario on (tb_vacina.id_usuario = tb_usuario.id);";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        List<Vacina> vacs = new ArrayList<>();

        while (rs.next()) {
            Usuario user = new Usuario();
            Vacina vac = new Vacina();

            vac.setId(rs.getInt(1));
            vac.setNomeVacina(rs.getString(2));
            vac.setDataAplicacao(LocalDate.parse(String.valueOf(rs.getDate(3))));

            user.setId(rs.getInt(5));
            user.setNomeUsuario(rs.getString(6));
            user.setEmail(rs.getString(7));
            user.setCpf(rs.getString(8));
            user.setTelefone(rs.getString(9));
            user.setDataNascimento(LocalDate.parse(String.valueOf(rs.getDate(10))));

            vac.setUsuario(user);
            vacs.add(vac);
        }
        rs.close();
        return vacs;
    }

    public int deleteVacina(Integer id) throws SQLException {
        sql = "DELETE FROM tb_vacina WHERE id_vacina=?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, id);
        return pstmt.executeUpdate();
    }
}
