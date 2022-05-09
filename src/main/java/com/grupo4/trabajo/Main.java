package com.grupo4.trabajo;

import com.grupo4.trabajo.Robots.Robot;
import com.grupo4.trabajo.Robots.Superficie;
import com.grupo4.trabajo.Servicios.Classic;
import com.grupo4.trabajo.Servicios.Economic;
import com.grupo4.trabajo.Servicios.Servicio;

import java.util.Collection;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        Pedido p = new Pedido(true,false,Superficie.MUEBLES,true,true);
        Servicio s = new Classic();

        Collection<Robot> r = s.buscarRobots(p,Empresa.getRobots());


        Iterator<Robot> it = r.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}
