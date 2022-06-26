package com.grupo4.trabajo.informes;

import com.grupo4.trabajo.Empleado.Empleado;
import com.grupo4.trabajo.Empresa;
import com.grupo4.trabajo.Pedido;
import com.grupo4.trabajo.Robots.Robot;

import java.util.Iterator;
import java.util.List;

public class TareaSimple implements Estrategia{
    @Override
    public float calcularCosto(Pedido pedido, List<Robot> robotList, Empleado empleado) {
        return calcularCostoRobots(robotList) + costoEmpleado(pedido,empleado);
    }

    private float calcularCostoRobots(List<Robot> robotList){
        float costoTotal=0;
        Iterator<Robot> it = robotList.iterator();
        while (it.hasNext()) {
            Robot robot = (Robot) it.next();
            costoTotal+=robot.getCosto();
        }
        return costoTotal;
    }

    //El costo de un empleado se calcula en base al precio por hora (sueldo_base / 160) por la
    //complejidad de la reparación.


    private float costoEmpleado(Pedido pedido, Empleado empleado){
        return (empleado.getSueldo()/160) * pedido.getPedidoReparacion().getComplejidad();
    }
}
