package mjv.vacina.dto;

import mjv.vacina.entitys.User;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class UserDTO {

    private Long id;

    @NotNull
    @NotBlank
    private String nome;

    @Email
    @NotNull
    @NotBlank
    private String email;

    @CPF
    @NotNull
    @NotBlank
    private String cpf;

    @NotNull
    private LocalDate dataNascimento;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.nome = user.getNome();
        this.email = user.getEmail();
        this.cpf = user.getCpf();
        this.dataNascimento = user.getDataNascimento();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
