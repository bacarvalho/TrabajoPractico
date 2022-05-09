package com.grupo4.trabajo;

import com.grupo4.trabajo.Robots.Superficie;

public class Pedido {
    private boolean limpiezaSimple;
    private boolean requiereLimpieza;
    private boolean ordenamiento;
    private boolean requiereLustramiento;
    private Superficie superficie;

    public Pedido(boolean limpiezaSimple,boolean ordenamiento,Superficie superficie, boolean requiereLimpieza,boolean requiereLustramiento){
        this.limpiezaSimple = limpiezaSimple;
        this.ordenamiento = ordenamiento;
        this.superficie = superficie;
        this.requiereLimpieza = requiereLimpieza;
        this.requiereLustramiento = requiereLustramiento;
    }

    public boolean requiereLimpieza() {
        return requiereLimpieza;
    }

    public void setRequiereLimpieza(boolean requiereLimpieza) {
        this.requiereLimpieza = requiereLimpieza;
    }

    public void setSuperficie(Superficie superficie) {
        this.superficie = superficie;
    }

    public boolean limpiezaSimple() {
        return limpiezaSimple;
    }

    public void setLimpiezaSimple(boolean limpiezaSimple) {
        this.limpiezaSimple = limpiezaSimple;
    }

    public boolean requiereOrdenamiento() {
        return ordenamiento;
    }

    public void setOrdenamiento(boolean ordenamiento) {
        this.ordenamiento = ordenamiento;
    }

    public Superficie getSuperficie() {
        return superficie;
    }

    public boolean requiereLustramiento() {
        return requiereLustramiento;
    }

    public void setRequiereLustramiento(boolean requiereLustramiento) {
        this.requiereLustramiento = requiereLustramiento;
    }

}
