package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {

	private Integer id;
	private Date data;
	private Double valorTotal;
	private List<PedidoItem> itens = new ArrayList<>();

	public Pedido() {

	}

	public Pedido(Integer id, Date data, Double valorTotal, List<PedidoItem> itens) {
		super();
		this.id = id;
		this.data = data;
		this.valorTotal = valorTotal;
		this.itens = itens;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<PedidoItem> getItens() {
		return itens;
	}

	public void setItens(List<PedidoItem> itens) {
		this.itens = itens;
	}

}
