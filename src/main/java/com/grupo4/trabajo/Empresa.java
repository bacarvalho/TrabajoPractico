package com.grupo4.trabajo;

import com.grupo4.trabajo.Robots.Robot;

import java.util.Collection;

public class Empresa {
    private static Collection<Robot> robots;
    private Collection<Cliente> clientes;

    public Empresa(){
        //un robot de cada uno
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
