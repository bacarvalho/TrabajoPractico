package com.grupo4.trabajo;

public class PedidoLimpieza {

    private boolean limpiezaSimple;
    private Superficie limpieza;
    private Superficie ordenamiento;
    private Superficie lustramiento;
    private int cantMascotas;
    private int diasUltimaLimpieza;


    public PedidoLimpieza(Superficie ordenamiento, Superficie limpieza, Superficie lustramiento, int mascotas, int diasUltimaLimpieza){
        this.ordenamiento = ordenamiento;
        this.limpieza = limpieza;
        this.lustramiento = lustramiento;
        this.cantMascotas = mascotas;
        this.diasUltimaLimpieza = diasUltimaLimpieza;

    }

    public boolean requiereLimpieza(){
        return limpieza != null;


    }

    public boolean requiereOrdenamiento(){
        return ordenamiento != null;



    }

    public boolean requiereLustramiento(){
        return lustramiento != null;



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


    public boolean LimpiezaSimple(){
        return diasUltimaLimpieza <= 15 && cantMascotas <= 1 && limpieza.getResiduo() != TipoResiduos.BARRO;

    }

    public boolean isLimpiezaSimple() {
        return limpiezaSimple;
    }
}
