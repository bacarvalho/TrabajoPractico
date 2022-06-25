package com.grupo4.trabajo;

import com.grupo4.trabajo.Empleado.Empleado;
import com.grupo4.trabajo.Robots.*;
import com.grupo4.trabajo.informes.Informe;

import java.util.Arrays;
import java.util.Collection;

public class Empresa {
    private static Empresa instancia;
    private Informe informe;
    private static Collection<Robot> robots = Arrays.asList(
            new K311Y_a(),
            new K311Y_fl(),
            new K311Y_fu(),
            new P011H(),
            new S031RTY()
        );

    public void setEmpleados(Collection<Empleado> empleados) {
        this.empleados = empleados;
    }

    private Collection<Cliente> clientes;

    public Collection<Empleado> getEmpleados() {
        return empleados;
    }

    public int getCantidadDeEmpleados (){
        return empleados.size();
    }

    private Collection<Empleado> empleados;

    public Informe getInforme() {
        return informe;
    }

    public void setInforme(Informe informe) {
        this.informe = informe;
    }

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
