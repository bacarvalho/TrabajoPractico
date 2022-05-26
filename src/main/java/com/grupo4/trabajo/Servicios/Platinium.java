package com.grupo4.trabajo.Servicios;

import com.grupo4.trabajo.Cliente;
import com.grupo4.trabajo.Exceptions.EsDeudorException;
import com.grupo4.trabajo.Pedido;
import com.grupo4.trabajo.Robots.Robot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

//Faltan todas las e

public class Platinium extends Servicio{
    public Platinium(){
        setLimiteDeuda(getCouta());

    }

    //Esto lo modificaria a "Robot" porque entiendo que esto deberia devolverte el robot que se le va a asignar.
    //Otro tema para charlar: No deberiamos definir de que tipo va a ser la Collection?

    public Collection<Robot> buscarRobots(Pedido pedido, Collection<Robot> robots){
        //Condicion de busqueda: los robots con menor cantidad de pedidos pendientes

        Collection<Robot> robotsPedido = new ArrayList<>();
            Robot robot = robots.stream().min(Comparator.comparingInt(Robot::getIntPedidosPendientes)).get();
            if(robot.isPuedeLustrar() && robot.isPuedeOrdenar())
                 robotsPedido.add(robot);
            else {
                if (pedido.requiereOrdenamiento() != null) {
                    Collection<Robot> aux = robots.stream()
                            .filter(r -> r.isPuedeOrdenar() && r.getSuperficie() == pedido.requiereOrdenamiento().getSuperficie())
                            .collect(Collectors.toList());
                   Robot robotAux = aux.stream().min(Comparator.comparingDouble(Robot::getIntPedidosPendientes)).get();
                    robotsPedido.add(robotAux);
                }
                if (pedido.requiereLustramiento() != null) {
                    Collection<Robot> aux = robots.stream()
                            .filter(r -> r.isPuedeLustrar() && r.getSuperficie() == pedido.requiereLustramiento().getSuperficie())
                            .collect(Collectors.toList());
                    Robot robotAux2 = aux.stream().min(Comparator.comparingDouble(Robot::getIntPedidosPendientes)).get();
                    robotsPedido.add(robotAux2);
                }
            }
        return robotsPedido;
    }

    @Override
    public void validarPedido(Pedido pedido, Cliente cliente) throws EsDeudorException {
        try {
            esDeudor(pedido, cliente);
        }
        catch (EsDeudorException e) {
            throw new EsDeudorException("Cuenta con una deuda mayor al de una cuota");
        }
    }

    //esDeudorException
    private void esDeudor(Pedido pedido, Cliente cliente) throws EsDeudorException {
        if(cliente.getDeuda() > getLimiteDeuda()){
            throw new EsDeudorException("Cuenta con una deuda mayor al de una cuota");
        }
    }
}
