package com.grupo4.trabajo;

import com.grupo4.trabajo.Servicios.Servicio;

public class Cliente {
    private String direccion;
    private float deuda;
    private Servicio tipoServicio;

    public void pedirPedido(Pedido pedido){
        tipoServicio.validarPedido(pedido,deuda);
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
}
