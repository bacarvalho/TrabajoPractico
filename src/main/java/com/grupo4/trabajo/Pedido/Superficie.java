package com.grupo4.trabajo.Pedido;

public class Superficie {
    private SuperficieEnum superficie;
    private TipoResiduos residuo;

    public Superficie(SuperficieEnum superficie){
        this.superficie = superficie;
    }

    public SuperficieEnum getSuperficie() {
        return superficie;
    }

    public void setSuperficie(SuperficieEnum superficie) {
        this.superficie = superficie;
    }

    public TipoResiduos getResiduo() {
        return residuo;
    }

    public void setResiduo(TipoResiduos residuo) {
        this.residuo = residuo;
    }
}
