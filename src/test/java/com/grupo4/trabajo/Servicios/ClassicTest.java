package com.grupo4.trabajo.Servicios;

import com.grupo4.trabajo.Empresa;
import com.grupo4.trabajo.Pedido;
import com.grupo4.trabajo.Robots.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ClassicTest {
    Classic servicio;
    Pedido p;
    Collection<Robot> robotsPedido;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        servicio = new Classic();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }


    //Test Case Nro 2.

    @Test
    void buscarRobotsLimpiezaYOrdenamientoSinDeudaCaso2(){
        p = new Pedido(true,true, null,true,false);
        robotsPedido = servicio.buscarRobots(p, Empresa.getRobots());
        Iterator<Robot> it = robotsPedido.iterator();

        Collection<Robot> robotsBuscados = Arrays.asList(
                new K311Y_fl(),
                new S031RTY()
        );

        assertEquals(robotsPedido.toString(), robotsBuscados.toString());
    }

    @Test
    void buscarRobotsLimpiezaYOrdenamientoSinDeudaCaso3(){
        p = new Pedido(true,false, Superficie.MUEBLES,true,true);
        robotsPedido = servicio.buscarRobots(p, Empresa.getRobots());

        Collection<Robot> robotsBuscados = Arrays.asList(
                new K311Y_fl(),
                new K311Y_fu()
        );

        assertEquals(robotsPedido.toString(), robotsBuscados.toString());
    }





}
