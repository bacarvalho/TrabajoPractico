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
    K311Y_fl robot1;
    K311Y_fu robot2;
    P011H robot3;
    S031RTY robot4;
    K311Y_a robot5;
    Collection<Robot> robotsPedido;
    Collection<Robot> robots;
    static final float CUOTA = 200;
    static final float DEUDA = 300;


    @BeforeEach
    void setUp() {
        servicio = new Platinium();
        robot1 = new K311Y_fl();
        robot2 = new K311Y_fu();
        robot3 = new P011H();
        robot4 = new S031RTY();
        robot5 = new K311Y_a();

        p = new Pedido(true,new Superficie(null), new Superficie(SuperficieEnum.PISOSYMUEBLES),new Superficie(SuperficieEnum.PISOS));
        robot1.agregarPedido(p);
        robot2.agregarPedido(p);
        robot3.agregarPedido(p);
        robot4.agregarPedido(p);

        robots = Arrays.asList(
                robot1,
                robot2,
                robot3,
                robot4,
                robot5
        );
    }


    @Test
    public void pedidoConRobot () {

        Empresa.setRobots(robots);
        robotsPedido = servicio.getRobotsService().getBuscadorRobots().buscarRobots(p, Empresa.getRobots());

        Robot robotMenosPedidos = robots.stream().min(Comparator.comparingDouble(Robot::getIntPedidosPendientes)).get();
        List<Robot> robotsMenosPedidos = Arrays.asList(
            robotMenosPedidos
        );
        assertEquals(robotsPedido.toString(), robotsMenosPedidos.toString());
    }

    @Test
    public void excedeLaDeuda() {
        Platinium servicio = new Platinium();
        servicio.setLimiteDeuda(CUOTA);

        Cliente cliente = new Cliente(servicio);
        cliente.setDeuda(DEUDA);
        cliente.setTipoServicio(servicio);

        assertThrows(EsDeudorException.class, () -> servicio.getPedidoValidator().validarPedido(p, cliente));
    }

}

