package com.grupo4.trabajo;

import com.grupo4.trabajo.Robots.K311Y_fl;
import com.grupo4.trabajo.Robots.K311Y_fu;
import com.grupo4.trabajo.Robots.Robot;
import com.grupo4.trabajo.Robots.Superficie;
import com.grupo4.trabajo.Servicios.Classic;
import com.grupo4.trabajo.Servicios.Economic;
import com.grupo4.trabajo.Servicios.Servicio;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Classic servicio = new Classic();
        Pedido p = new Pedido(true,true, null,true,false);
        Collection<Robot> robotsPedido = servicio.buscarRobots(p, Empresa.getRobots());
        Iterator<Robot> it = robotsPedido.iterator();
        Collection<Robot> robotsBuscados = Arrays.asList(
                new K311Y_fl(),
                new K311Y_fu()
        );
        System.out.println("ROBOTS ENTREGADOS PARA EL PEDIDO:");
        while(it.hasNext()){
            System.out.println("-"+it.next());
        }
        //-------------------------------------------------//
        System.out.println("-------------------------------");
        p = new Pedido(true,false, Superficie.MUEBLES,true,true);
        robotsPedido = servicio.buscarRobots(p, Empresa.getRobots());
        it = robotsPedido.iterator();
        System.out.println("ROBOTS ENTREGADOS PARA EL PEDIDO:");
        while(it.hasNext()){
            System.out.println("-"+it.next());
        }
    }
}
