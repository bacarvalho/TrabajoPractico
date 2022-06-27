package com.grupo4.trabajo.Servicios;

import com.grupo4.trabajo.*;
import com.grupo4.trabajo.Exceptions.EsDeudorException;
import com.grupo4.trabajo.Pedido.Pedido;
import com.grupo4.trabajo.Pedido.PedidoLimpieza;
import com.grupo4.trabajo.Pedido.Superficie;
import com.grupo4.trabajo.Pedido.SuperficieEnum;
import com.grupo4.trabajo.Robots.*;
import com.grupo4.trabajo.Servicios.ServicioCliente.ActualizadorServicio;
import com.grupo4.trabajo.Servicios.ServicioCliente.Classic;
import com.grupo4.trabajo.Servicios.ServicioCliente.Servicio;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ClassicTest {
    Servicio servicio;
    Cliente cliente;
    PedidoLimpieza p;
    Pedido pedido;
    Collection<Robot> robotsPedido;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        pedido = new Pedido(p,null);
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
        p = new PedidoLimpieza(new Superficie(null),new Superficie(SuperficieEnum.PISOS),null,1,3);
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
        p = new PedidoLimpieza(null,new Superficie(SuperficieEnum.PISOS), new Superficie(SuperficieEnum.MUEBLES),1,3);
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
        p = new PedidoLimpieza(null,new Superficie(SuperficieEnum.PISOS), new Superficie(SuperficieEnum.MUEBLES),1,3);
        assertThrows(EsDeudorException.class, () -> servicio.getPedidoValidator().validarPedido(pedido, cliente));
    }

    @Test
    void ClienteClassicSolicitaUnPedidoDeOrdenamientoYElServicioLeDescuentaLaCantidadDeOrdenamientosDisponibles(){
        int cantOrd = servicio.getCantOrdenamientos();
        p = new PedidoLimpieza(new Superficie(null),null, null ,0,2);
        pedido = new Pedido(p,null);
        ActualizadorServicio.actualizarServicio(pedido,servicio);
        assertEquals(cantOrd-1,servicio.getCantOrdenamientos());
    }

}
