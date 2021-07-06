package mjv.vacina.controller;

import mjv.vacina.dto.VacinaDTO;
import mjv.vacina.dto.VacinaInsertDTO;
import mjv.vacina.service.VacinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/vacinas")
public class VacinaController {

    @Autowired
    private VacinaService vacinaService;

    @PostMapping
    public ResponseEntity<?> saveVacina(@Valid @RequestBody VacinaInsertDTO vacina) {
        VacinaDTO vac = vacinaService.createNewVacina(vacina);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(vac.getId()).toUri();
        return ResponseEntity.created(uri).body(vac);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(vacinaService.findApplicationById(id));
    }

    @GetMapping
    public ResponseEntity<List<VacinaDTO>> findAll() {
        return ResponseEntity.ok().body(vacinaService.findAllAplication());
    }
}
