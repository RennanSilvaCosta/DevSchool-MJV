package model;

public class Livro extends Produto {

	Cadastro CadastroEditora;
	private Integer paginas;

	public Cadastro getCadastroEditora() {
		return CadastroEditora;
	}

	public void setCadastroEditora(Cadastro cadastroEditora) {
		CadastroEditora = cadastroEditora;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}

}
