package pedidoService;

import model.Empresa;
import model.Pedido;
import util.FormatFactory;

public class PedidoService {

    public static void imprimirDetalhesEmpresaPedido(Pedido pedido) {
        Empresa empresa = pedido.getEmpresa();
        StringBuilder sb = new StringBuilder();
        sb.append(empresa.getCadastro().getNome() + "\n");
        sb.append(String.format("CEP: %s \n", empresa.getCadastro().getEndereco().getCep()));
        sb.append(String.format("Endereço: %s, %s - %s \n", empresa.getCadastro().getEndereco().getLogradouro(), empresa.getCadastro().getEndereco().getNumero(), empresa.getCadastro().getEndereco().getComplemento()));
        sb.append(String.format("Bairro: %s, %s - %s \n", empresa.getCadastro().getEndereco().getBairro(), empresa.getCadastro().getEndereco().getCidade(), empresa.getCadastro().getEndereco().getUf()));
        sb.append(String.format("Referencia: %s \n", empresa.getCadastro().getEndereco().getReferencia()));
        sb.append(String.format("CNPJ: %s \n", FormatFactory.formataCpfCnpj(empresa.getCadastro().getCpfCnpj())));
        sb.append(String.format("IE: %d\nIM: %d", empresa.getInscricaoEstadual(), empresa.getInscricaoMunicipal()));
        System.out.println(sb);
    }

}
