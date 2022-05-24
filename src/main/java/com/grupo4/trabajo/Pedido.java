package com.grupo4.trabajo;

import com.grupo4.trabajo.Robots.SuperficieEnum;

public class Pedido {
    private boolean limpiezaSimple;
    private Superficie requiereLimpieza;
    private Superficie ordenamiento;
    private Superficie requiereLustramiento;

    public Pedido(boolean limpiezaSimple, Superficie ordenamiento, Superficie requiereLimpieza, Superficie requiereLustramiento){
        this.limpiezaSimple = limpiezaSimple;
        this.ordenamiento = ordenamiento;
        this.requiereLimpieza = requiereLimpieza;
        this.requiereLustramiento = requiereLustramiento;
    }

    public Superficie requiereLimpieza() {
        return requiereLimpieza;
    }

    public void setRequiereLimpieza(Superficie requiereLimpieza) {
        this.requiereLimpieza = requiereLimpieza;
    }


    public boolean limpiezaSimple() {
        return limpiezaSimple;
    }

    public void setLimpiezaSimple(boolean limpiezaSimple) {
        this.limpiezaSimple = limpiezaSimple;
    }

    public Superficie requiereOrdenamiento() {
        return ordenamiento;
    }

    public void setOrdenamiento(Superficie ordenamiento) {
        this.ordenamiento = ordenamiento;
    }

    public Superficie requiereLustramiento() {
        return requiereLustramiento;
    }

    public void setRequiereLustramiento(Superficie requiereLustramiento) {
        this.requiereLustramiento = requiereLustramiento;
    }

}
