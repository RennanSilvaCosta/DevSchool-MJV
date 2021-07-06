package mjv.vacina.service;


import mjv.vacina.dto.UserDTO;
import mjv.vacina.dto.VacinaDTO;
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

    public VacinaDTO createNewVacina(VacinaDTO vacina) {
        if (validateUser(vacina)) {
            Vacina vac = new Vacina(vacina);
            return new VacinaDTO(vacinaRepository.save(vac));
        }
        //TODO: lançar execeção caso o email não exista
        return vacina;
    }

    public Vacina findApplicationById(Long id) {
        Optional<Vacina> vac = vacinaRepository.findById(id);
        return vac.get();
    }

    private boolean validateUser(VacinaDTO vacina) {
        User u = userRepository.findByEmail(vacina.getUserDTO().getEmail());
        return u != null;
    }

    public List<VacinaDTO> findAllAplication() {
        List<Vacina> lista = vacinaRepository.findAll();
        return lista.stream().map(vac -> new VacinaDTO(vac)).collect(Collectors.toList());
    }
}
