package com.grupo4.trabajo.Servicios.RobotsService;

import com.grupo4.trabajo.Pedido.PedidoLimpieza;
import com.grupo4.trabajo.Robots.Robot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BuscadorRobotsEconomic implements BuscadorRobots {
    public List<Robot> buscarRobots(PedidoLimpieza pedido, Collection<Robot> robots) {
        List<Robot> robotsPedido = new ArrayList<>();
        if(pedido != null && pedido.requiereLimpieza()){
            Collection<Robot> aux = robots.stream()
                    .filter(robot -> robot.getSuperficie() == pedido.getLimpieza().getSuperficie())
                    .collect(Collectors.toList());
            Robot robot = aux.stream().min(Comparator.comparingDouble(Robot::getCosto)).get();
            robotsPedido.add(robot);
        }
        if(pedido != null && pedido.requiereOrdenamiento()){
            Collection<Robot> aux = robots.stream()
                    .filter(robot -> robot.isPuedeOrdenar() && robot.getSuperficie() == pedido.getOrdenamiento().getSuperficie())
                    .collect(Collectors.toList());
            Robot robot = aux.stream().min(Comparator.comparingDouble(Robot::getCosto)).get();
            robotsPedido.add(robot);
        }
        if(pedido != null && pedido.requiereLustramiento()){
            Collection<Robot> aux = robots.stream()
                    .filter(r -> r.isPuedeLustrar() && r.getSuperficie() == pedido.getLustramiento().getSuperficie())
                    .collect(Collectors.toList());
            Robot robot = aux.stream().min(Comparator.comparingDouble(Robot::getCosto)).get();
            robotsPedido.add(robot);
        }
        return robotsPedido;
    }
}
