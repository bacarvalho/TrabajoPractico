package com.grupo4.trabajo.Servicios.ServicioCliente;
import com.grupo4.trabajo.Pedido;

public abstract class ActualizadorServicio {
    public static void actualizarServicio(Pedido pedido, Servicio servicio) {
        if (pedido.getPedidoLimpieza().requiereLimpieza()) {
            servicio.setCantLimpiezas(servicio.getCantLimpiezas() - 1);
        }
        if (pedido.getPedidoLimpieza().requiereOrdenamiento()) {
            servicio.setCantOrdenamientos(servicio.getCantOrdenamientos() - 1);
        }
    }
}
