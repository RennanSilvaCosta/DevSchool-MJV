package service;

import dao.VacinaDAO;
import model.Vacina;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class VacinaService {

    final String PATH = "C:\\Users\\renna\\Desktop\\ws-devschool\\dev-school-curso-java\\maven-project\\relatorios";

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

    public void getAllAplicacoes() {
        Scanner sc = new Scanner(System.in);
        try {
            List<Vacina> vacs = dao.getAllAplicacoes();
            if (vacs.size() > 0) {
                String relatorio = geraRelatorio(vacs);
                System.out.println(relatorio);
                System.out.println("Deseja salvar este relatorio: (S)im ou (N)ão");

                char resposta = sc.next().toLowerCase().charAt(0);

                if (resposta == 's') {
                    salvaRelatorio(relatorio);
                }
            } else {
                System.out.println("Impossivel gerar relátorio, pois não foi aplicada nenhuma vacina!");
            }
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
    }

    private void salvaRelatorio(String relatorio) {
        File arquivo = new File(PATH);
        if (!arquivo.exists()) {
            arquivo.mkdirs();
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH.mm.ss");
            String dataFormatada = formatter.format(LocalDateTime.now());

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

    private String geraRelatorio(List<Vacina> vacs) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s Relatorio de aplicação da vacina %s", "=".repeat(30), "=".repeat(30)));

        for (Vacina vac : vacs) {
            sb.append(String.format("\n| Nome: %s\n| CPF: %s\n| Nasc: %s\n| CPF: %s\n| Telefone: %s\n| Vacina: %s\n| Data aplicação: %s\n|", vac.getUsuario().getNomeUsuario(), vac.getUsuario().getCpf(), vac.getUsuario().getDataNascimento(), vac.getUsuario().getCpf(),
                    vac.getUsuario().getTelefone(), vac.getNomeVacina(), vac.getDataAplicacao()));
            sb.append(String.format("%s", "=".repeat(93)));
        }
        return sb.toString();
    }

}
