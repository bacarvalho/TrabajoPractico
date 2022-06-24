package com.grupo4.trabajo;

public class PedidoReparacion {
    TipoReparacion reparacion;
    int complejidad;
    private Cliente cliente;


    public PedidoReparacion( TipoReparacion tipoReparacion, int ComplejidadTrabajo ){
        this.reparacion = tipoReparacion;
        this.complejidad = ComplejidadTrabajo;


    }

    public boolean requiereReparacion(){
        return reparacion != null;


    }











}
