package com.grupo4.trabajo.Empleado;

import com.grupo4.trabajo.TipoReparacion;

public class Empleado {
    private float sueldo;
    private TipoReparacion tipoReparacion;

    public Empleado(float sueldo, TipoReparacion tipoReparacion) {
        this.sueldo = sueldo;
        this.tipoReparacion = tipoReparacion;
    }

    public float getSueldo() {
        return sueldo;
    }

    public TipoReparacion getTipoReparacion() {
        return tipoReparacion;
    }
}
