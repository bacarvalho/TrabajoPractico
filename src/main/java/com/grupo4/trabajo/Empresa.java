package com.grupo4.trabajo;

import com.grupo4.trabajo.Empleado.Empleado;
import com.grupo4.trabajo.Pedido.TipoReparacion;
import com.grupo4.trabajo.Robots.*;
import com.grupo4.trabajo.informes.Informe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Empresa {
    private static Empresa instancia;
    private Informe informe;
    private List<Empleado> ListaEmpleados;
    private static List<Robot> robots = Arrays.asList(
            new K311Y_a(),
            new K311Y_fl(),
            new K311Y_fu(),
            new P011H(),
            new S031RTY()
        );
    private Collection<Cliente> clientes;

    public Informe getInforme() {
        return informe;
    }

    public void setInforme(Informe informe) {
        this.informe = informe;
    }

    private Empresa(){
        ListaEmpleados = new ArrayList<>();
        ListaEmpleados.add(new Empleado(60000, TipoReparacion.ELECTRICIDAD));
        ListaEmpleados.add(new Empleado(55000, TipoReparacion.GAS));
        this.informe=new Informe();
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

    public void setRobots(List<Robot> robots) {
        Empresa.robots = robots;
    }

    public Collection<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Collection<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Empleado> getListaEmpleados() {
        return ListaEmpleados;
    }
}
