package com.grupo4.trabajo.Servicios;

import com.grupo4.trabajo.*;
import com.grupo4.trabajo.Empleado.Empleado;
import com.grupo4.trabajo.Robots.*;
import com.grupo4.trabajo.Servicios.EmpleadoService.BuscadorEmpleados;
import com.grupo4.trabajo.Servicios.RobotsService.BuscadorRobotsEconomic;
import com.grupo4.trabajo.Servicios.RobotsService.RobotsService;
import com.grupo4.trabajo.Servicios.ServicioCliente.Classic;
import com.grupo4.trabajo.Servicios.ServicioCliente.Platinium;
import com.grupo4.trabajo.Servicios.ServicioCliente.Servicio;
import com.grupo4.trabajo.informes.Informe;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class TestTareaSimple {

    RobotCreator robotCreator = new RobotCreator();
    Robot robot1;
    Robot robot2;
    Robot robot3;
    Robot robot4;
    Robot robot5;
    List<Robot> robotsPedido;
    List<Robot> robots;

    @BeforeEach
    void setUp() {
        robots = Arrays.asList(
                robot1 = robotCreator.crearRobot(new K311Y_fl(),1),
                robot2 = robotCreator.crearRobot(new K311Y_fu(),1)
        );
    }



    @Test
    void calcularCostoTareaSimpleConEmpleadosYRobots(){
        Servicio servicio=new Classic();
        Empresa.getInstancia().setRobots(robots);

        Superficie superficieOrdenamiento=new Superficie(SuperficieEnum.PISOS);
        Superficie superficieLimpieza = new Superficie(SuperficieEnum.MUEBLES);
        Cliente cliente = new Cliente(servicio);
        PedidoLimpieza pedidoLimpieza=new PedidoLimpieza(superficieOrdenamiento,superficieLimpieza,null,1,5);
        PedidoReparacion pedidoReparacion=new PedidoReparacion(TipoReparacion.ELECTRICIDAD,2);
        Pedido pedido=new Pedido(pedidoLimpieza,pedidoReparacion,cliente);
        Empleado empleado= BuscadorEmpleados.BuscarEmpleado(pedidoReparacion);

        Informe informe = new Informe();
        assertEquals(2250.0f,informe.calcularCostoPedido(pedido, (List<Robot>) robots,empleado));
    }

    @Test
    void calcularCostoTareaSimpleConRobotsYSinEmpleados(){
        Servicio servicio=new Classic();

        Superficie superficieOrdenamiento=new Superficie(SuperficieEnum.PISOS);
        Superficie superficieLimpieza = new Superficie(SuperficieEnum.MUEBLES);
        Cliente cliente = new Cliente(servicio);
        PedidoLimpieza pedidoLimpieza=new PedidoLimpieza(superficieOrdenamiento,superficieLimpieza,null,1,5);
        PedidoReparacion pedidoReparacion=null;
        Pedido pedido=new Pedido(pedidoLimpieza,pedidoReparacion,cliente);


        Informe informe = new Informe();
        assertEquals(1500.0f,informe.calcularCostoPedido(pedido, (List<Robot>) robots,null));
    }

    @Test
    void calcularCostoTareaSimpleSinRobotsYConEmpleados(){
        Servicio servicio=new Classic();

        Cliente cliente = new Cliente(servicio);
        PedidoReparacion pedidoReparacion=new PedidoReparacion(TipoReparacion.GAS,7);
        Pedido pedido=new Pedido(null,pedidoReparacion,cliente);
        Empleado empleado= BuscadorEmpleados.BuscarEmpleado(pedidoReparacion);

        Informe informe = new Informe();
        assertEquals(2406.25f,informe.calcularCostoPedido(pedido, null,empleado));
    }


}
