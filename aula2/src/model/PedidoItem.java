package model;

public class PedidoItem {

	private Integer id;
	private Double quantidade;
	private Double valorVenda;
	private Double valorTotal;

	public PedidoItem() {
	}

	public PedidoItem(Integer id, Double quantidade, Double valorVenda, Double valorTotal) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.valorVenda = valorVenda;
		this.valorTotal = valorTotal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	@Override
	public String toString() {
		return " id: " + id + "\n quantidade: " + quantidade + "\n valorVenda: " + valorVenda + "\n valorTotal: "
				+ valorTotal;
	}

}
