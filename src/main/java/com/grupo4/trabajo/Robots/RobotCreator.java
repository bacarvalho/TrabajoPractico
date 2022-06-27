package com.grupo4.trabajo.Robots;

import com.grupo4.trabajo.Pedido.PedidoLimpieza;
import com.grupo4.trabajo.Pedido.Superficie;
import com.grupo4.trabajo.Pedido.SuperficieEnum;

public class RobotCreator {
    public Robot crearRobot(Robot modeloRobot,int cantidadDePedidos){
        Robot robot = modeloRobot;
        for(int i = 0;i < cantidadDePedidos; i++){
            robot.agregarPedido(new PedidoLimpieza(null,new Superficie(SuperficieEnum.PISOS),null, 1,0));
        }
        return robot;
    }
}
