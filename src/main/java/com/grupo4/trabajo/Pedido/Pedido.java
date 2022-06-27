package com.grupo4.trabajo.Pedido;

public class Pedido {
    private PedidoLimpieza pedidoLimpieza;
    private PedidoReparacion pedidoReparacion;

    public Pedido( PedidoLimpieza pedidoLimpieza,PedidoReparacion pedidoReparacion){
        this.pedidoLimpieza = pedidoLimpieza;
        this.pedidoReparacion = pedidoReparacion;

    }

    public PedidoLimpieza getPedidoLimpieza() {
        return pedidoLimpieza;
    }

    public PedidoReparacion getPedidoReparacion() {
        return pedidoReparacion;
    }

    public boolean requierePedidoLimpieza() {
        return this.pedidoLimpieza.requiereLimpieza();
    }

    public boolean requierePedidoReparacion() {
        return this.pedidoReparacion.requiereReparacion();
    }


}
