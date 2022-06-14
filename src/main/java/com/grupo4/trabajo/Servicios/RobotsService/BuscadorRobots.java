package com.grupo4.trabajo.Servicios.RobotsService;

import com.grupo4.trabajo.Pedido;
import com.grupo4.trabajo.Robots.Robot;

import java.util.Collection;

public interface BuscadorRobots {
    Collection<Robot> buscarRobots(Pedido pedido, Collection<Robot> robots);
}
