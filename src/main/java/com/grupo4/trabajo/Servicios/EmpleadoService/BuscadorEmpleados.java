package com.grupo4.trabajo.Servicios.EmpleadoService;

import com.grupo4.trabajo.Empleado.Empleado;
import com.grupo4.trabajo.Empresa;
import com.grupo4.trabajo.PedidoReparacion;

import java.util.List;

public abstract class BuscadorEmpleados {


    // Tenemos 1 solo empleado por cada especialidad.
    public static Empleado BuscarEmpleado(PedidoReparacion pedidoReparacion){
        List<Empleado> listaEmpleados = Empresa.getInstancia().getListaEmpleados();

        for(int i=0;i<listaEmpleados.size();i++) {
            if(listaEmpleados.get(i).getTipoReparacion() == pedidoReparacion.getReparacion()) {
                return listaEmpleados.get(i);
            }
        }

        return null;



    }
}
