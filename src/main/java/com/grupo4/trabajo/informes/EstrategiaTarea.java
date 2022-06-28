package com.grupo4.trabajo.informes;

import com.grupo4.trabajo.Empleado.Empleado;
import com.grupo4.trabajo.Pedido.Pedido;
import com.grupo4.trabajo.Robots.Robot;

import java.util.List;

public interface EstrategiaTarea {
    public float calcularCosto(Pedido pedido, List<Robot> robotList, Empleado empleado);
}
