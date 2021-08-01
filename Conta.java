
public class Conta {
    private Pessoa cliente;
    private static Integer nrConta = 0;
    private Double saldo;

    public Conta(Pessoa cliente, Double saldo) {
        this.cliente = cliente;
        this.nrConta++;
        this.saldo = saldo;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public Integer getNrConta() {
        return nrConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void abrirConta(Conta conta) {
        new Conta(conta.getCliente(), conta.getSaldo());
    }

    public void sacar(Double valor) {
        saldo = saldo - valor;
    }

    private void debitar(Double valor) {
        saldo = saldo - valor;
    }

    protected boolean temSaldo() {
        return saldo > 0;
    }

    public void depositar(Double valor) {
        saldo = saldo + valor;
    }

    public void transferir(Conta destinatario, Double valor) {
        if (saldo - valor >= 0) {
            debitar(valor);
            destinatario.depositar(valor);
        }
    }
}
