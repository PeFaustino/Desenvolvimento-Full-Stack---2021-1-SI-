package br.ufg.inf.fs.business;

import br.ufg.inf.fs.entities.Hospedagem;
import br.ufg.inf.fs.exceptions.HospedagemException;
import br.ufg.inf.fs.exceptions.HospedeException;
import br.ufg.inf.fs.repositories.HospedagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospedagemBusiness {

    @Autowired
    private HospedagemRepository repository;

    public List<Hospedagem> findAll() {
        return repository.findAll();
    }

    public Page<Hospedagem> findAllPageable(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Hospedagem findById(Integer id) {
        return repository.findById(id).get();
    }

    public Hospedagem insert(Hospedagem hospedagem) throws HospedagemException, HospedeException {
        this.validate(hospedagem);
        return repository.save(hospedagem);
    }

    public Hospedagem update(Hospedagem hospedagem) throws HospedagemException, HospedeException {
        this.validate(hospedagem);
        return repository.save(hospedagem);
    }

    public void delete(Integer id) {
        Hospedagem hospedagem = this.findById(id);
        repository.delete(hospedagem);
    }

    private void validate(Hospedagem hospedagem) throws HospedagemException, HospedeException {
        if (hospedagem.getDtCheckin() == null) {
            throw new HospedagemException("0309");
        }
        if (hospedagem.getDtCheckout() == null) {
            throw new HospedagemException("0310");
        }
        new HospedeBusiness().validate(hospedagem.getHospede());
    }
}
