package com.grupo4.trabajo.Servicios;

import com.grupo4.trabajo.Pedido;
import com.grupo4.trabajo.Robots.Robot;

import java.util.Collection;
import java.util.Iterator;

public abstract class Servicio {
    private int cantLimpiezas;
    private int cantOrdenamientos;
    private float limiteDeuda;
    private float couta;

    public abstract void validarPedido(Pedido pedido,float deuda);

    public float asignarRobots(Collection<Robot> robots,Pedido pedido){

        Collection<Robot> robotsPedido = buscarRobots(pedido,robots);

        float costo = 0f;
        Iterator<Robot> it = robotsPedido.iterator();
        while(it.hasNext()){
            it.next().agregarPedido(pedido);
            costo += it.next().getCosto();
        }
        return costo;
    }

    public Collection<Robot> buscarRobots(Pedido pedido, Collection<Robot> robots){
        //condicion de busqueda: los robots mas economicos
        return null;
    }

    public void actualizarServicio(Pedido pedido, float costo) {
        if (pedido.isRequiereLimpieza()) {
            setCantLimpiezas(getCantLimpiezas() - 1);
        }
        if (pedido.isOrdenamiento()) {
            setCantOrdenamientos(getCantOrdenamientos() - 1);
        }

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
