package com.grupo4.trabajo.Servicios;

import com.grupo4.trabajo.Pedido;
import com.grupo4.trabajo.Robots.Robot;

import java.util.Collection;

public interface BuscadorRobots {
    public Collection<Robot> buscarRobots(Pedido pedido, Collection<Robot> robots);
}
