package com.grupo4.trabajo.Robots;

import com.grupo4.trabajo.Pedido;
import com.grupo4.trabajo.Superficie;

public class RobotCreator {

    public Robot crearRobot(Robot tipoRobot,int cantidadDePedidos){
        Robot robot = tipoRobot;
        for(int i = 0;i < cantidadDePedidos; i++){
            robot.agregarPedido(new Pedido(false,new Superficie(SuperficieEnum.MUEBLES),null,null));
        }

        return robot;
    }
}
