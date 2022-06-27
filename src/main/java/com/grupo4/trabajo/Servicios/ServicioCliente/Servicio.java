package com.grupo4.trabajo.Servicios.ServicioCliente;

import com.grupo4.trabajo.Empleado.Empleado;
import com.grupo4.trabajo.Exceptions.EsDeudorException;
import com.grupo4.trabajo.Exceptions.NoCantLimpiezasDisponibleException;
import com.grupo4.trabajo.Exceptions.NoCantOrdenamientoDisponibleException;
import com.grupo4.trabajo.Cliente;
import com.grupo4.trabajo.Empresa;
import com.grupo4.trabajo.Pedido;
import com.grupo4.trabajo.Robots.Robot;
import com.grupo4.trabajo.Servicios.EmpleadoService.*;
import com.grupo4.trabajo.Servicios.RobotsService.RobotsService;
import com.grupo4.trabajo.Validators.PedidoValidator;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class Servicio {
    //private ActualizadorServicio actualizadorServicio;
    private PedidoValidator pedidoValidator;
    private RobotsService robotsService;
    private int cantLimpiezas;
    private int cantOrdenamientos;
    private float limiteDeuda;
    private float couta;

    public void realizarPedido(Pedido pedido, Cliente cliente){
        Empleado empleado = null;
        List<Robot> robotsPedido = null;
        try{
            pedidoValidator.validarPedido(pedido,cliente);
            if (pedido.getPedidoLimpieza().requiereLimpieza()) {
                robotsPedido = robotsService.getBuscadorRobots().buscarRobots(pedido.getPedidoLimpieza(), Empresa.getInstancia().getRobots());
                robotsService.agregarPedidoRobots(robotsPedido, pedido.getPedidoLimpieza());
                Empresa.getInstancia().getInforme().incrementarContadorPedidos(pedido);
            }
            if (pedido.getPedidoReparacion().requiereReparacion()) {
                empleado = BuscadorEmpleados.BuscarEmpleado(pedido.getPedidoReparacion());
                //consultar si usamos el metodo CalculadorReparacion
            }
            //obtener empleados del pedido
            cliente.agregarCostoPedido(Empresa.getInstancia().getInforme().calcularCostoPedido(pedido,robotsPedido, empleado));
            //actualizadorServicio.actualizarServicio(pedido, this);
            ActualizadorServicio.actualizarServicio(pedido,this);
        } catch (EsDeudorException | NoCantOrdenamientoDisponibleException | NoCantLimpiezasDisponibleException e) {
            System.out.println(e.getMessage());
        }
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
