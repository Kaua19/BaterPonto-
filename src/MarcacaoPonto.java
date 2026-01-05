import java.time.LocalTime;
import java.util.Objects;

public class MarcacaoPonto {

   private final TipoPonto tipoPonto;
   private final LocalTime horario;

    public MarcacaoPonto(TipoPonto tipoPonto, LocalTime horario) {
        this.tipoPonto = Objects.requireNonNull(tipoPonto,"Tipo do ponto obrigatorio");
        this.horario = Objects.requireNonNull(horario, "Horario obrigatorio");
    }

    public TipoPonto getTipoPonto() {
        return tipoPonto;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public static MarcacaoPonto entrada(LocalTime horario) {
        return new MarcacaoPonto(TipoPonto.ENTRADA, horario);
    }

    public static MarcacaoPonto saidaAlmoco(LocalTime horario) {
        return new MarcacaoPonto(TipoPonto.SAIDA_ALMOCO, horario);
    }

    public static MarcacaoPonto voltaAlmoco(LocalTime horario) {
        return new MarcacaoPonto(TipoPonto.VOLTA_ALMOCO, horario);
    }

    public static MarcacaoPonto saida(LocalTime horario) {
        return new MarcacaoPonto(TipoPonto.SAIDA, horario);
    }

}
