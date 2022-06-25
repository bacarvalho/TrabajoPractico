package com.grupo4.trabajo;

public class PedidoLimpieza {
   private boolean limpiezaSimple;
   private Superficie limpieza;
   private Superficie ordenamiento;
   private Superficie lustramiento;
   private int CantMascotas;
   private int DiasUltimaLimpieza;


    public PedidoLimpieza( Superficie ordenamiento, Superficie limpieza, Superficie lustramiento, int Mascotas, Cliente cliente ){
        this.ordenamiento = ordenamiento;
        this.limpieza = limpieza;
        this.lustramiento = lustramiento;
        this.CantMascotas = Mascotas;
        this.limpiezaSimple = LimpiezaSimple();
        this.DiasUltimaLimpieza = cliente.getDiasDesdeUltimaLimpieza();

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
        return (DiasUltimaLimpieza <= 15 || limpieza.getResiduo() == TipoResiduos.POLVO || CantMascotas <= 1 && limpieza.getResiduo() != TipoResiduos.BARRO);

    }

    public boolean isLimpiezaSimple() {
        return limpiezaSimple;
    }
}
