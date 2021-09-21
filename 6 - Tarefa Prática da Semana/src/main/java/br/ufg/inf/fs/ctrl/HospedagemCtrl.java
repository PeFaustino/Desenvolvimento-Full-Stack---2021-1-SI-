package br.ufg.inf.fs.ctrl;

import br.ufg.inf.fs.Messages;
import br.ufg.inf.fs.business.HospedagemBusiness;
import br.ufg.inf.fs.entities.Hospedagem;
import br.ufg.inf.fs.exceptions.HospedagemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "hospedagem")
public class HospedagemCtrl {

    @Autowired
    private HospedagemBusiness business;

    @GetMapping
    public ResponseEntity<List<Hospedagem>> findAll() {
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;
        List<Hospedagem> list = new ArrayList<Hospedagem>();
        try {
            list = business.findAll();
            if (list.size() == 0) {
                headers.add("message", Messages.get("0307"));
            }
        } catch (Exception e) {
            status = HttpStatus.BAD_REQUEST;
            headers.add("message", Messages.get("0002"));
        }
        return new ResponseEntity<List<Hospedagem>>(list, headers, status);
    }

    @GetMapping("/paginado")
    public ResponseEntity<Page<Hospedagem>> findAllPageable(Pageable pageable) {
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;
        Page<Hospedagem> list = null;
        try {
            list = business.findAllPageable(pageable);
            if (list.getTotalElements() == 0) {
                headers.add("message", Messages.get("0307"));
            }
        } catch (Exception e) {
            status = HttpStatus.BAD_REQUEST;
            headers.add("message", Messages.get("0002"));
        }
        return new ResponseEntity<Page<Hospedagem>>(list, headers, status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospedagem> findById(@PathVariable Integer id) {
        Hospedagem retorno = new Hospedagem();

        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;
        try {
            retorno = business.findById(id);
            if (retorno == null) {
                headers.add("message", Messages.get("0307"));
            }
        } catch (NoSuchElementException e) {
            status = HttpStatus.NOT_FOUND;
            headers.add("message", Messages.get("0307"));
        } catch (Exception e) {
            status = HttpStatus.BAD_REQUEST;
            headers.add("message", Messages.get("0002"));
        }
        return new ResponseEntity<Hospedagem>(retorno, headers, status);
    }

    @PostMapping
    public ResponseEntity<Hospedagem> insert(@RequestBody Hospedagem hospedagem) {
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.CREATED;

        try {
            hospedagem = business.insert(hospedagem);
            headers.add("message", Messages.get("0301"));
        } catch (HospedagemException e) {
            headers.add("message", Messages.get(e.getMessage()));
            status = HttpStatus.BAD_REQUEST;
        } catch (Exception e) {
            headers.add("message", Messages.get("0302"));
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Hospedagem>(hospedagem, headers, status);
    }

    @PutMapping
    public ResponseEntity<Hospedagem> update(@RequestBody Hospedagem hospedagem) {
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;

        try {
            hospedagem = business.update(hospedagem);
            headers.add("message", Messages.get("0303"));
        } catch (HospedagemException e) {
            headers.add("message", Messages.get(e.getMessage()));
            status = HttpStatus.BAD_REQUEST;
        } catch (Exception e) {
            headers.add("message", Messages.get("0304"));
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Hospedagem>(hospedagem, headers, status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.NO_CONTENT;

        try {
            business.delete(id);
            headers.add("message", Messages.get("0305"));
        } catch (Exception e) {
            headers.add("message", Messages.get("0306"));
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Void>(headers, status);
    }

}
