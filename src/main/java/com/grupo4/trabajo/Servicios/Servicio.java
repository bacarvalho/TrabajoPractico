package com.grupo4.trabajo.Servicios;

import com.grupo4.trabajo.Exceptions.EsDeudorException;
import com.grupo4.trabajo.Exceptions.NoCantLimpiezasDisponibleException;
import com.grupo4.trabajo.Exceptions.NoCantOrdenamientoDisponibleException;
import com.grupo4.trabajo.Cliente;
import com.grupo4.trabajo.Empresa;
import com.grupo4.trabajo.Pedido;
import com.grupo4.trabajo.Robots.Robot;
import com.grupo4.trabajo.Robots.SuperficieEnum;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.stream.Collectors;

public abstract class Servicio {
    private int cantLimpiezas;
    private int cantOrdenamientos;
    private float limiteDeuda;
    private float couta;

    public abstract void validarPedido(Pedido pedido,Cliente cliente) throws EsDeudorException, NoCantOrdenamientoDisponibleException, NoCantLimpiezasDisponibleException;

    public void realizarPedido(Pedido pedido, Cliente cliente){
        try{
            validarPedido(pedido,cliente) ;
            Collection<Robot> robotsPedido = buscarRobots(pedido,Empresa.getRobots());
            agregarPedidoRobots(robotsPedido,pedido);
            actualizarServicio(pedido, cliente, getCostoRobots(robotsPedido));
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

    public float getCostoRobots(Collection<Robot> robots){
        float costo = 0f;
        Iterator<Robot> it = robots.iterator();
        while(it.hasNext()){
            costo += it.next().getCosto();
        }
        return costo;
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

    public void actualizarServicio(Pedido pedido, Cliente cliente, float costo) {
        if (pedido.requiereLimpieza()) {
            setCantLimpiezas(getCantLimpiezas() - 1);
        }
        if (pedido.requiereOrdenamiento()) {
            setCantOrdenamientos(getCantOrdenamientos() - 1);
        }
        cliente.setDeuda(cliente.getDeuda() + costo);
    }


    public int getCantLimpiezas() {
        return cantLimpiezas;
    }

    public void setCantLimpiezas(int cantLimpiezas) {
        this.cantLimpiezas = cantLimpiezas;
    }

    public int getCantOrdenamientos() {
        return cantOrdenamientos;
    }

    public void setCantOrdenamientos(int cantOrdenamientos) {
        this.cantOrdenamientos = cantOrdenamientos;
    }

    public float getLimiteDeuda() {
        return limiteDeuda;
    }

    public void setLimiteDeuda(float limiteDeuda) {
        this.limiteDeuda = limiteDeuda;
    }

    public float getCouta() {
        return couta;
    }

    public void setCouta(float couta) {
        this.couta = couta;
    }

    public void EsDeudor(Pedido pedido, Cliente cliente) throws EsDeudorException{
    }

    public void LimpiezasDisponibles(Pedido pedido, Cliente cliente) throws NoCantLimpiezasDisponibleException{
    }

    public void OrdenamientosDisponibles(Pedido pedido, Cliente cliente) throws NoCantOrdenamientoDisponibleException{

    }
}
