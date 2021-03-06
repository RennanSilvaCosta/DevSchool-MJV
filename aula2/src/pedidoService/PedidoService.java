package pedidoService;

import model.Cadastro;
import model.Empresa;
import model.Pedido;
import model.PedidoItem;
import util.FormatFactory;

import java.util.List;

public class PedidoService {

    private static final String LINHA_CUPOM = "=";
    private static final Integer LINHA_CUPOM_QTD = 60;

    public static String createCupom(Pedido pedido) {
        StringBuilder sb = new StringBuilder();
        sb.append(imprimirDetalhesEmpresaPedido(pedido));
        sb.append(imprimirDetalhesClientePedido(pedido));
        sb.append(imprimirDetalhesItensPedido(pedido));
        return sb.toString();
    }

    private static String imprimirDetalhesEmpresaPedido(Pedido pedido) {
        Empresa empresa = pedido.getEmpresa();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s\n", LINHA_CUPOM.repeat(LINHA_CUPOM_QTD)));
        sb.append(empresa.getCadastro().getNome() + "\n");
        sb.append(String.format("CEP: %s \n", empresa.getCadastro().getEndereco().getCep()));
        sb.append(String.format("Endereço: %s, %s - %s \n", empresa.getCadastro().getEndereco().getLogradouro(), empresa.getCadastro().getEndereco().getNumero(), empresa.getCadastro().getEndereco().getComplemento()));
        sb.append(String.format("Bairro: %s, %s - %s \n", empresa.getCadastro().getEndereco().getBairro(), empresa.getCadastro().getEndereco().getCidade(), empresa.getCadastro().getEndereco().getUf()));
        sb.append(String.format("Referencia: %s \n", empresa.getCadastro().getEndereco().getReferencia()));
        sb.append(String.format("CNPJ: %s \n", FormatFactory.formataCpfCnpj(empresa.getCadastro().getCpfCnpj())));
        sb.append(String.format("IE: %s\nIM: %s", FormatFactory.formataIE(empresa.getInscricaoEstadual()), FormatFactory.formataIM(empresa.getInscricaoMunicipal())));
        return sb.toString();
    }

    private static String imprimirDetalhesClientePedido(Pedido pedido) {
        StringBuilder sb = new StringBuilder();
        Cadastro cadastroCliente = pedido.getComprador();
        sb.append(String.format("\n%s\n", LINHA_CUPOM.repeat(LINHA_CUPOM_QTD)));
        sb.append(String.format("Nª pedido: %d \n", pedido.getId()));
        sb.append(String.format("Data: %s \n", FormatFactory.formataData(pedido.getData())));
        sb.append(String.format("Nome: %s \n", cadastroCliente.getNome()));
        sb.append(String.format("Email: %s \n", cadastroCliente.getEmail()));
        sb.append(String.format("Telefone: %s \n", FormatFactory.formataTelefone(cadastroCliente.getTelefone())));
        sb.append(String.format("CEP: %s \n", cadastroCliente.getEndereco().getCep()));
        sb.append(String.format("Endereço: %s, %s - %s \n", cadastroCliente.getEndereco().getLogradouro(), cadastroCliente.getEndereco().getNumero(), cadastroCliente.getEndereco().getComplemento()));
        sb.append(String.format("Bairro: %s, %s - %s \n", cadastroCliente.getEndereco().getBairro(), cadastroCliente.getEndereco().getCidade(), cadastroCliente.getEndereco().getUf()));
        sb.append(String.format("Referencia: %s \n", cadastroCliente.getEndereco().getReferencia()));
        sb.append(String.format("%s\n", LINHA_CUPOM.repeat(LINHA_CUPOM_QTD)));
        return sb.toString();
    }

    private static String imprimirDetalhesItensPedido(Pedido pedido) {
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
        sb.append(String.format("%s\n", LINHA_CUPOM.repeat(LINHA_CUPOM_QTD)));
        sb.append(String.format("Valor total do pedido: %.2f \n", valorTotal));
        sb.append(String.format("%s\n", LINHA_CUPOM.repeat(LINHA_CUPOM_QTD)));

        return sb.toString();
    }


}
