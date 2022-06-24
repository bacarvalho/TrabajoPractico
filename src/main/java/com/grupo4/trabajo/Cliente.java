package com.grupo4.trabajo;

import com.grupo4.trabajo.Exceptions.EsDeudorException;
import com.grupo4.trabajo.Exceptions.NoCantLimpiezasDisponibleException;
import com.grupo4.trabajo.Exceptions.NoCantOrdenamientoDisponibleException;
import com.grupo4.trabajo.Servicios.ServicioCliente.Servicio;

public class Cliente {
    private String direccion;
    private float deuda;
    private Servicio tipoServicio;
    int DiasDesdeUltimaLimpieza;



    public Cliente(Servicio tipoServicio){
        this.tipoServicio = tipoServicio;
    }

    public void pedirPedido(Pedido pedido) throws EsDeudorException, NoCantOrdenamientoDisponibleException, NoCantLimpiezasDisponibleException {
        tipoServicio.realizarPedido(pedido,this);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public float getDeuda() {
        return deuda;
    }

    public void setDeuda(float deuda) {
        this.deuda = deuda;
    }

    public Servicio getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(Servicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }
    public int getDiasDesdeUltimaLimpieza() {
        return DiasDesdeUltimaLimpieza;
    }

    public void setDiasDesdeUltimaLimpieza(int diasDesdeUltimaLimpieza) {
        this.DiasDesdeUltimaLimpieza = diasDesdeUltimaLimpieza;
    }
}
