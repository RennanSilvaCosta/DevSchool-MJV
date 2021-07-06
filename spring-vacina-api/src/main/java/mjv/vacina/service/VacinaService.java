package mjv.vacina.service;


import mjv.vacina.dto.UserDTO;
import mjv.vacina.dto.VacinaDTO;
import mjv.vacina.dto.VacinaInsertDTO;
import mjv.vacina.entitys.User;
import mjv.vacina.entitys.Vacina;
import mjv.vacina.repository.UserRepository;
import mjv.vacina.repository.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VacinaService {

    @Autowired
    private VacinaRepository vacinaRepository;

    @Autowired
    private UserRepository userRepository;

    public VacinaDTO createNewVacina(VacinaInsertDTO vacinaInsertDTO) {
        VacinaDTO vacinaDTO = validateUser(vacinaInsertDTO);
        vacinaDTO.setNomeVacina(vacinaInsertDTO.getNomeVacina());
        vacinaDTO.setDataAplicacao(vacinaInsertDTO.getDataAplicacao());
        Vacina vacina = new Vacina(vacinaDTO);
        return new VacinaDTO(vacinaRepository.save(vacina));
    }

    public Vacina findApplicationById(Long id) {
        Optional<Vacina> vac = vacinaRepository.findById(id);
        return vac.get();
    }

    private VacinaDTO validateUser(VacinaInsertDTO vacina) {
        Optional<User> user = userRepository.findById(vacina.getIdUser());
        if (user.isPresent()) {
            VacinaDTO vac = new VacinaDTO();
            UserDTO u = new UserDTO(user.get());
            vac.setUserDTO(u);
            return vac;
        } else {
            //TODO: lançar exceção, pois o usuario não foi encontrado
            System.out.println("Usuario não existe");
            return null;
        }
    }

    public List<VacinaDTO> findAllAplication() {
        List<Vacina> lista = vacinaRepository.findAll();
        return lista.stream().map(vac -> new VacinaDTO(vac)).collect(Collectors.toList());
    }
}
