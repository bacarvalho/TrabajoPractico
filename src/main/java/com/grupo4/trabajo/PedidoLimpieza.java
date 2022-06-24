package com.grupo4.trabajo;

public class PedidoLimpieza {
   private boolean limpiezaSimple;
   private Superficie limpieza;
   private TipoResiduos residuo;
   private Superficie ordenamiento;
   private Superficie lustramiento;
   private int CantMascotas;
   private Cliente cliente;


    public PedidoLimpieza( Superficie ordenamiento, Superficie limpieza, Superficie lustramiento, int Mascotas,TipoResiduos residuo , Cliente cliente ){
        this.ordenamiento = ordenamiento;
        this.limpieza = limpieza;
        this.lustramiento = lustramiento;
        this.CantMascotas = Mascotas;
        this.limpiezaSimple = setTipoLimpieza();
        this.cliente = cliente;
        this.residuo = residuo;

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


    private boolean setTipoLimpieza(){
        return (cliente.getDiasDesdeUltimaLimpieza() <= 15 || residuo == TipoResiduos.POLVO || CantMascotas <= 1 && residuo != TipoResiduos.BARRO);

    }



}
