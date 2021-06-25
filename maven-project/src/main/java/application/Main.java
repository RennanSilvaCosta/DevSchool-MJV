package application;

import model.Usuario;
import service.UsuarioService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        menu();
        int alt = sc.nextInt();

        switch (alt) {
            case 1:
                subMenuPessoa();
                break;
            case 2:

                break;
            case 3:

                break;
            default:

                break;

        }
    }

    public static void cadastrarUsuario(Scanner sc) {
        Usuario user = new Usuario();
        UsuarioService us = new UsuarioService();
        StringBuilder sb = new StringBuilder();
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

    public static void atualizarUsuario(Scanner sc) {
        Usuario user;
        UsuarioService us = new UsuarioService();
        StringBuilder sb = new StringBuilder();
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
        StringBuilder sb = new StringBuilder();
        UsuarioService us = new UsuarioService();
        List<Usuario> users = us.getAll();

        if (users != null) {
            for (Usuario user : users) {
                sb.append(String.format("\nNome: %s, CPF: %s, Email: %s, Telefone: %s, Nasc: %s\n", user.getNomeUsuario(), user.getCpf(), user.getEmail(), user.getTelefone(), user.getDataNascimento()));
            }
            System.out.println(sb.toString());
        }
        subMenuPessoa();
    }

    public static void menu() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\n%s Aplicação de Vacina %s\n", "-".repeat(20), "-".repeat(20)));
        sb.append("\n 1 - Gerenciar pessoas");
        sb.append("\n 2 - Gerenciar vacinas");
        sb.append("\n 3 - Sair do programa");
        System.out.println(sb.toString());
    }

    public static void subMenuPessoa() {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        sb.append(String.format("\n%s Gerencimaneto de pessoas %s\n", "-".repeat(20), "-".repeat(20)));
        sb.append("\n 1 - Cadastrar nova pessoa");
        sb.append("\n 2 - Alterar pessoa existente pelo CPF");
        sb.append("\n 3 - Lista todas as pessoas");
        sb.append("\n 4 - Exlcuir pessoa pelo CPF");
        sb.append("\n 5 - Procurar pessoa pelo CPF");
        sb.append("\n 6 - Voltar ao menu principal");
        System.out.println(sb.toString());

        int alt = sc.nextInt();

        switch (alt) {
            case 1:
                cadastrarUsuario(sc);
                break;
            case 2:
                atualizarUsuario(sc);
                break;
            case 3:
                listarUsuario();
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                menu();
                break;
            default:
                System.out.println("Opção inválida");
        }
    }
}