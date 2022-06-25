package com.grupo4.trabajo;

public class PedidoReparacion {
    TipoReparacion reparacion;
    int complejidad;


    public PedidoReparacion( TipoReparacion tipoReparacion, int ComplejidadTrabajo ){
        this.reparacion = tipoReparacion;
        this.complejidad = ComplejidadTrabajo;


    }

    public boolean requiereReparacion(){
        return reparacion != null;


    }


    public TipoReparacion getReparacion() {
        return reparacion;
    }

    public void setReparacion(TipoReparacion reparacion) {
        this.reparacion = reparacion;
    }

    public int getComplejidad() {
        return complejidad;
    }

    public void setComplejidad(int complejidad) {
        this.complejidad = complejidad;
    }
}
