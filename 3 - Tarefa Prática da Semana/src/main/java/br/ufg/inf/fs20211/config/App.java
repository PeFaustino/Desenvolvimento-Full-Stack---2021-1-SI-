package br.ufg.inf.fs20211.config;

import br.ufg.inf.fs.enums.CategoriaQuarto;
import br.ufg.inf.fs20211.ctrl.HospedagemCtrl;
import br.ufg.inf.fs20211.ctrl.HospedeCtrl;
import br.ufg.inf.fs20211.ctrl.HotelCtrl;
import br.ufg.inf.fs20211.ctrl.QuartoCtrl;
import br.ufg.inf.fs20211.entities.Hospedagem;
import br.ufg.inf.fs20211.entities.Hospede;
import br.ufg.inf.fs20211.entities.Hotel;
import br.ufg.inf.fs20211.entities.Quarto;

import javax.persistence.EntityManager;
import java.sql.Date;

public class App {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Come�ando");

        testeJpaHospedagem();

    }

    public static void testeJpaQuarto() {
        QuartoCtrl ctrl = new QuartoCtrl();
        HotelCtrl hotelCtrl = new HotelCtrl();
        System.out.println("Busca Todos");
        for (Quarto h : ctrl.findAll()) {
            System.out.println(h);
        }

        System.out.println("Buscar por ID");
        System.out.println(ctrl.findById(3));

        System.out.println("Inserir no banco");
        Quarto q1 = new Quarto(null, hotelCtrl.findById(1), CategoriaQuarto.APARTAMENTO, 3, 1010, 150.0);
        Quarto q2 = new Quarto(null, hotelCtrl.findById(2), CategoriaQuarto.DORMITORIO, 8, 310, 50.0);
        Quarto q3 = new Quarto(null, hotelCtrl.findById(3), CategoriaQuarto.LUXO, 5, 1210, 550.0);
        Quarto q4 = new Quarto(null, hotelCtrl.findById(4), CategoriaQuarto.SIMPLES, 2, 110, 100.0);
        q1 = ctrl.insert(q1);
        System.out.println(q1);

        q2 = ctrl.insert(q2);
        System.out.println(q2);

        q3 = ctrl.insert(q3);
        System.out.println(q3);

        q4 = ctrl.insert(q4);
        System.out.println(q4);

        for (Quarto q : ctrl.findAll()) {
            System.out.println(q);
        }

        System.out.println("Alterar no banco");
        q1.setPrDiaria(175.0);
        q1 = ctrl.update(q1);

        for (Quarto q : ctrl.findAll()) {
            System.out.println(q);
        }


        System.out.println("Excluir");
        ctrl.delete(q3.getIdQuarto());
        System.out.println("Terminou");
    }

    public static void testeJpaHotel() {
        HotelCtrl ctrl = new HotelCtrl();
        System.out.println("Busca Todos");
        for (Hotel h : ctrl.findAll()) {
            System.out.println(h);
        }

        System.out.println("Buscar por ID");
        System.out.println(ctrl.findById(3));

        System.out.println("Inserir no banco");
        Hotel hotel = new Hotel(null, "Teste", "Qualquer Lugar", 10);
        hotel = ctrl.insert(hotel);
        System.out.println(hotel);

        System.out.println("Alterar no banco");
        hotel.setNmHotel("Teste Alterado");
        hotel = ctrl.update(hotel);
        System.out.println(hotel);


        System.out.println("Excluir");
        ctrl.delete(hotel.getIdHotel());
        System.out.println("Terminou");
    }

    public static void testeJpa() {
        EntityManager em = DaoFactory.getEntityManager();

        // CREATE
		/*//Hotel hotel = new Hotel(null, "Castro`s Park Hotel", "Goi�nia", 5);
		em.getTransaction().begin();
		//em.persist(hotel);
		Hotel h1 = new Hotel(null, "Ibis", "Goi�nia", 3);
		Hotel h2 = new Hotel(null, "Copacabana Palace", "Rio de Janeiro", 5);
		Hotel h3 = new Hotel(null, "Denali Hotel", "An�polis", 4);
		
		em.persist(h1);
		em.persist(h2);
		em.persist(h3);
		
		
		em.getTransaction().commit();
		*/

        // READ ALL
		/*
		System.out.println("Buscar Todos");
		TypedQuery<Hotel> result = em.createQuery("from Hotel", Hotel.class);
		List<Hotel> hoteis = result.getResultList();
		for(Hotel h : hoteis) {
			System.out.println(h);
		}
		
		
		// READ BY ID
		Hotel h4 = em.find(Hotel.class, 3);
		
		System.out.println("Buscar Por ID");
		System.out.println(h4);
		
		System.out.println("Buscar por Ocorr�ncia");
		String sql = "from Hotel h where h.nmHotel like :str";
		TypedQuery<Hotel> result2 = em.createQuery(sql, Hotel.class);
		result2.setParameter("str", "%i%");
		hoteis = result2.getResultList();
		for(Hotel h : hoteis) {
			System.out.println(h);
		}*/

        System.out.println("Update do Objeto");
        Hotel hotelUpdate = em.find(Hotel.class, 2);

        hotelUpdate.setNmHotel("Ibis Hotel");

        em.getTransaction().begin();
        em.persist(hotelUpdate);
        em.getTransaction().commit();


        System.out.println("Delete do Objeto");
		/*new Hotel(null, "Hotel Santo Ant�nio", "Neropolis", 3);
		System.out.println(hotelDeleta);
		System.out.println("persistindo");
		em.getTransaction().begin();
		em.persist(hotelDeleta);
		em.getTransaction().commit();
		System.out.println("novo objeto");
		System.out.println(hotelDeleta);*/
		/*Hotel hotelDeleta = em.find(Hotel.class, 5);
		
		em.getTransaction().begin();
		em.remove(hotelDeleta);
		em.getTransaction().commit();
		*/

        DaoFactory.closeConnection();
    }

    public static void testeJpaHospedagem() {
        HospedagemCtrl ctrl = new HospedagemCtrl();
        HotelCtrl hotelCtrl = new HotelCtrl();
        HospedeCtrl hospedeCtrl = new HospedeCtrl();
        QuartoCtrl quartoCtrl = new QuartoCtrl();

        System.out.println("Busca Todos");
        for (Hospedagem h : ctrl.findAll()) {
            System.out.println(h);
        }

        System.out.println("\nBuscar por ID");
        System.out.println(ctrl.findById(1));

        System.out.println("\nInserir no banco");

        Hotel hotel = new Hotel(null, "Hotel Goiânia", "Goiânia", 3);
        hotel = hotelCtrl.insert(hotel);

        Quarto quarto = new Quarto(null, hotel, CategoriaQuarto.APARTAMENTO, 3, 1010, 150.0);
        quarto = quartoCtrl.insert(quarto);

        Hospede hospede = new Hospede(null, "hospede", new Date(1990, 1, 8), 123456);
        hospede = hospedeCtrl.insert(hospede);

        Hospedagem hospedagem = new Hospedagem(null, hospede, quarto, new Date(1990, 1, 8), new Date(1990, 1, 8));
        hospedagem = ctrl.insert(hospedagem);


        for (Hospedagem h : ctrl.findAll()) {
            System.out.println(h);
        }


        System.out.println("\nExcluir");
        ctrl.delete(hospedagem.getIdHospedagem());
        System.out.println("\nTerminou");
    }

    public static void testeJpaHospede() {
        HospedeCtrl hospedeCtrl = new HospedeCtrl();

        System.out.println("Busca Todos");
        for (Hospede h : hospedeCtrl.findAll()) {
            System.out.println(h);
        }

        System.out.println("\nBuscar por ID");
        System.out.println(hospedeCtrl.findById(1));

        System.out.println("\nInserir no banco");

        Hospede hospede = new Hospede(null, "hospede", new Date(1990, 1, 8), 123456);
        hospede = hospedeCtrl.insert(hospede);


        for (Hospede h : hospedeCtrl.findAll()) {
            System.out.println(h);
        }


        System.out.println("\nExcluir");
        hospedeCtrl.delete(hospede.getIdHospede());
        System.out.println("\nTerminou");
    }

}
