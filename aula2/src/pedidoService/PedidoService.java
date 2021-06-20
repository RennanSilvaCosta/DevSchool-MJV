package pedidoService;

import model.Cadastro;
import model.Empresa;
import model.Pedido;
import model.PedidoItem;
import util.FormatFactory;

import java.util.List;

public class PedidoService {

    public static void imprimirPedido(Pedido pedido) {
        imprimirDetalhesEmpresaPedido(pedido);
        imprimirDetalhesClientePedido(pedido);
        imprimirDetalhesItensPedido(pedido);
    }

    private static void imprimirDetalhesEmpresaPedido(Pedido pedido) {
        Empresa empresa = pedido.getEmpresa();
        StringBuilder sb = new StringBuilder();
        sb.append("\n============================================\n");
        sb.append(empresa.getCadastro().getNome() + "\n");
        sb.append(String.format("CEP: %s \n", empresa.getCadastro().getEndereco().getCep()));
        sb.append(String.format("Endereço: %s, %s - %s \n", empresa.getCadastro().getEndereco().getLogradouro(), empresa.getCadastro().getEndereco().getNumero(), empresa.getCadastro().getEndereco().getComplemento()));
        sb.append(String.format("Bairro: %s, %s - %s \n", empresa.getCadastro().getEndereco().getBairro(), empresa.getCadastro().getEndereco().getCidade(), empresa.getCadastro().getEndereco().getUf()));
        sb.append(String.format("Referencia: %s \n", empresa.getCadastro().getEndereco().getReferencia()));
        sb.append(String.format("CNPJ: %s \n", FormatFactory.formataCpfCnpj(empresa.getCadastro().getCpfCnpj())));
        sb.append(String.format("IE: %d\nIM: %d", empresa.getInscricaoEstadual(), empresa.getInscricaoMunicipal()));
        System.out.println(sb);
    }

    private static void imprimirDetalhesClientePedido(Pedido pedido) {
        StringBuilder sb = new StringBuilder();
        Cadastro cadastroCliente = pedido.getComprador();
        sb.append("============================================\n");
        sb.append(String.format("Nª pedido: %d \n", pedido.getId()));
        sb.append(String.format("Data: %s \n", FormatFactory.formataData(pedido.getData())));
        sb.append(String.format("Nome: %s \n", cadastroCliente.getNome()));
        sb.append(String.format("Email: %s \n", cadastroCliente.getEmail()));
        sb.append(String.format("Telefone: %s \n", cadastroCliente.getTelefone()));
        sb.append("============================================");
        System.out.println(sb);
    }

    private static void imprimirDetalhesItensPedido(Pedido pedido) {
        StringBuilder sb = new StringBuilder();
        List<PedidoItem> itens = pedido.getItens();
        double valorTotal = 0;

        sb.append("Itens: \n");
        for (PedidoItem item : itens) {
            sb.append(String.format("\nID: %d \n", item.getId()));
            sb.append(String.format("Produto: %s \n", item.getTituloProduto()));
            sb.append(String.format("Quantidade: %.2f \n", item.getQuantidade()));
            sb.append(String.format("Preço: %.2f \n", item.getValorVenda()));
            sb.append(String.format("Sub Total: %.2f \n", item.getValorVenda() * item.getQuantidade()));
            valorTotal += item.getValorTotal();
        }
        sb.append("=========================================\n");
        sb.append(String.format("Valor total do pedido: %.2f \n", valorTotal));
        sb.append("=========================================");

        System.out.println(sb);
    }


}
