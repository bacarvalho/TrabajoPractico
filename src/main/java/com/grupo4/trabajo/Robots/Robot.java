package com.grupo4.trabajo.Robots;

import com.grupo4.trabajo.Pedido;
import com.grupo4.trabajo.Exceptions.SinPedidosPendientesException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public abstract class Robot {

    @Getter @Setter
    private List<Pedido> pedidosPendientes;

    @Getter @Setter
    private String idRobot;

    @Getter @Setter
    private SuperficieEnum superficie;

    @Getter @Setter
    private boolean puedeOrdenar;

    @Getter @Setter
    private boolean puedeLustrar;

    @Getter @Setter
    private float costo;

    public void agregarPedido(Pedido pedido){
        if (pedidosPendientes == null)
            pedidosPendientes = new ArrayList<>();
        pedidosPendientes.add(pedido);
    }

    public int getIntPedidosPendientes() {
        if (pedidosPendientes == null)
            return 0;

        return pedidosPendientes.size() ;
    }

    public void finalizarPedido() throws SinPedidosPendientesException{
        if(pedidosPendientes.isEmpty()){
            throw new SinPedidosPendientesException("No hay pedidos pendientes.");
        }
        pedidosPendientes.remove(pedidosPendientes.get(0));
    }
}
