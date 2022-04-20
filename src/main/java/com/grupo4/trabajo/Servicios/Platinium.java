package com.grupo4.trabajo.Servicios;

import com.grupo4.trabajo.Pedido;
import com.grupo4.trabajo.Robots.Robot;

import java.util.Collection;

public class Platinium extends Servicio{
    public Platinium(){
        setLimiteDeuda(getCouta());
    }


    public Collection<Robot> buscarRobots(Pedido pedido, Collection<Robot> robots){
        //Condicion de busqueda: los robots con menor cantidad de pedidos pendientes
        return null;
    }

    @Override
    public void validarPedido(Pedido pedido, float deuda) {

    }
}
