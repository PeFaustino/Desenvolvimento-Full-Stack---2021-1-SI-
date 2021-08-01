
public class ContaEspecial extends Conta {
    private Double limite;

    public ContaEspecial(Pessoa cliente, Double saldo, Double limite) {
        super(cliente, saldo);
        this.limite = limite;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    protected boolean temSaldo() {
        return super.temSaldo();
    }

    public void abrirConta(Conta conta) {
        super.abrirConta(conta);
    }

    public void sacar(Double valor) {
        if (valor <= limite) super.sacar(valor);
    }
}
