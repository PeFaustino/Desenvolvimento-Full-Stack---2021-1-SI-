
public class ContaPoupanca extends Conta {
    private Double txCorrecao;

    public ContaPoupanca(Pessoa cliente, Double saldo, Double txCorrecao) {
        super(cliente, saldo);
        this.txCorrecao = txCorrecao;
    }

    public Double getTxCorrecao() {
        return txCorrecao;
    }

    public void setTxCorrecao(Double txCorrecao) {
        this.txCorrecao = txCorrecao;
    }

    public void atualizaSaldoRendimento() {
        Double valor = super.getSaldo() * txCorrecao;
        super.depositar(valor);
    }

    public void abrirConta(Conta conta) {
        super.abrirConta(conta);
    }
}
