package com.grupo4.trabajo.Servicios;

import com.grupo4.trabajo.Exceptions.EsDeudorException;
import com.grupo4.trabajo.Exceptions.NoCantLimpiezasDisponibleException;
import com.grupo4.trabajo.Exceptions.NoCantOrdenamientoDisponibleException;
import com.grupo4.trabajo.Cliente;
import com.grupo4.trabajo.Empresa;
import com.grupo4.trabajo.Interface.Disponibles;
import com.grupo4.trabajo.Pedido;
import com.grupo4.trabajo.Robots.Robot;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.stream.Collectors;

public abstract class PedidosService {

    @Getter @Setter
    private int cantLimpiezas;

    @Getter @Setter
    private int cantOrdenamientos;

    @Getter @Setter
    private float limiteDeuda;

    @Getter @Setter
    private float couta;

    public abstract void validarPedido(Pedido pedido,Cliente cliente) throws EsDeudorException, NoCantOrdenamientoDisponibleException, NoCantLimpiezasDisponibleException;

    public void realizarPedido(Pedido pedido, Cliente cliente){
        try{
            validarPedido(pedido,cliente) ;
            Collection<Robot> robotsPedido = buscarRobotsParaElPedido(pedido, cliente);
            agregarPedidoRobots(robotsPedido,pedido);
        } catch (EsDeudorException | NoCantOrdenamientoDisponibleException | NoCantLimpiezasDisponibleException e) {
            System.out.println(e.getMessage());
        }

    }

    public void agregarPedidoRobots(Collection<Robot> robots,Pedido pedido){
        Iterator<Robot> it = robots.iterator();
        while(it.hasNext()){
            it.next().agregarPedido(pedido);
        }
    }

    public Collection<Robot> buscarRobotsParaElPedido(Pedido pedido, Cliente cliente){
        switch (cliente.getTipoDeCliente()){
            case "Platinum":
                 return obtenerRobotsParaPlatinum(pedido,Empresa.getRobots());
            default:
                 return obtenerRobotsParaEconomic(pedido, Empresa.getRobots());
        }
    }

    private Collection<Robot> obtenerRobotsParaEconomic(Pedido pedido, Collection<Robot> robots) {

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

    private Collection<Robot> obtenerRobotsParaPlatinum(Pedido pedido, Collection<Robot> robots) {

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

    public void LimpiezasDisponibles(Pedido pedido, Cliente cliente) throws NoCantLimpiezasDisponibleException{

    }
    public void OrdenamientosDisponibles(Pedido pedido, Cliente cliente) throws NoCantOrdenamientoDisponibleException{

    }

}
