package com.grupo4.trabajo.Robots;

import com.grupo4.trabajo.Enumerados.SuperficieEnum;
import com.grupo4.trabajo.Pedido;
import com.grupo4.trabajo.Superficie;

public class RobotCreator {
    public Robot crearRobot(Robot modeloRobot,int cantidadDePedidos){
        Robot robot = modeloRobot;
        for(int i = 0;i < cantidadDePedidos; i++){
            robot.agregarPedido(new Pedido(false,new Superficie(SuperficieEnum.MUEBLES),null,null));
        }
        return robot;
    }
}
