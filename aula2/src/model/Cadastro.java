package model;

public class Cadastro {

    private Integer id;
    private String nome;
    private Long telefone;
    private String email;

    public Cadastro() {

    }

    public Cadastro(Integer id, String nome, Long telefone, String email) {
        super();
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "\n id: " + id + "\n nome: " + nome + "\n telefone: " + telefone + "\n email: " + email;
    }

}
