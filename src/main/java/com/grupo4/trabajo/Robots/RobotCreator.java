package com.grupo4.trabajo.Robots;

import com.grupo4.trabajo.Pedido;
import com.grupo4.trabajo.PedidoLimpieza;
import com.grupo4.trabajo.Superficie;

public class RobotCreator {
    public Robot crearRobot(Robot modeloRobot,int cantidadDePedidos){
        Robot robot = modeloRobot;
        for(int i = 0;i < cantidadDePedidos; i++){
            //robot.agregarPedido(new PedidoLimpieza(new Superficie(SuperficieEnum.MUEBLES),new Superficie(SuperficieEnum.MUEBLES),new Superficie(SuperficieEnum.MUEBLES), ,null));
        }
        return robot;
    }
}
