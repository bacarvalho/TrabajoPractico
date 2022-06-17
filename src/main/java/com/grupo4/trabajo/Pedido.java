package com.grupo4.trabajo;

public class Pedido {
    private boolean limpiezaSimple;
    private Superficie limpieza;
    private Superficie ordenamiento;
    private Superficie lustramiento;

    public Pedido(boolean limpiezaSimple, Superficie ordenamiento, Superficie limpieza, Superficie lustramiento){
        this.limpiezaSimple = limpiezaSimple;
        this.ordenamiento = ordenamiento;
        this.limpieza = limpieza;
        this.lustramiento = lustramiento;
    }

    public boolean requiereLimpieza() {
        return limpieza != null;
    }

    public void setLimpieza(Superficie limpieza) {
        this.limpieza = limpieza;
    }


    public boolean limpiezaSimple() {
        return limpiezaSimple;
    }

    public void setLimpiezaSimple(boolean limpiezaSimple) {
        this.limpiezaSimple = limpiezaSimple;
    }

    public boolean requiereOrdenamiento() {
        return ordenamiento != null;
    }

    public void setOrdenamiento(Superficie ordenamiento) {
        this.ordenamiento = ordenamiento;
    }

    public boolean requiereLustramiento() {
        return lustramiento != null;
    }

    public void setLustramiento(Superficie lustramiento) {
        this.lustramiento = lustramiento;
    }

    public Superficie getLimpieza() {
        return limpieza;
    }

    public Superficie getOrdenamiento() {
        return ordenamiento;
    }

    public Superficie getLustramiento() {
        return lustramiento;
    }
}
