import java.time.LocalDate;
import java.time.LocalTime;

public class SistemaPontoApp {
    public static void main(String[] args) {
        RegistroDiario registro = new RegistroDiario();

        registro.baterEntrada(
                MarcacaoPonto.entrada(LocalTime.of(8,0))
        );

        registro.baterSaidaAlmoco(
                MarcacaoPonto.saidaAlmoco(LocalTime.of(12,0))
        );

        registro.baterVoltaAlmoco(
                MarcacaoPonto.voltaAlmoco(LocalTime.of(13,0))
        );

        registro.baterSaida(
                MarcacaoPonto.saida(LocalTime.of(17,0))
        );

        ApuracaoDiaria apuracao = registro.apurar(LocalDate.now());

        System.out.print("Horas Trabalhadas " + apuracao.getTotalEmHoras());

    }


}
