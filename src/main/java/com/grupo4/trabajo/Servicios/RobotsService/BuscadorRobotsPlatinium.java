package com.grupo4.trabajo.Servicios.RobotsService;

import com.grupo4.trabajo.Pedido;
import com.grupo4.trabajo.Robots.Robot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

public class BuscadorRobotsPlatinium implements BuscadorRobots {

    public Collection<Robot> buscarRobots(Pedido pedido, Collection<Robot> robots) {
        Collection<Robot> robotsPedido = new ArrayList<>();
        Robot robot = robots.stream().min(Comparator.comparingInt(Robot::getIntPedidosPendientes)).get();
        if(robot.isPuedeLustrar() && robot.isPuedeOrdenar())
            robotsPedido.add(robot);
        else {
            if (pedido.requiereOrdenamiento()) {
                Collection<Robot> aux = robots.stream()
                        .filter(r -> r.isPuedeOrdenar() && r.getSuperficie() == pedido.getOrdenamiento().getSuperficie())
                        .collect(Collectors.toList());
                Robot robotAux = aux.stream().min(Comparator.comparingDouble(Robot::getIntPedidosPendientes)).get();
                robotsPedido.add(robotAux);
            }
            if (pedido.requiereLustramiento()) {
                Collection<Robot> aux = robots.stream()
                        .filter(r -> r.isPuedeLustrar() && r.getSuperficie() == pedido.getLustramiento().getSuperficie())
                        .collect(Collectors.toList());
                Robot robotAux2 = aux.stream().min(Comparator.comparingDouble(Robot::getIntPedidosPendientes)).get();
                robotsPedido.add(robotAux2);
            }
        }
        return robotsPedido;
    }
}
