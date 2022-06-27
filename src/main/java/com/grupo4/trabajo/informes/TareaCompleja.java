package com.grupo4.trabajo.informes;

import com.grupo4.trabajo.Empleado.Empleado;
import com.grupo4.trabajo.Empresa;
import com.grupo4.trabajo.Pedido.Pedido;
import com.grupo4.trabajo.Robots.Robot;

import java.util.Iterator;
import java.util.List;

public class TareaCompleja implements Estrategia{
    private final static int CANTIDAD_HORAS = 2;
    @Override
    public float calcularCosto(Pedido pedido, List<Robot> robotList, Empleado empleado) {
        return calcularCostoRobots(robotList,CANTIDAD_HORAS) + costoEmpleado(pedido,empleado);
    }

    private float calcularCostoRobots(List<Robot> robotList, int cantidadHoras){
        if(robotList==null){
            return 0;
        }

        float costoTotal=0;
        int factorDeAjusteComun= Empresa.getInstancia().getInforme().getAjusteComunDefinido();
        Iterator<Robot> it = robotList.iterator();
        while (it.hasNext()) {
            Robot robot = (Robot) it.next();
            costoTotal+=robot.getCosto() * cantidadHoras * factorDeAjusteComun;
        }
        return costoTotal;
    }



    private float costoEmpleado(Pedido pedido, Empleado empleado){
        if(empleado==null){
            return 0;
        }
        return (empleado.getSueldo()/160) * pedido.getPedidoReparacion().getComplejidad();
    }

    @Override
    public String toString() {
        return "tarea compleja";
    }
}
