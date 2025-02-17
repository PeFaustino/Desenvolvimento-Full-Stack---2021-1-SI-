package br.ufg.inf.fs.dao;

import br.ufg.inf.fs.ctrl.HospedeCtrl;
import br.ufg.inf.fs.ctrl.QuartoCtrl;
import br.ufg.inf.fs.entities.Hospedagem;
import br.ufg.inf.fs.exceptions.HospedagemException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HospedagemDao {
    Connection conn;

    private final QuartoCtrl quartoCtrl = new QuartoCtrl();

    private final HospedeCtrl hospedeCtrl = new HospedeCtrl();

    public HospedagemDao(Connection conn) {
        this.conn = conn;
    }

    public List<Hospedagem> findAll() throws HospedagemException {

        List<Hospedagem> retorno = new ArrayList<Hospedagem>();
        ResultSet rs = null;
        PreparedStatement st = null;
        try {
            String sql = "SELECT id_hospedagem, id_quarto, id_hospede, dt_checkin, dt_checkout FROM tb_hospedagem; ";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Hospedagem hospedagem = new Hospedagem(
                        rs.getInt("id_hospedagem"),
                        quartoCtrl.findById(rs.getInt("id_quarto")),
                        hospedeCtrl.findById(rs.getInt("id_hospede")),
                        rs.getDate("dt_checkin"),
                        rs.getDate("dt_checkout"));

                retorno.add(hospedagem);
            }
        } catch (SQLException e) {
            throw new HospedagemException("Erro no banco de dados: " + e.getMessage());
        } finally {
            DB.closeStatment(st);
            DB.closeResultSet(rs);
        }
        return retorno;
    }

    public Hospedagem findById(Integer id) throws HospedagemException {

        Hospedagem retorno = new Hospedagem();
        ResultSet rs = null;
        PreparedStatement st = null;
        try {

            String sql = "SELECT id_hospedagem, id_quarto, id_hospede, dt_checkin, dt_checkout FROM tb_hospedagem WHERE id_hospedagem = " + id;
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if (rs.next()) {
                retorno = new Hospedagem(
                        rs.getInt("id_hospedagem"),
                        quartoCtrl.findById(rs.getInt("id_quarto")),
                        hospedeCtrl.findById(rs.getInt("id_hospede")),
                        rs.getDate("dt_checkin"),
                        rs.getDate("dt_checkout"));
            }
        } catch (SQLException e) {
            throw new HospedagemException("Erro no banco de dados: " + e.getMessage());
        } finally {
            DB.closeStatment(st);
            DB.closeResultSet(rs);
        }
        return retorno;
    }

    public Hospedagem insert(Hospedagem hospedagem) throws HospedagemException {

        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(" "
                            + "INSERT INTO tb_hospedagem "
                            + "( id_quarto, id_hospede, dt_checkin, dt_checkout ) "
                            + "VALUES (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, hospedagem.getQuarto().getIdQuarto());
            st.setInt(2, hospedagem.getHospede().getIdHospede());
            st.setDate(3, hospedagem.getCheckin());
            st.setDate(4, hospedagem.getCheckout());
            int rowsAffected = st.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    hospedagem.setIdHospedagem(rs.getInt(1));
                }
            } else {
                throw new HospedagemException("A��o inesperada! Nenhuma linha foi inserida.");
            }
        } catch (SQLException e) {
            throw new HospedagemException("Erro no banco de dados: " + e.getMessage());
        } finally {
            DB.closeStatment(st);
        }
        return hospedagem;
    }

    public Hospedagem update(Hospedagem hospedagem) throws HospedagemException {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(" "
                    + "UPDATE tb_hospedagem "
                    + "SET id_quarto = ?, id_hospede = ?, dt_checkin = ?, dt_checkout = ? "
                    + "WHERE id_hospedagem = ? ");

            st.setInt(1, hospedagem.getQuarto().getIdQuarto());
            st.setInt(2, hospedagem.getHospede().getIdHospede());
            st.setDate(3, hospedagem.getCheckin());
            st.setDate(4, hospedagem.getCheckout());
            st.setInt(5, hospedagem.getIdHospedagem());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new HospedagemException("Erro no banco de dados: " + e.getMessage());
        } finally {
            DB.closeStatment(st);
        }
        return hospedagem;
    }


    public void delete(Integer id) throws HospedagemException {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "DELETE FROM tb_hospedagem WHERE id_hospedagem = ?");
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new HospedagemException("Erro no banco de dados: " + e.getMessage());
        } finally {
            DB.closeStatment(st);
        }
    }
}
