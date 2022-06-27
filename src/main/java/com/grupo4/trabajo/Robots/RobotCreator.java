package com.grupo4.trabajo.Robots;

import com.grupo4.trabajo.Pedido;
import com.grupo4.trabajo.PedidoLimpieza;
import com.grupo4.trabajo.Superficie;

public class RobotCreator {
    public Robot crearRobot(Robot modeloRobot,int cantidadDePedidos){
        Robot robot = modeloRobot;
        for(int i = 0;i < cantidadDePedidos; i++){
            robot.agregarPedido(new PedidoLimpieza(null,new Superficie(SuperficieEnum.PISOS),null, 1,0));
        }
        return robot;
    }
}
