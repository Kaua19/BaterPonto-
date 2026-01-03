public class RegistroDiario {

    private Estado estado;

    public RegistroDiario() {
        this.estado = Estado.INICIAL;
    }

    public void baterEntrada(MarcacaoPonto marcacao) {
        if (marcacao.getTipoPonto() != TipoPonto.ENTRADA)
            throw  new IllegalArgumentException("Marcacao invalida para entrada");
        if(estado != Estado.INICIAL)
            throw new IllegalStateException("Sem registro de estado inicial");
        estado = Estado.ENTRADA;
    }

    public void baterSaidaAlmoco(MarcacaoPonto marcacao) {
        if (marcacao.getTipoPonto() != TipoPonto.SAIDA_ALMOCO)
            throw  new IllegalArgumentException("Marcacao invalida para saida do almoco");
        if(estado != Estado.ENTRADA)
            throw new IllegalStateException("Sem registro de ponto de entrada");
        estado = Estado.SAIDA_ALMOCO;
    }

    public void baterVoltaAlmoco(MarcacaoPonto marcacao) {
        if (marcacao.getTipoPonto() != TipoPonto.VOLTA_ALMOCO)
            throw  new IllegalArgumentException("Marcacao invalida para volta do almoco");
        if(estado != Estado.SAIDA_ALMOCO)
            throw new IllegalStateException("Sem registro de ponto de saida do almoco");
        estado = Estado.VOLTA_ALMOCO;
    }

    public void baterSaida(MarcacaoPonto marcacao) {
        if (marcacao.getTipoPonto() != TipoPonto.SAIDA)
            throw  new IllegalArgumentException("Marcacao invalida para saida");
        if(estado != Estado.VOLTA_ALMOCO)
            throw new IllegalStateException("Sem registro de ponto de volda do almoco");
        estado = Estado.FECHADO;
    }



}
