package com.grupo4.trabajo.Servicios.RobotsService;

import com.grupo4.trabajo.Pedido;
import com.grupo4.trabajo.Robots.Robot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

public class BuscadorRobotsEconomic implements BuscadorRobots {
    public Collection<Robot> buscarRobots(Pedido pedido, Collection<Robot> robots) {
        Collection<Robot> robotsPedido = new ArrayList<>();
        if(pedido.requiereLimpieza()){
            Collection<Robot> aux = robots.stream()
                    .filter(robot -> robot.getSuperficie() == pedido.getLimpieza().getSuperficie())
                    .collect(Collectors.toList());
            Robot robot = aux.stream().min(Comparator.comparingDouble(Robot::getCosto)).get();
            robotsPedido.add(robot);
        }
        if(pedido.requiereOrdenamiento()){
            Collection<Robot> aux = robots.stream()
                    .filter(robot -> robot.isPuedeOrdenar() && robot.getSuperficie() == pedido.getOrdenamiento().getSuperficie())
                    .collect(Collectors.toList());
            Robot robot = aux.stream().min(Comparator.comparingDouble(Robot::getCosto)).get();
            robotsPedido.add(robot);
        }
        if(pedido.requiereLustramiento()){
            Collection<Robot> aux = robots.stream()
                    .filter(r -> r.isPuedeLustrar() && r.getSuperficie() == pedido.getLustramiento().getSuperficie())
                    .collect(Collectors.toList());
            Robot robot = aux.stream().min(Comparator.comparingDouble(Robot::getCosto)).get();
            robotsPedido.add(robot);
        }
        return robotsPedido;
    }
}
