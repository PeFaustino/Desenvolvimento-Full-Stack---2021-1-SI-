package br.ufg.inf.fs.business;

import br.ufg.inf.fs.entities.Hospedagem;
import br.ufg.inf.fs.repositories.HospedagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospedagemBusiness {

    @Autowired
    private HospedagemRepository repository;

    public List<Hospedagem> findAll() {
        return repository.findAll();
    }

    public Hospedagem findById(Integer id) {
        return repository.findById(id).get();
    }

    public Hospedagem insert(Hospedagem hospedagem) {
        return repository.save(hospedagem);
    }

    public Hospedagem update(Hospedagem hospedagem) {
        return repository.save(hospedagem);
    }

    public void delete(Integer id) {
        Hospedagem hospedagem = this.findById(id);
        repository.delete(hospedagem);
    }
}
