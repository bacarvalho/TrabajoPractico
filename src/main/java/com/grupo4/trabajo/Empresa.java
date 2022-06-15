package com.grupo4.trabajo;

import com.grupo4.trabajo.Robots.*;

import java.util.Arrays;
import java.util.Collection;

public class Empresa {
    private static Empresa instancia;
    private static Collection<Robot> robots = Arrays.asList(
            new K311Y_a(),
            new K311Y_fl(),
            new K311Y_fu(),
            new P011H(),
            new S031RTY()
        );
    private Collection<Cliente> clientes;

    private Empresa(){

    }

    public static Empresa getInstancia() {
        if(instancia == null){
            instancia = new Empresa();
        }
        return instancia;
    }

    public Collection<Robot> getRobots() {
        return robots;
    }

    public void setRobots(Collection<Robot> robots) {
        Empresa.robots = robots;
    }

    public Collection<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Collection<Cliente> clientes) {
        this.clientes = clientes;
    }
}
