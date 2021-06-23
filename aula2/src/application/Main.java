package application;

import model.*;
import pedidoService.PedidoService;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Cadastro cadastroEditora = new Cadastro();
        Cadastro cadastroCliente = new Cadastro();
        Cadastro cadastroArtista = new Cadastro();
        Produto produto = new Livro();
        Produto produto2 = new CD();
        Pedido pedido = new Pedido();
        Livro livro = new Livro();
        CD cd = new CD();

        PedidoItem item;
        List<PedidoItem> itens = new ArrayList<>();

        Empresa empresa = new Empresa(908098157l, 908908413l);
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
        cadastroCliente.setTelefone(11958331269l);

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

        pedido.setData(LocalDateTime.now());
        pedido.setId(1);
        pedido.setValorTotal(59.99);

        livro.setCadastroEditora(cadastroEditora);
        livro.setTitulo("Livro - código limpo");
        livro.setValorVenda(59.99);
        livro.setCodigoBarras("001414000597950045");
        livro.setPaginas(407);

        cd.setCadastroartista(cadastroArtista);
        cd.setTitulo("CD - Rammstein Deutschland");
        cd.setValorVenda(147.66);
        cd.setCodigoBarras("447755221415896123");
        cd.setFaixas(10);

        produto.setId(1);
        produto.setTitulo(livro.getTitulo());
        produto.setValorVenda(livro.getValorVenda());
        produto.setCodigoBarras(livro.getCodigoBarras());

        produto2.setId(2);
        produto2.setTitulo(cd.getTitulo());
        produto2.setValorVenda(cd.getValorVenda());
        produto2.setCodigoBarras(cd.getCodigoBarras());

        item = new PedidoItem();
        item.setId(1);
        item.setTituloProduto(produto2.getTitulo());
        item.setQuantidade(1.0);
        item.setValorVenda(cd.getValorVenda());
        item.setValorTotal(cd.getValorVenda() * item.getQuantidade());

        itens.add(item);

        item = new PedidoItem();
        item.setId(2);
        item.setTituloProduto(produto.getTitulo());
        item.setQuantidade(2.0);
        item.setValorVenda(livro.getValorVenda());
        item.setValorTotal(livro.getValorVenda() * item.getQuantidade());

        itens.add(item);

        pedido.setItens(itens);
        pedido.setEmpresa(empresa);
        pedido.setComprador(cadastroCliente);

        String cupomString = PedidoService.createCupom(pedido);
        File arquivo = new File("C:\\Users\\renna\\Desktop\\ws-devschool\\dev-school-curso-java\\aula2\\cupom");
        if (!arquivo.exists()) {
            arquivo.mkdirs();
        }

        try {
            File cupom = new File(arquivo, "cupom.txt");
            cupom.createNewFile();
            FileWriter arquivoTxt = new FileWriter(cupom.getPath());
            PrintWriter gravarArquivo = new PrintWriter(arquivoTxt);

            gravarArquivo.print(cupomString);
            arquivoTxt.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
