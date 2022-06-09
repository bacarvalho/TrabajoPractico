package com.grupo4.trabajo.Servicios;

import com.grupo4.trabajo.Pedido;
import com.grupo4.trabajo.Robots.Robot;

import java.util.Collection;
import java.util.Iterator;

public class RobotsService {
    private BuscadorRobots buscadorRobots;

    public void agregarPedidoRobots(Collection<Robot> robots, Pedido pedido){
        Iterator<Robot> it = robots.iterator();
        while(it.hasNext()){
            it.next().agregarPedido(pedido);
        }
    }
    public BuscadorRobots getBuscadorRobots() {
        return buscadorRobots;
    }

    public void setBuscadorRobots(BuscadorRobots buscadorRobots) {
        this.buscadorRobots = buscadorRobots;
    }

}
