package br.ufg.inf.fs.business;

import br.ufg.inf.fs.entities.Hospede;
import br.ufg.inf.fs.repositories.HospedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospedeBusiness {

    @Autowired
    private HospedeRepository repository;

    public List<Hospede> findAll() {
        return repository.findAll();
    }

    public Hospede findById(Integer id) {
        return repository.findById(id).get();
    }

    public Hospede insert(Hospede hospede) {
        return repository.save(hospede);
    }

    public Hospede update(Hospede hospede) {
        return repository.save(hospede);
    }

    public void delete(Integer id) {
        Hospede hospede = this.findById(id);
        repository.delete(hospede);
    }
}
