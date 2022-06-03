package com.grupo4.trabajo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.stream.Collectors;

import com.grupo4.trabajo.Exceptions.EsDeudorException;
import com.grupo4.trabajo.Exceptions.NoCantLimpiezasDisponibleException;
import com.grupo4.trabajo.Exceptions.NoCantOrdenamientoDisponibleException;
import com.grupo4.trabajo.Robots.Robot;
import com.grupo4.trabajo.Servicios.Servicio;

public class EmpresaManager {

    public void realizarPedido(Pedido pedido, Cliente cliente, Servicio servicio){
        try {
            servicio.validarPedido(pedido, cliente);
            Collection<Robot> robotsPedido = buscarRobots(pedido, Empresa.getRobots());
            agregarPedidoRobots(robotsPedido, pedido);
            servicio.actualizar(pedido, cliente, getCostoRobots(robotsPedido));
        } catch (EsDeudorException | NoCantOrdenamientoDisponibleException | NoCantLimpiezasDisponibleException e) {
            System.out.println(e.getMessage());
        }
    }

    public Collection<Robot> buscarRobots(Pedido pedido, Collection<Robot> robots){
        //Condicion de busqueda: los robots mas economicos.

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

    public void agregarPedidoRobots(Collection<Robot> robots,Pedido pedido){
        Iterator<Robot> it = robots.iterator();
        while(it.hasNext()){
            it.next().agregarPedido(pedido);
        }
    }
    
    public float getCostoRobots(Collection<Robot> robots){
        float costo = 0f;
        Iterator<Robot> it = robots.iterator();
        while(it.hasNext()){
            costo += it.next().getCosto();
        }
        return costo;
    }
}
