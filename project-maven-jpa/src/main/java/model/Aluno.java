package model;

import model.enums.NivelProficiencia;
import model.enums.Sexo;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String email;
    private String rg;
    private String cpf;
    private String celular;
    private String nacionalidade;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    private Sexo sexo;

    @Column(name = "nivel_proficiencia")
    private NivelProficiencia nivelProficiencia;

    public Aluno() {
    }

    public Aluno(Integer id, String nome, String email, String rg, String cpf, String celular, String nacionalidade, LocalDate dataNascimento, Sexo sexo, NivelProficiencia nivelProficiencia) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.rg = rg;
        this.cpf = cpf;
        this.celular = celular;
        this.nacionalidade = nacionalidade;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.nivelProficiencia = nivelProficiencia;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public NivelProficiencia getNivelProficiencia() {
        return nivelProficiencia;
    }

    public void setNivelProficiencia(NivelProficiencia nivelProficiencia) {
        this.nivelProficiencia = nivelProficiencia;
    }
}
