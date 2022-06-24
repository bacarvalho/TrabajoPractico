package com.grupo4.trabajo.informes;

import com.grupo4.trabajo.Empleado.Empleado;
import com.grupo4.trabajo.Pedido;
import com.grupo4.trabajo.Robots.Robot;

import java.util.List;

public class TareaCompleja implements Estrategia{
    @Override
    public float calcularCosto(Pedido pedido, List<Robot> robotList, List<Empleado> empleadoList) {
        return 0;
    }
}
