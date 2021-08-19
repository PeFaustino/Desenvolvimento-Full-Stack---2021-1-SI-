package br.ufg.inf.fs.ctrl;

import br.ufg.inf.fs.business.HospedeBusiness;
import br.ufg.inf.fs.entities.Hospede;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "hospede")
public class HospedeCtrl {

    @Autowired
    private HospedeBusiness business;

    @GetMapping
    public ResponseEntity<List<Hospede>> findAll() {
        List<Hospede> list = business.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospede> findById(@PathVariable Integer id) {
        Hospede retorno = business.findById(id);
        return ResponseEntity.ok(retorno);
    }

    @PostMapping
    public ResponseEntity<Hospede> insert(@RequestBody Hospede hospede) {
        hospede = business.insert(hospede);
        return ResponseEntity.ok(hospede);
    }

    @PutMapping
    public ResponseEntity<Hospede> update(@RequestBody Hospede hospede) {
        hospede = business.update(hospede);
        return ResponseEntity.ok(hospede);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        business.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
