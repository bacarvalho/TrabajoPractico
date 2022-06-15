package com.grupo4.trabajo.Servicios;

import com.grupo4.trabajo.Cliente;
import com.grupo4.trabajo.Empresa;
import com.grupo4.trabajo.Pedido;
import com.grupo4.trabajo.Robots.*;
import com.grupo4.trabajo.Servicios.ServicioCliente.Platinium;
import com.grupo4.trabajo.Servicios.ServicioCliente.Servicio;
import com.grupo4.trabajo.Superficie;
import com.grupo4.trabajo.Exceptions.EsDeudorException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlatinumTest {

    Servicio servicio;
    Pedido p;
    RobotCreator robotCreator = new RobotCreator();
    Robot robot1;
    Robot robot2;
    Robot robot3;
    Robot robot4;
    Robot robot5;
    Collection<Robot> robotsPedido;
    Collection<Robot> robots;
    static final float CUOTA = 200;
    static final float DEUDA = 300;


    @BeforeEach
    void setUp() {
        servicio = new Platinium();
        p = new Pedido(true,new Superficie(null), new Superficie(SuperficieEnum.PISOSYMUEBLES),new Superficie(SuperficieEnum.PISOS));
        robots = Arrays.asList(
                robot1 = robotCreator.crearRobot(new K311Y_fl(),1),
                robot2 = robotCreator.crearRobot(new K311Y_fu(),1),
                robot3 = robotCreator.crearRobot(new P011H(),1),
                robot4 = robotCreator.crearRobot(new S031RTY(),1),
                robot5 = robotCreator.crearRobot(new K311Y_a(),0)
        );
    }


    @Test
    public void ClientePlatiniumSolicitaPedidoYSeLeAsignaElRobotConMenosPedidosPendientes() {

        Empresa.getInstancia().setRobots(robots);
        robotsPedido = servicio.getRobotsService().getBuscadorRobots().buscarRobots(p, Empresa.getInstancia().getRobots());

        Robot robotMenosPedidos = robots.stream().min(Comparator.comparingDouble(Robot::getIntPedidosPendientes)).get();
        List<Robot> robotsMenosPedidos = Arrays.asList(
            robotMenosPedidos
        );
        assertEquals(robotsPedido.toString(), robotsMenosPedidos.toString());
    }

    @Test
    public void ClientePlatiniumSolicitaPedidoYEsRechazadoPorSerDeudor() {
        Platinium servicio = new Platinium();
        servicio.setLimiteDeuda(CUOTA);

        Cliente cliente = new Cliente(servicio);
        cliente.setDeuda(DEUDA);
        cliente.setTipoServicio(servicio);

        assertThrows(EsDeudorException.class, () -> servicio.getPedidoValidator().validarPedido(p, cliente));
    }

}

