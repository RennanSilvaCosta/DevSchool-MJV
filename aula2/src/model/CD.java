package model;

public class CD extends Produto {

	Cadastro Cadastroartista;
	private Integer faixas;

	public CD() {

	}

	public CD(Cadastro cadastroartista, Integer faixas) {
		super();
		Cadastroartista = cadastroartista;
		this.faixas = faixas;
	}

	public Cadastro getCadastroartista() {
		return Cadastroartista;
	}

	public void setCadastroartista(Cadastro cadastroartista) {
		Cadastroartista = cadastroartista;
	}

	public Integer getFaixas() {
		return faixas;
	}

	public void setFaixas(Integer faixas) {
		this.faixas = faixas;
	}

}
