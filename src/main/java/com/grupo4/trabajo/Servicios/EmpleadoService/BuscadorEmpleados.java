package com.grupo4.trabajo.Servicios.EmpleadoService;

import com.grupo4.trabajo.Empleado.Empleado;
import com.grupo4.trabajo.Empresa;
import com.grupo4.trabajo.Pedido.PedidoReparacion;

import java.util.List;

public abstract class BuscadorEmpleados {


    // Tenemos 1 solo empleado por cada especialidad. A revisar
    public static Empleado BuscarEmpleado(PedidoReparacion pedidoReparacion){
        List<Empleado> listaEmpleados = Empresa.getInstancia().getListaEmpleados();
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getTipoReparacion() == pedidoReparacion.getReparacion()) {
                return empleado;
            }
        }
        return null;

    }
}
