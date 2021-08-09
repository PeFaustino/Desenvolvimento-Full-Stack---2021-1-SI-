package br.ufg.inf.fs.entities;


import java.sql.Date;

public class Hospedagem {

    private Integer idHospedagem;
    private Quarto quarto;
    private Hospede hospede;
    private Date checkin;
    private Date checkout;

    public Hospedagem() {
        super();
    }

    public Hospedagem(Integer idHospedagem, Quarto quarto, Hospede hospede, Date checkin, Date checkout) {
        super();
        this.idHospedagem = idHospedagem;
        this.quarto = quarto;
        this.hospede = hospede;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getIdHospedagem() {
        return idHospedagem;
    }

    public void setIdHospedagem(Integer idHospedagem) {
        this.idHospedagem = idHospedagem;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "Hospedagem [idHospedagem=" + idHospedagem +
                ", quarto=" + quarto +
                ", hospede=" + hospede +
                ", checkin=" + checkin +
                ", checkout=" + checkout + "]";
    }

}
