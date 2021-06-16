package app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.CD;
import model.Cadastro;
import model.Livro;
import model.Pedido;
import model.PedidoItem;
import model.Produto;

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

		cadastroEditora.setId(1);
		cadastroEditora.setNome("Rotaplan editora e gr�fica");
		cadastroEditora.setEmail("rotaplanario@gmail.com");
		cadastroEditora.setTelefone(22012089L);

		cadastroCliente.setId(1);
		cadastroCliente.setNome("Rennan Silva Costa");
		cadastroCliente.setEmail("rennansilvacosta@hotmail.com");
		cadastroCliente.setTelefone(55887799L);

		cadastroArtista.setId(1);
		cadastroArtista.setNome("Till Lindeman");
		cadastroArtista.setEmail("lindeman@alemanha.com");
		cadastroArtista.setTelefone(4789563212L);

		produto.setId(1);

		pedido.setData(new Date());
		pedido.setId(1);
		pedido.setValorTotal(59.99);

		livro.setCadastroEditora(cadastroEditora);
		livro.setTitulo("Livro - c�digo limpo");
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

		System.out.println("========== Pedido ==========");
		System.out.println("N� pedido: " + pedido.getId());
		System.out.println("Data: " + pedido.getData());
		System.out.println("Nome: " + cadastroCliente.getNome());
		System.out.println("Email: " + cadastroCliente.getEmail());
		System.out.println("Telefone: " + cadastroCliente.getTelefone());

		System.out.println("Itens: ");
		for (PedidoItem pedidoItem : itens) {
			System.out.println(pedidoItem);
			valorTotal += pedidoItem.getValorTotal();
		}

		pedido.setValorTotal(valorTotal);

	}
}
