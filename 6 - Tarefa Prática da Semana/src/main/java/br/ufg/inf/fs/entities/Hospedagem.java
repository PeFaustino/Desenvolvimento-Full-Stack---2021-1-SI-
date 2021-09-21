package br.ufg.inf.fs.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "tb_hospedagem")
public class Hospedagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hospedagem")
    private Integer idHospedagem;

    @OneToOne
    @JoinColumn(name = "id_hospede")
    private Hospede hospede;

    @OneToOne
    @JoinColumn(name = "id_quarto")
    private Quarto quarto;

    @Column(name = "dt_checkin")
    private Date dtCheckin;

    @Column(name = "dt_checkout")
    private Date dtCheckout;

    public Hospedagem() {
        super();
    }

    public Hospedagem(Integer idHospedagem, Hospede hospede, Quarto quarto, Date dtCheckin, Date dtCheckout) {
        super();
        this.idHospedagem = idHospedagem;
        this.hospede = hospede;
        this.quarto = quarto;
        this.dtCheckin = dtCheckin;
        this.dtCheckout = dtCheckout;
    }

    public Integer getIdHospedagem() {
        return idHospedagem;
    }

    public void setIdHospedagem(Integer idHospedagem) {
        this.idHospedagem = idHospedagem;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Date getDtCheckin() {
        return dtCheckin;
    }

    public void setDtCheckin(Date dtCheckin) {
        this.dtCheckin = dtCheckin;
    }

    public Date getDtCheckout() {
        return dtCheckout;
    }

    public void setDtCheckout(Date dtCheckout) {
        this.dtCheckout = dtCheckout;
    }

    @Override
    public String toString() {
        return "Hospedagem{" +
                "idHospedagem=" + idHospedagem +
                ", hospede=" + hospede +
                ", quarto=" + quarto +
                ", dtCheckin=" + dtCheckin +
                ", dtCheckout=" + dtCheckout +
                '}';
    }
}
