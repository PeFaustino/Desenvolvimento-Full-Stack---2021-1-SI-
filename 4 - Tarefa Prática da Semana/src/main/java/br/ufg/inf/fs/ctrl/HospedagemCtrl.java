package br.ufg.inf.fs.ctrl;

import br.ufg.inf.fs.business.HospedagemBusiness;
import br.ufg.inf.fs.entities.Hospedagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "hospedagem")
public class HospedagemCtrl {

    @Autowired
    private HospedagemBusiness business;

    @GetMapping
    public ResponseEntity<List<Hospedagem>> findAll() {
        List<Hospedagem> list = business.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospedagem> findById(@PathVariable Integer id) {
        Hospedagem retorno = business.findById(id);
        return ResponseEntity.ok(retorno);
    }

    @PostMapping
    public ResponseEntity<Hospedagem> insert(@RequestBody Hospedagem hospedagem) {
        hospedagem = business.insert(hospedagem);
        return ResponseEntity.ok(hospedagem);
    }

    @PutMapping
    public ResponseEntity<Hospedagem> update(@RequestBody Hospedagem hospedagem) {
        hospedagem = business.update(hospedagem);
        return ResponseEntity.ok(hospedagem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        business.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
