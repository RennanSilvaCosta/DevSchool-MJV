package mjv.vacina.entitys;

import mjv.vacina.dto.VacinaDTO;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "tb_vacina")
public class Vacina implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "id_usuario")
    private User user;

    private String nomeVacina;

    private LocalDate dataAplicacao;

    public Vacina() {
    }

    public Vacina(Long id, User user, String nomeVacina, LocalDate dataAplicacao) {
        this.id = id;
        this.user = user;
        this.nomeVacina = nomeVacina;
        this.dataAplicacao = dataAplicacao;
    }

    public Vacina(VacinaDTO dto) {
        User user = new User(dto.getUserDTO());
        this.id = dto.getId();
        this.user = user;
        this.nomeVacina = dto.getNomeVacina();
        this.dataAplicacao = dto.getDataAplicacao();
    }

    public User getUsuario() {
        return user;
    }

    public void setUsuario(User idUsuario) {
        this.user = idUsuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
