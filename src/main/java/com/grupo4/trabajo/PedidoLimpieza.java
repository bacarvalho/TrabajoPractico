package com.grupo4.trabajo;

public class PedidoLimpieza {
   private boolean limpiezaSimple;
   private Superficie limpieza;
   private Superficie ordenamiento;
   private Superficie lustramiento;
   private int cantMascotas;
   private int diasUltimaLimpieza;


    public PedidoLimpieza( Superficie ordenamiento, Superficie limpieza, Superficie lustramiento, int mascotas, Cliente cliente ){
        this.ordenamiento = ordenamiento;
        this.limpieza = limpieza;
        this.lustramiento = lustramiento;
        this.cantMascotas = mascotas;
        this.limpiezaSimple = LimpiezaSimple();
        this.diasUltimaLimpieza = cliente.getDiasDesdeUltimaLimpieza();

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


    private boolean LimpiezaSimple(){
        return (diasUltimaLimpieza <= 15 || limpieza.getResiduo() == TipoResiduos.POLVO) && (cantMascotas <= 1 && limpieza.getResiduo() != TipoResiduos.BARRO);

    }

    public boolean isLimpiezaSimple() {
        return limpiezaSimple;
    }
}
