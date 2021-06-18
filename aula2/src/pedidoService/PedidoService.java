package pedidoService;

import model.Empresa;
import model.Pedido;

public class PedidoService {

    public static void imprimitPedido(Pedido pedido) {
        Empresa empresa = pedido.getEmpresa();
        StringBuilder sb = new StringBuilder();
        sb.append(empresa.getCadastro().getNome() + "\n");
        sb.append(empresa.getCadastro().getEndereco() + "\n");
        sb.append(String.format("CNPJ: %s \n", empresa.getCadastro().getCpfCnpj()));
        sb.append(String.format("IE: %d\nIM: %d", empresa.getInscricaoEstadual(), empresa.getInscricaoMunicipal()));
        System.out.println(sb);
    }

}
