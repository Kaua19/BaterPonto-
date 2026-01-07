import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class SistemaPontoApp {
    public static void main(String[] args) {
        RegistroDiario registro = new RegistroDiario();

        registro.baterEntrada(
                MarcacaoPonto.entrada(LocalTime.of(06,36, 56))
        );

        registro.baterSaidaAlmoco(
                MarcacaoPonto.saidaAlmoco(LocalTime.of(12,27, 34))
        );

        registro.baterVoltaAlmoco(
                MarcacaoPonto.voltaAlmoco(LocalTime.of(13,40, 45))
        );

        registro.baterSaida(
                MarcacaoPonto.saida(LocalTime.of(14,59, 23))
        );

        ApuracaoDiaria apuracao = registro.apurar(LocalDate.now());

        String formatacao = String.format("%02d:%02d:%02d",
                apuracao.getTotalEmHoras(), apuracao.getTotalEmMinutos(), apuracao.getTotalEmSegundos());

        System.out.print("Horas trabalhadas " + formatacao);
    }


}
