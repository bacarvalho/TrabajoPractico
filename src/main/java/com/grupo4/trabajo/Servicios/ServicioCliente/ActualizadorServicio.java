package com.grupo4.trabajo.Servicios.ServicioCliente;
import com.grupo4.trabajo.Pedido;

public abstract class ActualizadorServicio {
    public static void actualizarServicio(Pedido pedido, Servicio servicio) {
        if (pedido.requiereLimpieza()) {
            servicio.setCantLimpiezas(servicio.getCantLimpiezas() - 1);
        }
        if (pedido.requiereOrdenamiento()) {
            servicio.setCantOrdenamientos(servicio.getCantOrdenamientos() - 1);
        }
    }
}
