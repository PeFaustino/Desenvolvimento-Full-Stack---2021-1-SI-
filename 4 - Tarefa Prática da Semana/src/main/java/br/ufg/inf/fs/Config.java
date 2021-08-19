package br.ufg.inf.fs;

import br.ufg.inf.fs.entities.Hospedagem;
import br.ufg.inf.fs.entities.Hospede;
import br.ufg.inf.fs.entities.Hotel;
import br.ufg.inf.fs.entities.Quarto;
import br.ufg.inf.fs.enums.CategoriaQuarto;
import br.ufg.inf.fs.repositories.HospedagemRepository;
import br.ufg.inf.fs.repositories.HospedeRepository;
import br.ufg.inf.fs.repositories.HotelRepository;
import br.ufg.inf.fs.repositories.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.sql.Date;

@Configuration
@Profile("dev")
public class Config implements CommandLineRunner {

    @Autowired
    private HotelRepository hoteRepository;

    @Autowired
    private QuartoRepository quartoRepository;

    @Autowired
    private HospedeRepository hospedeRepository;

    @Autowired
    private HospedagemRepository hospedagemRepository;

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub

        /*
         * INSERIR NO MEU BANCO DE DADOS INFORMAÇÕES INICIAIS...
         * */

        Hotel h1 = new Hotel(null, "Calderão Furado", "Beco Diagonal", 3);
        Hotel h2 = new Hotel(null, "Bates Hotel", "White Pine Bay", 2);
        Hotel h3 = new Hotel(null, "Hotel Overlook", "Colorado", 4);
        Hotel h4 = new Hotel(null, "Continental Hotel", "Ney York City", 5);

        h1 = hoteRepository.save(h1);
        h2 = hoteRepository.save(h2);
        h3 = hoteRepository.save(h3);
        h4 = hoteRepository.save(h4);

        Quarto q1 = quartoRepository.save(new Quarto(null, h1, CategoriaQuarto.APARTAMENTO, 4, 1010, 200.0));
        Quarto q2 = quartoRepository.save(new Quarto(null, h2, CategoriaQuarto.SIMPLES, 1, 7, 100.0));
        Quarto q3 = quartoRepository.save(new Quarto(null, h3, CategoriaQuarto.PADRAO, 2, 306, 150.0));
        Quarto q4 = quartoRepository.save(new Quarto(null, h4, CategoriaQuarto.LUXO, 3, 1313, 500.0));

        Hospede hospede = hospedeRepository.save(new Hospede(null, "Pedro", new Date(1990, 1, 8), 123456));

        Hospedagem hospedagem = hospedagemRepository.save(new Hospedagem(null, hospede, q1, new Date(1990, 1, 8), new Date(1990, 1, 8)));

        for (Hospedagem hos : hospedagemRepository.findAll()){
            System.out.println(hos);
        }
    }

}
