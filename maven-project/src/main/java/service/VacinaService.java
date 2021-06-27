package service;

import dao.VacinaDAO;
import model.Vacina;
import util.FactoryFormat;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class VacinaService {

    final String PATH = "C:\\Users\\renna\\Desktop\\ws-devschool\\dev-school-curso-java\\maven-project\\relatorios";

    VacinaDAO dao = new VacinaDAO();

    public void saveVacina(Vacina vac) {
        try {
            if (dao.saveVacina(vac) == 1) {
                System.out.printf("\nVacina aplicada com sucesso:\nNome: %s\nAplicado em: %s\nData de aplicação: %s%n",
                        vac.getNomeVacina(), vac.getUsuario().getNomeUsuario(), FactoryFormat.formataData(vac.getDataAplicacao()));
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

    public void findAllAplicacoes() {
        Scanner sc = new Scanner(System.in);
        try {
            List<Vacina> vacs = dao.findAllAplicacoes();
            if (vacs.size() > 0) {
                String relatorio = createRelatorio(vacs);
                System.out.println(relatorio);
                System.out.println("Deseja salvar este relatorio: (S)im ou (N)ão");

                char resposta = sc.next().toLowerCase().charAt(0);

                if (resposta == 's') {
                    saveRelatorio(relatorio);
                }
            } else {
                System.out.println("Impossivel gerar relátorio, pois não foi aplicada nenhuma vacina!");
            }
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
    }

    private void saveRelatorio(String relatorio) {
        File arquivo = new File(PATH);
        if (!arquivo.exists()) {
            arquivo.mkdirs();
        }
        try {
            String dataFormatada = FactoryFormat.formataData(LocalDateTime.now(), "dd-MM-yyyy HH.mm.ss");

            File relatorioTxt = new File(arquivo, "relatorio " + dataFormatada + ".txt");
            relatorioTxt.createNewFile();
            FileWriter arquivoTxt = new FileWriter(relatorioTxt.getPath());
            PrintWriter gravarArquivo = new PrintWriter(arquivoTxt);
            gravarArquivo.print(relatorio);
            arquivoTxt.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteVacina(Integer id) {
        try {
            if (dao.deleteVacina(id) == 1) {
                System.out.println("Vacina deletada com sucesso!");
            }
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
    }

    private String createRelatorio(List<Vacina> vacs) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s Relatorio de aplicação da vacina %s", "=".repeat(30), "=".repeat(30)));

        for (Vacina vac : vacs) {
            sb.append(String.format("\n| Nome: %s\n| CPF: %s\n| Nasc: %s\n| Telefone: %s\n| Vacina: %s\n| Data aplicação: %s\n|",
                    vac.getUsuario().getNomeUsuario(),
                    FactoryFormat.formataCpf(vac.getUsuario().getCpf()),
                    FactoryFormat.formataData(vac.getUsuario().getDataNascimento()),
                    FactoryFormat.formataTelefone(vac.getUsuario().getTelefone()),
                    vac.getNomeVacina(),
                    FactoryFormat.formataData(vac.getDataAplicacao())));
            sb.append(String.format("%s", "=".repeat(93)));
        }
        return sb.toString();
    }

}
