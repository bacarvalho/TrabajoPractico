package com.grupo4.trabajo;

import lombok.Getter;
import lombok.Setter;

public class Pedido {

    @Getter @Setter
    private boolean limpiezaSimple;

    @Getter @Setter
    private Superficie limpieza;

    @Getter @Setter
    private Superficie ordenamiento;

    @Getter @Setter
    private Superficie lustramiento;

    public Pedido(boolean limpiezaSimple, Superficie ordenamiento, Superficie requiereLimpieza, Superficie requiereLustramiento){
        this.limpiezaSimple = limpiezaSimple;
        this.ordenamiento = ordenamiento;
        this.limpieza = requiereLimpieza;
        this.lustramiento = requiereLustramiento;
    }

    public boolean requiereLimpieza() {
        return limpieza != null;
    }

    public boolean requiereOrdenamiento() {
        return ordenamiento != null;
    }

    public boolean requiereLustramiento() {
        return lustramiento != null;
    }
}
