
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Main {

    public static void main(String args[]) {
        List<ContaPoupanca> contasPoupanca = new ArrayList<>();
        List<ContaEspecial> contasEspecial = new ArrayList<>();


        for (int i = 1; i < 5; i++) {
            Calendar dtNascimento = Calendar.getInstance();
            dtNascimento.set(1990, Calendar.JANUARY, i);

            PessoaFisica p = new PessoaFisica("Joao " + i, "Goiânia", 123456, dtNascimento, "M");
            ContaPoupanca cp = new ContaPoupanca(p, 1500.0, 0.1);
            contasPoupanca.add(cp);

            PessoaJuridica pj = new PessoaJuridica("Pedro " + i, "Goiânia", 987654321, "Analista");
            ContaEspecial ce = new ContaEspecial(pj, 600.0, 3000.0);
            contasEspecial.add(ce);
        }

        contasPoupanca.get(0).transferir(contasEspecial.get(0), 400.0);
        contasPoupanca.get(1).atualizaSaldoRendimento();
        contasEspecial.get(3).sacar(3000.0);

        AtomicReference<Double> somaSaldo = new AtomicReference<>(0.0);

        contasPoupanca.forEach(contaPoupanca -> {
            System.out.println("Nome: " + contaPoupanca.getCliente().getNome());
            System.out.println("Saldo: " + contaPoupanca.getSaldo() + "\n");
            somaSaldo.updateAndGet(v -> v + contaPoupanca.getSaldo());
        });

        contasEspecial.forEach(contaEspecial -> {
            System.out.println("Nome: " + contaEspecial.getCliente().getNome());
            System.out.println("Saldo: " + contaEspecial.getSaldo() + "\n");
            somaSaldo.updateAndGet(v -> v + contaEspecial.getSaldo());
        });

        System.out.println("Soma Saldo: " + somaSaldo);

    }
}
