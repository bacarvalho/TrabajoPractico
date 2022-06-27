package com.grupo4.trabajo.Servicios;

import com.grupo4.trabajo.*;
import com.grupo4.trabajo.Empleado.Empleado;
import com.grupo4.trabajo.Robots.*;
import com.grupo4.trabajo.Servicios.EmpleadoService.BuscadorEmpleados;
import com.grupo4.trabajo.Servicios.ServicioCliente.Classic;
import com.grupo4.trabajo.Servicios.ServicioCliente.Servicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTareaCompleja {
    RobotCreator robotCreator = new RobotCreator();
    Robot robot1;
    Robot robot2;
    Robot robot3;
    Robot robot4;
    Robot robot5;
    Collection<Robot> robotsPedido;
    Collection<Robot> robots;

    @BeforeEach
    void setUp() {
        robots = Arrays.asList(
                robot1 = robotCreator.crearRobot(new K311Y_fl(),1),
                robot2 = robotCreator.crearRobot(new K311Y_fu(),1)
        );
    }


    @Test
    void calcularCostoTareaComplejaConRobotsYSinEmpleados(){
        Servicio servicio=new Classic();

        Superficie superficieOrdenamiento=new Superficie(SuperficieEnum.PISOS);
        Superficie superficieLimpieza = new Superficie(SuperficieEnum.MUEBLES);
        Cliente cliente = new Cliente(servicio);
        PedidoLimpieza pedidoLimpieza=new PedidoLimpieza(superficieOrdenamiento,superficieLimpieza,null,5,12);
        PedidoReparacion pedidoReparacion=null;
        Pedido pedido=new Pedido(pedidoLimpieza,pedidoReparacion);

        assertEquals(9000.0f,Empresa.getInstancia().getInforme().calcularCostoPedido(pedido, (List<Robot>) robots,null));
    }

    @Test
    void calcularCostoTareaComplejaConRobotsYConEmpleados(){
        Servicio servicio=new Classic();

        Superficie superficieOrdenamiento=new Superficie(SuperficieEnum.PISOS);
        Superficie superficieLimpieza = new Superficie(SuperficieEnum.MUEBLES);
        Cliente cliente = new Cliente(servicio);
        PedidoLimpieza pedidoLimpieza=new PedidoLimpieza(superficieOrdenamiento,superficieLimpieza,null,5,10);
        PedidoReparacion pedidoReparacion=new PedidoReparacion(TipoReparacion.GAS,8);
        Pedido pedido=new Pedido(pedidoLimpieza,pedidoReparacion);
        Empleado empleado=BuscadorEmpleados.BuscarEmpleado(pedidoReparacion);

        assertEquals(11750.0f,Empresa.getInstancia().getInforme().calcularCostoPedido(pedido, (List<Robot>) robots,empleado));
    }
}
