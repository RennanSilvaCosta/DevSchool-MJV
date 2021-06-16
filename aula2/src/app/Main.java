package app;

import java.util.Date;

import model.Cadastro;
import model.Livro;
import model.Pedido;
import model.Produto;

public class Main {

	public static void main(String[] args) {

		Cadastro cadastroEditora = new Cadastro();
		Cadastro cadastroCliente = new Cadastro();
		Produto produto = new Livro();
		Pedido pedido = new Pedido();
		Livro livro = new Livro();

		cadastroEditora.setId(1);
		cadastroEditora.setNome("Rotaplan editora e gráfica");
		cadastroEditora.setEmail("rotaplanario@gmail.com");
		cadastroEditora.setTelefone(22012089L);

		cadastroCliente.setId(1);
		cadastroCliente.setNome("Rennan Silva Costa");
		cadastroCliente.setEmail("rennansilvacosta@hotmail.com");
		cadastroCliente.setTelefone(55887799L);

		produto.setId(1);
		
		pedido.setData(new Date());
		pedido.setId(1);
		pedido.setValorTotal(59.99);

		livro.setCadastroEditora(cadastroEditora);
		livro.setTitulo("Livro - código limpo");
		livro.setValorVenda(59.99);
		livro.setCodigoBarras("001414000597950045");
		livro.setPaginas(407);
		
		produto.setTitulo(livro.getTitulo());
		produto.setValorVenda(livro.getValorVenda());
		produto.setCodigoBarras(livro.getCodigoBarras());
				
		/*System.out.println("=== Cliente ===");
		System.out.println("ID: " + cadastroCliente.getId());
		System.out.println("Nome: " + cadastroCliente.getNome());
		System.out.println("Email: " + cadastroCliente.getEmail());
		System.out.println("Telefone: " + cadastroCliente.getTelefone());

		System.out.println("");

		System.out.println("=== Produto ===");
		System.out.println("ID: " + produto.getId());
		System.out.println("Titulo: " + produto.getTitulo());
		System.out.println("Paginas: " + livro.getPaginas());
		System.out.println("Valor de venda: " + produto.getValorVenda());
		System.out.println("Codigo de barras: " + produto.getCodigoBarras());
		System.out.println("Ediora: " + livro.getCadastroEditora());

		System.out.println("");

		System.out.println("=== Pedido ===");
		System.out.println("ID: " + pedido.getId());
		System.out.println("Valor total: " + pedido.getValorTotal());
		System.out.println("Data: " + pedido.getData());*/
		
		System.out.println("=== Pedido ===");
		System.out.println("Nª pedido: " + pedido.getId());
		System.out.println("Data: " + pedido.getData());
		System.out.println("Nome: " + cadastroCliente.getNome());
		System.out.println("Email: " + cadastroCliente.getEmail());
		System.out.println("Telefone: " + cadastroCliente.getTelefone());
		System.out.println("Produto: " + produto.getTitulo() + " " + livro.getCadastroEditora().getNome());
		System.out.println("Total: " + produto.getValorVenda());
		
	}
}
