package com.grupo4.trabajo.Servicios;

import com.grupo4.trabajo.Pedido;
import com.grupo4.trabajo.Robots.Robot;
import com.grupo4.trabajo.Validators.pedidoValidatorPlatinium;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

//Faltan todas las e

public class Platinium extends Servicio{
    public Platinium(){
        setLimiteDeuda(getCouta());
        setPedidoValidator(new pedidoValidatorPlatinium());
    }

    //Esto lo modificaria a "Robot" porque entiendo que esto deberia devolverte el robot que se le va a asignar.
    //Otro tema para charlar: No deberiamos definir de que tipo va a ser la Collection?
    public Collection<Robot> buscarRobots(Pedido pedido, Collection<Robot> robots){

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
