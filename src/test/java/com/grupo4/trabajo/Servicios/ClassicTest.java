package com.grupo4.trabajo.Servicios;

import com.grupo4.trabajo.Cliente;
import com.grupo4.trabajo.Empresa;
import com.grupo4.trabajo.Exceptions.EsDeudorException;
import com.grupo4.trabajo.Pedido;
import com.grupo4.trabajo.Robots.*;
import com.grupo4.trabajo.Servicios.ServicioCliente.ActualizadorServicio;
import com.grupo4.trabajo.Servicios.ServicioCliente.Classic;
import com.grupo4.trabajo.Servicios.ServicioCliente.Servicio;
import com.grupo4.trabajo.Superficie;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ClassicTest {
    Servicio servicio;
    Cliente cliente;
    Pedido p;
    Collection<Robot> robotsPedido;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        servicio = new Classic();
        cliente=new Cliente(servicio);
        cliente.setDeuda(2001);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }


    //Test Case Nro 2.
    @Test
    void ClienteClassicSolicitaPedidoDeLimpiezaYOrdenamientoSeLeAsignanLosRobotsK311Y_flyS031RTY(){
        p = new Pedido(true,new Superficie(null), new Superficie(SuperficieEnum.PISOS),null);
        robotsPedido = servicio.getRobotsService().getBuscadorRobots().buscarRobots(p, Empresa.getInstancia().getRobots());
        Iterator<Robot> it = robotsPedido.iterator();

        Collection<Robot> robotsBuscados = Arrays.asList(
                new K311Y_fl(),
                new S031RTY()
        );

        assertEquals(robotsPedido.toString(), robotsBuscados.toString());
    }

    //Test Case Nro 3.
    @Test
    void ClienteClassicSolicitaPedidoDeLimpiezaYLustradoDeMueblesSeLeAsignanLosRobotsK331Y_flyK311Y_fu(){
        p = new Pedido(true,null, new Superficie(SuperficieEnum.PISOS) ,new Superficie(SuperficieEnum.MUEBLES));
        robotsPedido = servicio.getRobotsService().getBuscadorRobots().buscarRobots(p, Empresa.getInstancia().getRobots());

        Collection<Robot> robotsBuscados = Arrays.asList(
                new K311Y_fl(),
                new K311Y_fu()
        );

        assertEquals(robotsPedido.toString(), robotsBuscados.toString());
    }

    //Test Case nro 4.
    @Test
    void ClienteClassicSolicitaUnPedidoYEsRechazadoPorSerDeudor(){
        p = new Pedido(true,null, new Superficie(SuperficieEnum.PISOS) ,new Superficie(SuperficieEnum.MUEBLES));
        assertThrows(EsDeudorException.class, () -> servicio.getPedidoValidator().validarPedido(p, cliente));
    }

    @Test
    void ClienteClassicSolicitaUnPedidoDeOrdenamientoYElServicioLeDescuentaLaCantidadDeOrdenamientosDisponibles(){
        int cantOrd = servicio.getCantOrdenamientos();
        p = new Pedido(true,new Superficie(null), null ,null);
        ActualizadorServicio.actualizarServicio(p,servicio);
        assertEquals(cantOrd-1,servicio.getCantOrdenamientos());
    }

}
