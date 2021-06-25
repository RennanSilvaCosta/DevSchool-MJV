package application;

import model.Usuario;
import model.Vacina;
import service.UsuarioService;
import service.VacinaService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    //auxiliares
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    //servicos
    static UsuarioService us = new UsuarioService();
    static VacinaService vs = new VacinaService();

    //models
    static Usuario user = new Usuario();
    static Vacina vac = new Vacina();

    public static void main(String[] args) {
        menu();
    }

    public static void cadastrarUsuario() {
        resetStringBuilder();
        sb.append(String.format("\n%s Cadastro de pessoa %s\n", "-".repeat(20), "-".repeat(20)));
        sb.append("Informe o nome: ");

        System.out.print(sb.toString());
        user.setNomeUsuario(sc.next());

        System.out.println("");

        System.out.print("Informe o CPF: ");
        user.setCpf(sc.next());

        System.out.println("");

        System.out.print("Informe o email: ");
        user.setEmail(sc.next());

        System.out.println("");

        System.out.print("Informe o telefone: ");
        user.setTelefone(sc.next());

        System.out.println("");

        System.out.print("Informe a data de nascimento (yyyy-mm-dd): ");
        user.setDataNascimento(LocalDate.parse(sc.next()));

        System.out.println("");

        us.saveUsuario(user);

        subMenuPessoa();
    }

    public static void deletarUsuario() {
        resetStringBuilder();
        sb.append(String.format("\n%s Deleção de pessoa %s\n", "-".repeat(20), "-".repeat(20)));
        sb.append("Informe o CPF da pessoa: ");
        System.out.print(sb.toString());

        String cpf = sc.next();
        user = us.getByCpf(cpf);

        if (user.getId() != null) {
            sb.append("Cadastro encontrado");
            sb.append(String.format("\nNome: %s\nEmail: %s\nTelefone: %s\n", user.getNomeUsuario(), user.getEmail(), user.getTelefone()));
            sb.append("\nDeseja realmente deletar este cadastro?\n");
            sb.append("(S)im ou (N)ão");
            System.out.println(sb.toString());

            char resposta = sc.next().charAt(0);

            if (resposta == 's') {
                us.deleteUsuario(user.getId());
            }

        } else {
            System.out.println("Cadastro não encontrado!");
        }
        subMenuPessoa();
    }

    public static void atualizarUsuario() {
        resetStringBuilder();
        sb.append(String.format("\n%s Atualização de pessoa %s\n", "-".repeat(20), "-".repeat(20)));
        sb.append("Informe o CPF da pessoa: ");
        System.out.print(sb.toString());

        String cpf = sc.next();
        user = us.getByCpf(cpf);

        sb = new StringBuilder();

        if (user != null) {
            char resposta = 'n';
            System.out.println("Cadastro encontrado\n");
            do {
                sb.append(String.format("\nNome: %s\nEmail: %s\nTelefone: %s\n", user.getNomeUsuario(), user.getEmail(), user.getTelefone()));
                sb.append("\nQuais dados deseja atualizar?\n");
                sb.append("1 - Nome\n2 - Email\n3 - Telefone");
                System.out.println(sb.toString());
                int alt = sc.nextInt();

                sb = new StringBuilder();

                switch (alt) {
                    case 1:
                        System.out.print("Informe o novo nome: ");
                        user.setNomeUsuario(sc.next());
                        break;

                    case 2:
                        System.out.print("Informe o novo email: ");
                        user.setEmail(sc.next());
                        break;
                    case 3:
                        System.out.print("Informe o novo telefone: ");
                        user.setTelefone(sc.next());
                        break;

                    default:
                        System.out.println("opção inválida!");
                        break;
                }

                System.out.println("");
                System.out.println("Terminou de inserir os novos dados? (S)im ou (N)ão");
                resposta = sc.next().charAt(0);

            } while (resposta == 'n');

            us.updateUsuario(user);

        } else {
            System.out.println("Cadastro não encontrado!");
        }
        subMenuPessoa();
    }

    public static void listarUsuario() {
        resetStringBuilder();
        List<Usuario> users = us.getAll();

        if (users != null) {
            for (Usuario user : users) {
                sb.append(String.format("\nNome: %s, CPF: %s, Email: %s, Telefone: %s, Nasc: %s\n", user.getNomeUsuario(), user.getCpf(), user.getEmail(), user.getTelefone(), user.getDataNascimento()));
            }
            System.out.println(sb.toString());
        }
        subMenuPessoa();
    }

    public static void buscarUsuarioCpf() {
        resetStringBuilder();
        sb.append(String.format("\n%s Procurar pessoa %s\n", "-".repeat(20), "-".repeat(20)));
        sb.append("Informe o CPF da pessoa: ");
        System.out.print(sb.toString());

        String cpf = sc.next();
        user = us.getByCpf(cpf);
        sb = new StringBuilder();

        if (user.getId() != null) {
            sb.append("Cadastro encontrado");
            sb.append(String.format("\nNome: %s\nEmail: %s\nTelefone: %s\nNasc: %s", user.getNomeUsuario(), user.getEmail(), user.getTelefone(), user.getDataNascimento()));
            System.out.println(sb.toString());
        } else {
            System.out.println("Cadastro não encontrado!");
        }
        subMenuPessoa();
    }

    public static void menu() {
        resetStringBuilder();
        sb.append(String.format("\n%s Aplicação de Vacina %s\n", "-".repeat(20), "-".repeat(20)));
        sb.append("\n 1 - Gerenciar pessoas");
        sb.append("\n 2 - Gerenciar vacinas");
        sb.append("\n 3 - Sair do programa");
        System.out.println(sb.toString());

        int alt = sc.nextInt();
        switch (alt) {
            case 1:
                subMenuPessoa();
                break;
            case 2:
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.exit(0);
                break;
        }
    }

    public static void subMenuPessoa() {
        resetStringBuilder();
        sb.append(String.format("\n%s Gerencimaneto de pessoas %s\n", "-".repeat(20), "-".repeat(20)));
        sb.append("\n 1 - Cadastrar nova pessoa");
        sb.append("\n 2 - Alterar pessoa existente pelo CPF");
        sb.append("\n 3 - Exlcuir pessoa pelo CPF");
        sb.append("\n 4 - Lista todas as pessoas");
        sb.append("\n 5 - Procurar pessoa pelo CPF");
        sb.append("\n 6 - Voltar ao menu principal");
        System.out.println(sb.toString());

        int alt = sc.nextInt();

        switch (alt) {
            case 1:
                cadastrarUsuario();
                break;
            case 2:
                atualizarUsuario();
                break;
            case 3:
                deletarUsuario();
                break;
            case 4:
                listarUsuario();
                break;
            case 5:
                buscarUsuarioCpf();
                break;
            case 6:
                menu();
                break;
            default:
                System.out.println("Opção inválida");
        }
    }

    private static void resetStringBuilder() {
        sb = new StringBuilder();
    }
}