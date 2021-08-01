
import java.time.Duration;
import java.util.Calendar;

public class PessoaFisica extends Pessoa {
    private Integer cpf;
    private Calendar dtNascimento;
    private String genero;

    public PessoaFisica(String nome, String endereco, Integer cpf, Calendar dtNascimento, String genero) {
        super(nome, endereco);
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
        this.genero = genero;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public Calendar getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Calendar dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public long getIdade() {
        Calendar cal = Calendar.getInstance();
        long d = Duration.between(dtNascimento.toInstant(), cal.toInstant()).toDays();
        return d / 365;
    }
}
