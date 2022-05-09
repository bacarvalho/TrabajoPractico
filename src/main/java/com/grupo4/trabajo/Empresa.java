package com.grupo4.trabajo;

import com.grupo4.trabajo.Robots.*;

import java.util.Arrays;
import java.util.Collection;

public class Empresa {
    private static Collection<Robot> robots = Arrays.asList(
            new K311Y_a(),
            new K311Y_fl(),
            new K311Y_fu(),
            new P011H(),
            new S031RTY()
        );
    private Collection<Cliente> clientes;

    public Empresa(){

    }

    public static Collection<Robot> getRobots() {
        return robots;
    }

    public static void setRobots(Collection<Robot> robots) {
        Empresa.robots = robots;
    }

    public Collection<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Collection<Cliente> clientes) {
        this.clientes = clientes;
    }
}
