package com.grupo4.trabajo.Servicios;

import com.grupo4.trabajo.Exceptions.EsDeudorException;
import com.grupo4.trabajo.Exceptions.NoCantLimpiezasDisponibleException;
import com.grupo4.trabajo.Exceptions.NoCantOrdenamientoDisponibleException;
import com.grupo4.trabajo.Cliente;
import com.grupo4.trabajo.Empresa;
import com.grupo4.trabajo.Pedido;
import com.grupo4.trabajo.Robots.Robot;
import com.grupo4.trabajo.Robots.SuperficieEnum;
import com.grupo4.trabajo.Validators.PedidoValidator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.stream.Collectors;

public abstract class Servicio {
    private PedidoValidator pedidoValidator;
    private RobotsService robotsService;
    private int cantLimpiezas;
    private int cantOrdenamientos;
    private float limiteDeuda;
    private float couta;

    public void realizarPedido(Pedido pedido, Cliente cliente){
        try{
            pedidoValidator.validarPedido(pedido,cliente);
            Collection<Robot> robotsPedido = robotsService.getBuscadorRobots().buscarRobots(pedido,Empresa.getRobots());
            robotsService.agregarPedidoRobots(robotsPedido,pedido);
            actualizarServicio(pedido, cliente, getCostoRobots(robotsPedido));
        } catch (EsDeudorException | NoCantOrdenamientoDisponibleException | NoCantLimpiezasDisponibleException e) {
            System.out.println(e.getMessage());
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

    public PedidoValidator getPedidoValidator() {
        return pedidoValidator;
    }

    public void setPedidoValidator(PedidoValidator pedidoValidator) {
        this.pedidoValidator = pedidoValidator;
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

    public RobotsService getRobotsService() {
        return robotsService;
    }

    public void setRobotsService(RobotsService robotsService) {
        this.robotsService = robotsService;
    }
}
