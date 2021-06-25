package service;

import dao.VacinaDAO;
import model.Vacina;

import java.sql.SQLException;

public class VacinaService {

    VacinaDAO dao = new VacinaDAO();

    public void saveVacina(Vacina vac) {
        try {
            if (dao.saveVacina(vac) == 1) {
                String resposta = String.format("\nVacina aplicada com sucesso:\nNome: %s\nAplicado em: %s\nData de aplicação: %s",
                        vac.getNomeVacina(), vac.getUsuario().getNomeUsuario(), vac.getDataAplicacao());
                System.out.println(resposta);
            }
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
    }

    public void updateVacina(Vacina vac) {
        try {
            dao.updateVacina(vac);
            System.out.println("Atualizaou");
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
    }

   /* public List<Vacina> getAll() {
        try {
            return dao.getAll();
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
        return null;
    }*/

    public void deleteVacina(Integer id) {
        try {
            if (dao.deleteVacina(id) == 1) {
                System.out.println("Vacina deletada com sucesso!");
            }
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
    }

}
