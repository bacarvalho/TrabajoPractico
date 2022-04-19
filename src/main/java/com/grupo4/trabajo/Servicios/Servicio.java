package com.grupo4.trabajo.Servicios;

import com.grupo4.trabajo.Pedido;
import com.grupo4.trabajo.Robots.Robot;

import java.util.Collection;

public abstract class Servicio {
    private int cantLimpiezas;
    private int cantOrdenamientos;
    private float limiteDeuda;
    private float couta;

    public void validarPedido(Pedido pedido,float deuda){

    }

    public void asignarRobots(Collection<Robot> Robots){

    }

    public void actualizarServicio(Pedido pedido){

    }


    public int getCantLimpiezas() {
        return cantLimpiezas;
    }

    public void setCantLimpiezas(int cantLimpiezas) {
        this.cantLimpiezas = cantLimpiezas;
    }

    public int getCantOrdenamientos() {
        return cantOrdenamientos;
    }

    public void setCantOrdenamientos(int cantOrdenamientos) {
        this.cantOrdenamientos = cantOrdenamientos;
    }

    public float getLimiteDeuda() {
        return limiteDeuda;
    }

    public void setLimiteDeuda(float limiteDeuda) {
        this.limiteDeuda = limiteDeuda;
    }

    public float getCouta() {
        return couta;
    }

    public void setCouta(float couta) {
        this.couta = couta;
    }
}
