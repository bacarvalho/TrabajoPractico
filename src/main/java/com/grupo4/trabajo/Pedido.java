package com.grupo4.trabajo;

import com.grupo4.trabajo.Robots.Superficie;

public class Pedido {
    private boolean limpiezaSimple;
    private boolean requiereLimpieza;
    private boolean ordenamiento;
    private Superficie superficie;

    public Pedido(boolean limpiezaSimple,boolean ordenamiento,Superficie superficie, boolean requiereLimpieza){
        this.limpiezaSimple = limpiezaSimple;
        this.ordenamiento = ordenamiento;
        this.superficie = superficie;
        this.requiereLimpieza = requiereLimpieza;
    }

    public boolean isRequiereLimpieza() {
        return requiereLimpieza;
    }

    public void setRequiereLimpieza(boolean requiereLimpieza) {
        this.requiereLimpieza = requiereLimpieza;
    }

    public void setSuperficie(Superficie superficie) {
        this.superficie = superficie;
    }

    public boolean isLimpiezaSimple() {
        return limpiezaSimple;
    }

    public void setLimpiezaSimple(boolean limpiezaSimple) {
        this.limpiezaSimple = limpiezaSimple;
    }

    public boolean isOrdenamiento() {
        return ordenamiento;
    }

    public void setOrdenamiento(boolean ordenamiento) {
        this.ordenamiento = ordenamiento;
    }

}
