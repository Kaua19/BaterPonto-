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
}
