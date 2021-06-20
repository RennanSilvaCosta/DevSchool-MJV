package application;

import model.*;
import pedidoService.PedidoService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Cadastro cadastroEditora = new Cadastro();
        Cadastro cadastroCliente = new Cadastro();
        Cadastro cadastroArtista = new Cadastro();
        Produto produto = new Livro();
        Pedido pedido = new Pedido();
        Livro livro = new Livro();
        CD cd = new CD();

        PedidoItem item;
        List<PedidoItem> itens = new ArrayList<>();

        double valorTotal = 0;

        Empresa empresa = new Empresa(9080981l, 9089084l);
        Cadastro cadastroEmpresa = new Cadastro();
        Endereco enderecoEmpresa = new Endereco();
        cadastroEmpresa.setCpfCnpj("12345678900001");
        cadastroEmpresa.setEmail("pedidos@pedidos.com");

        //Setando endereço no cadastro da empresa
        enderecoEmpresa.setCep("05526-060");
        enderecoEmpresa.setLogradouro("Rua Inocêncio da Silva");
        enderecoEmpresa.setBairro("Jardim Jussara");
        enderecoEmpresa.setNumero(1478);
        enderecoEmpresa.setComplemento("A");
        enderecoEmpresa.setReferencia("Do lado da ótica 'visão boa'");
        enderecoEmpresa.setCidade("São Paulo");
        enderecoEmpresa.setUf("SP");

        cadastroEmpresa.setEndereco(enderecoEmpresa);
        
        cadastroEmpresa.setNome("IFOOD PEDIDOS");
        empresa.setCadastro(cadastroEmpresa);

        cadastroEditora.setId(1);
        cadastroEditora.setNome("Rotaplan editora e gráfica");
        cadastroEditora.setEmail("rotaplanario@gmail.com");
        cadastroEditora.setTelefone(22012089L);

        cadastroCliente.setId(1);
        cadastroCliente.setNome("Rennan Silva Costa");
        cadastroCliente.setEmail("rennansilvacosta@hotmail.com");
        cadastroCliente.setTelefone(55887799L);

        Endereco enderecoCliente = new Endereco();
        enderecoCliente.setCep("04620-009");
        enderecoCliente.setLogradouro("Praça Pastor Stremme");
        enderecoCliente.setBairro("Campo Belo");
        enderecoCliente.setNumero(1557);
        enderecoCliente.setComplemento("Ap 33 Bloco 4");
        enderecoCliente.setReferencia("Do lado da soverteria");
        enderecoCliente.setCidade("São Paulo");
        enderecoCliente.setUf("SP");

        cadastroCliente.setEndereco(enderecoCliente);

        cadastroArtista.setId(1);
        cadastroArtista.setNome("Till Lindeman");
        cadastroArtista.setEmail("lindeman@alemanha.com");
        cadastroArtista.setTelefone(4789563212L);

        produto.setId(1);

        pedido.setData(new Date());
        pedido.setId(1);
        pedido.setValorTotal(59.99);

        livro.setCadastroEditora(cadastroEditora);
        livro.setTitulo("Livro - código limpo");
        livro.setValorVenda(59.99);
        livro.setCodigoBarras("001414000597950045");
        livro.setPaginas(407);

        cd.setCadastroartista(cadastroArtista);
        cd.setTitulo("Deutschland");
        cd.setValorVenda(147.66);
        cd.setCodigoBarras("447755221415896123");
        cd.setFaixas(10);

        produto.setTitulo(livro.getTitulo());
        produto.setValorVenda(livro.getValorVenda());
        produto.setCodigoBarras(livro.getCodigoBarras());

        item = new PedidoItem();
        item.setId(1);
        item.setQuantidade(1.0);
        item.setValorVenda(cd.getValorVenda());
        item.setValorTotal(cd.getValorVenda() * item.getQuantidade());

        itens.add(item);

        item = new PedidoItem();
        item.setId(2);
        item.setQuantidade(2.0);
        item.setValorVenda(livro.getValorVenda());
        item.setValorTotal(livro.getValorVenda() * item.getQuantidade());

        itens.add(item);

        pedido.setEmpresa(empresa);
        PedidoService.imprimirDetalhesEmpresaPedido(pedido);

        System.out.println("");
        System.out.println("=================== Pedido =====================");
        System.out.println("");
        System.out.println("Nª pedido: " + pedido.getId());
        System.out.println("Data: " + pedido.getData());
        System.out.println("Nome: " + cadastroCliente.getNome());
        System.out.println("Email: " + cadastroCliente.getEmail());
        System.out.println("Telefone: " + cadastroCliente.getTelefone());

        System.out.println("");
        System.out.println("Itens: ");
        System.out.println("");
        for (PedidoItem pedidoItem : itens) {
            System.out.println(pedidoItem);
            System.out.println("");
            valorTotal += pedidoItem.getValorTotal();
        }

        pedido.setValorTotal(valorTotal);

        System.out.println("----------------------------------------");
        System.out.println("Valor total do pedido: " + pedido.getValorTotal());
        System.out.println("----------------------------------------");
    }
}
