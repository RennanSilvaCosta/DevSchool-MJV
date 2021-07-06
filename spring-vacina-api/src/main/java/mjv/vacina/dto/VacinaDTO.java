package mjv.vacina.dto;

import mjv.vacina.entitys.Vacina;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class VacinaDTO {

    private Long id;

    @NotNull
    private UserDTO userDTO;

    @NotBlank
    @NotNull
    private String nomeVacina;

    @NotNull
    private LocalDate dataAplicacao;

    public VacinaDTO() {
    }

    public VacinaDTO(Long id, UserDTO userDTO, String nomeVacina, LocalDate dataAplicacao) {
        this.id = id;
        this.userDTO = userDTO;
        this.nomeVacina = nomeVacina;
        this.dataAplicacao = dataAplicacao;
    }

    public VacinaDTO(Vacina vac) {
        UserDTO user = new UserDTO(vac.getUsuario());
        this.id = vac.getId();
        this.userDTO = user;
        this.nomeVacina = vac.getNomeVacina();
        this.dataAplicacao = vac.getDataAplicacao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public LocalDate getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(LocalDate dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

}
