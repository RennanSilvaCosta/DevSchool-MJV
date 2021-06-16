package model;

import java.util.Date;

public abstract class TransmissorMensagem {

	private Date data;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	protected void enviar(String mensagem) {

	}

}
