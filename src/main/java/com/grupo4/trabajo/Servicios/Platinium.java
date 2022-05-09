package com.grupo4.trabajo.Servicios;

import com.grupo4.trabajo.Cliente;
import com.grupo4.trabajo.Pedido;
import com.grupo4.trabajo.Robots.Robot;
import com.grupo4.trabajo.Robots.Superficie;

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
        if(pedido.requiereLimpieza()){
            Collection<Robot> aux = robots.stream()
                    .filter(robot -> robot.getSuperficie() == Superficie.PISOS)
                    .collect(Collectors.toList());
            Robot robot = aux.stream().min(Comparator.comparingInt(Robot::getIntPedidosPendientes)).get();
            robotsPedido.add(robot);
        }
        if(pedido.requiereOrdenamiento()){
            Collection<Robot> aux = robots.stream()
                    .filter(Robot::isPuedeOrdenar)
                    .collect(Collectors.toList());
            Robot robot = aux.stream().min(Comparator.comparingDouble(Robot::getIntPedidosPendientes)).get();
            robotsPedido.add(robot);
        }
        if(pedido.requiereLustramiento()){
            Collection<Robot> aux = robots.stream()
                    .filter(r -> r.isPuedeLustrar() && r.getSuperficie() == pedido.getSuperficie())
                    .collect(Collectors.toList());
            Robot robot = aux.stream().min(Comparator.comparingDouble(Robot::getIntPedidosPendientes)).get();
            robotsPedido.add(robot);
        }
        return robotsPedido;
    }

    @Override
    public void validarPedido(Pedido pedido, Cliente cliente) {
        try {
            esDeudor(pedido, cliente);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //esDeudorException
    private void esDeudor(Pedido pedido, Cliente cliente) throws Exception{
        if(cliente.getDeuda() > getLimiteDeuda()){
            throw new Exception();
        }

    }
}
