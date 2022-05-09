package com.grupo4.trabajo.Servicios;

import com.grupo4.trabajo.Empresa;
import com.grupo4.trabajo.Pedido;
import com.grupo4.trabajo.Robots.K311Y_fl;
import com.grupo4.trabajo.Robots.K311Y_fu;
import com.grupo4.trabajo.Robots.Robot;
import com.grupo4.trabajo.Robots.Superficie;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ClassicTest {
    Classic servicio;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        servicio = new Classic();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    void buscarRobotsLimpiezaYOrdenamientoSinDeuda(){
        Pedido p = new Pedido(true,true, null,true,false);
        Collection<Robot> robotsPedido = servicio.buscarRobots(p, Empresa.getRobots());
        Iterator<Robot> it = robotsPedido.iterator();
        Collection<Robot> robotsBuscados = Arrays.asList(
                new K311Y_fl(),
                new K311Y_fu()
        );
        while(it.hasNext()){

        }
    }
}