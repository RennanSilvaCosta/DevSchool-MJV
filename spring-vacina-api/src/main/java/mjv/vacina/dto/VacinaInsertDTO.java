package mjv.vacina.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class VacinaInsertDTO {

    @NotNull
    private Long idUser;

    @NotBlank
    @NotNull
    private String nomeVacina;

    @NotNull
    private LocalDate dataAplicacao;

    public VacinaInsertDTO() {
    }

    public VacinaInsertDTO(Long idUser, String nomeVacina, LocalDate dataAplicacao) {
        this.idUser = idUser;
        this.nomeVacina = nomeVacina;
        this.dataAplicacao = dataAplicacao;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
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
