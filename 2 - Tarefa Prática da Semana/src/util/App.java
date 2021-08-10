package util;

import br.ufg.inf.fs.ctrl.HospedagemCtrl;
import br.ufg.inf.fs.ctrl.HospedeCtrl;
import br.ufg.inf.fs.ctrl.HotelCtrl;
import br.ufg.inf.fs.ctrl.QuartoCtrl;
import br.ufg.inf.fs.entities.Hospedagem;
import br.ufg.inf.fs.entities.Hospede;
import br.ufg.inf.fs.entities.Hotel;
import br.ufg.inf.fs.entities.Quarto;
import br.ufg.inf.fs.enums.CategoriaQuarto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class App {

    public static void testeSystem() {

        System.out.println("Hello World");
        System.err.println("Hello World com erro");

    }

    public static void main(String[] args) {

        testeCrudHospedagem();
    }

    public static void testeConexcao() {
        try {
            Connection con = (Connection) DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_hotel", "developer", "1234");
            System.out.println("Conex�o funcionou");
        } catch (SQLException e) {
            System.err.println("Conex�o n�o funcionou");
            System.out.println(e.getMessage());
        }
    }


    public static void testeCrudHotel() {

        HotelCtrl ctrl = new HotelCtrl();

        System.out.println("Lista de Hoteis Cadastrados");
        for (Hotel h : ctrl.findAll()) {
            System.out.println(h);
        }

        System.out.println("Buscar pelo #ID 1");
        Hotel hotel = ctrl.findById(1);
        System.out.println(hotel);

        System.out.println("Cadastrar novo Hotel");

        Hotel h1 = new Hotel(null, "Hotel Goi�nia", "Goi�nia", 3);
        //h1 = ctrl.insert(h1);
        System.out.println(h1);

        Hotel h2 = ctrl.findById(3);
        System.out.println("UPDATE");
        System.out.println("#ID original: " + h2);
        h2.setNmHotel(h2.getNmHotel() + " ALTERADO");
        h2 = ctrl.update(h2);
        System.out.println("#ID alterado: " + h2);


        System.out.println("Lista de Hoteis Cadastrados");
        for (Hotel h : ctrl.findAll()) {
            System.out.println(h);
        }
        System.out.println("Deletar #ID 4");
        ctrl.delete(4);

        System.out.println("Lista de Hoteis Atualizado");
        for (Hotel h : ctrl.findAll()) {
            System.out.println(h);
        }


    }

    public static void testeCrudQuarto() {

        QuartoCtrl ctrl = new QuartoCtrl();

        HotelCtrl hotelCtrl = new HotelCtrl();

        System.out.println("Lista de Quartos Cadastrados");
        for (Quarto q : ctrl.findAll()) {
            System.out.println(q);
        }

        System.out.println("Buscar pelo #ID 1");
        Quarto quarto = ctrl.findById(1);
        System.out.println(quarto);

        System.out.println("Cadastrar novo Hotel");

        Quarto q1 = new Quarto(null,
                hotelCtrl.findById(1),
                CategoriaQuarto.APARTAMENTO,
                3,
                120,
                240.0);
        //q1 = ctrl.insert(q1);
        System.out.println(q1);

        Quarto q2 = ctrl.findById(3);
        System.out.println("UPDATE");
        System.out.println("#ID original: " + q2);
        q2.setPrDiaria(q2.getPrDiaria() != null ? q2.getPrDiaria() + 20 : 20);
        q2 = ctrl.update(q2);
        System.out.println("#ID alterado: " + q2);


        System.out.println("Lista de Quartos Cadastrados");
        for (Quarto h : ctrl.findAll()) {
            System.out.println(h);
        }
        System.out.println("Deletar #ID 3");
        ctrl.delete(3);

        System.out.println("Lista de Quartos Atualizado");
        for (Quarto q : ctrl.findAll()) {
            System.out.println(q);
        }


    }

    public static void testeCrudHospede() {
        HospedeCtrl ctrl = new HospedeCtrl();

        List<Hospede> hospedeList = ctrl.findAll();
        if (hospedeList.isEmpty()) {
            System.out.println("Não há Hospedes Cadastrados");
        } else {
            System.out.println("Lista de Hospedes Cadastrados");
            for (Hospede q : hospedeList) {
                System.out.println(q);
            }
        }

        System.out.println("\nCadastrar novo Hospede");
        Hospede hospede = new Hospede();
        hospede.setNmHospede("hospede");
        hospede.setCpf(123456);
        hospede.setDtNascimento(new Date(1990, 1, 8));
        hospede = ctrl.insert(hospede);
        System.out.println(hospede);

        System.out.println("\nAtualizar Hospede");
        hospede.setNmHospede("hospede " + hospede.getIdHospede() +  " atualizado");
        hospede = ctrl.update(hospede);
        System.out.println(hospede);

        System.out.println("\nBuscar por id");
        hospede = ctrl.findById(hospede.getIdHospede());
        System.out.println(hospede);

        System.out.println("\nExcluir por id");
        ctrl.delete(hospede.getIdHospede());

        System.out.println("Lista de Hospedes Cadastrados");
        for (Hospede q : ctrl.findAll()) {
            System.out.println(q);
        }


    }

    public static void testeCrudHospedagem() {
        HospedagemCtrl ctrl = new HospedagemCtrl();
        HospedeCtrl hospedeCtrl = new HospedeCtrl();
        QuartoCtrl quartoCtrl = new QuartoCtrl();
        HotelCtrl hotelCtrl = new HotelCtrl();

        List<Hospedagem> hospedagemList = ctrl.findAll();
        if (hospedagemList.isEmpty()) {
            System.out.println("Não há Hospedagens Cadastradas");
        } else {
            System.out.println("Lista de Hospedagens Cadastradas");
            for (Hospedagem q : hospedagemList) {
                System.out.println(q);
            }
        }

        Hospede hospede = getHospede(hospedeCtrl);
        Hotel hotel = getHotel(hotelCtrl);
        Quarto quarto = getQuarto(quartoCtrl, hotel);

        System.out.println("\nCadastrar nova Hospedagem");
        Hospedagem hospedagem = new Hospedagem(null, quarto, hospede, new Date(1990, 1, 8), new Date(1990, 1, 8));
        hospedagem = ctrl.insert(hospedagem);
        System.out.println(hospedagem);

        System.out.println("Lista de Hospedagens Cadastradas");
        for (Hospedagem q : ctrl.findAll()) {
            System.out.println(q);
        }



    }

    private static Quarto getQuarto(QuartoCtrl quartoCtrl, Hotel hotel) {
        Quarto quarto = new Quarto(null, hotel, CategoriaQuarto.APARTAMENTO, 10, 5, 20.5);
        quarto = quartoCtrl.insert(quarto);
        return quarto;
    }

    private static Hotel getHotel(HotelCtrl hotelCtrl) {
        Hotel hotel = new Hotel(null, "Hotel Goiânia", "Goiânia", 3);
        hotel = hotelCtrl.insert(hotel);
        return hotel;
    }

    private static Hospede getHospede(HospedeCtrl hospedeCtrl) {
        Hospede hospede = new Hospede(null, "hospede", new Date(1990, 1, 8), 123456);
        hospede = hospedeCtrl.insert(hospede);
        return hospede;
    }
}
