import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RegistroDiario {

    private Estado estado;
    private List<MarcacaoPonto> marcacoes;

    public RegistroDiario() {
        this.estado = Estado.INICIAL;
        this.marcacoes = new ArrayList<>();
    }

    public void baterEntrada(MarcacaoPonto marcacao) {
        if (marcacao.getTipoPonto() != TipoPonto.ENTRADA)
            throw  new IllegalArgumentException("Marcacao invalida para entrada");
        if(estado != Estado.INICIAL)
            throw new IllegalStateException("Sem registro de estado inicial");
        estado = Estado.ENTRADA;

        marcacoes.add(marcacao);
        estado = Estado.ENTRADA;
    }

    public void baterSaidaAlmoco(MarcacaoPonto marcacao) {
        if (marcacao.getTipoPonto() != TipoPonto.SAIDA_ALMOCO)
            throw  new IllegalArgumentException("Marcacao invalida para saida do almoco");
        if(estado != Estado.ENTRADA)
            throw new IllegalStateException("Sem registro de ponto de entrada");

        marcacoes.add(marcacao);
        estado = Estado.SAIDA_ALMOCO;
    }

    public void baterVoltaAlmoco(MarcacaoPonto marcacao) {
        if (marcacao.getTipoPonto() != TipoPonto.VOLTA_ALMOCO)
            throw  new IllegalArgumentException("Marcacao invalida para volta do almoco");
        if(estado != Estado.SAIDA_ALMOCO)
            throw new IllegalStateException("Sem registro de ponto de saida do almoco");
        marcacoes.add(marcacao);
        estado = Estado.VOLTA_ALMOCO;
    }

    public void baterSaida(MarcacaoPonto marcacao) {
        if (marcacao.getTipoPonto() != TipoPonto.SAIDA)
            throw  new IllegalArgumentException("Marcacao invalida para saida");
        if(estado != Estado.VOLTA_ALMOCO)
            throw new IllegalStateException("Sem registro de ponto de volda do almoco");
        marcacoes.add(marcacao);
        estado = Estado.FECHADO;
    }

    public ApuracaoDiaria apurar(LocalDate data) {
        List<LocalTime> horarios = marcacoes.stream()
                .map(MarcacaoPonto::getHorario)
                .toList();
        return new ApuracaoDiaria(data,horarios);
    }



}
