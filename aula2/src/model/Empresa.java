package model;

public class Empresa {

    private Cadastro cadastro;
    private long inscricaoEstadual;
    private long inscricaoMunicipal;

    public Empresa(long inscricaoEstadual, long inscricaoMunicipal) {
        this.inscricaoEstadual = inscricaoEstadual;
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public long getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public long getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public Cadastro getCadastro() {
        return cadastro;
    }

    public void setCadastro(Cadastro cadastro) {
        this.cadastro = cadastro;
    }
}
