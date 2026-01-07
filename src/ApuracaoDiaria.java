import java.time.Duration;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.List;

public class ApuracaoDiaria {

    private LocalDate data;
    private List<LocalTime> marcacoes;
    private Duration totalTrabalhado;

    public ApuracaoDiaria(LocalDate data, List<LocalTime> marcacoes) {
        this.data = data;
        this.marcacoes = marcacoes;
        this.totalTrabalhado = calcularTotalTrabalhado();
    }

    private Duration calcularTotalTrabalhado() {
        Duration total = Duration.ZERO;

        for(int i = 0; i < marcacoes.size(); i += 2){

            LocalTime entrada = marcacoes.get(i);
            LocalTime saida = marcacoes.get(i + 1);

            Duration periodo = Duration.between(entrada, saida);
            total = total.plus(periodo);

        }

        return total;
    }

    public Duration getTotalTrabalhado() {
        return totalTrabalhado;
    }

    public int getTotalEmHoras() {
        return totalTrabalhado.toHoursPart();
    }

    public long getTotalEmMinutos() {
        return totalTrabalhado.toMinutesPart();
    }

    public int getTotalEmSegundos() {
        return totalTrabalhado.toSecondsPart();
    }





}
