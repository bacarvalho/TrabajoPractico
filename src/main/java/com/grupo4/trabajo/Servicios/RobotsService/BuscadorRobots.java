package com.grupo4.trabajo.Servicios.RobotsService;

import com.grupo4.trabajo.Pedido.PedidoLimpieza;
import com.grupo4.trabajo.Robots.Robot;

import java.util.Collection;
import java.util.List;

public interface BuscadorRobots {
    List<Robot> buscarRobots(PedidoLimpieza pedido, Collection<Robot> robots);
}
