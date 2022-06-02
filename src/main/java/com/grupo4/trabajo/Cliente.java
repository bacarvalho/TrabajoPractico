package com.grupo4.trabajo;

import com.grupo4.trabajo.Exceptions.EsDeudorException;
import com.grupo4.trabajo.Exceptions.NoCantLimpiezasDisponibleException;
import com.grupo4.trabajo.Exceptions.NoCantOrdenamientoDisponibleException;
import com.grupo4.trabajo.Servicios.PedidosService;
import lombok.Getter;
import lombok.Setter;

public class Cliente {

    @Getter @Setter
    private String direccion;

    @Getter @Setter
    private float deuda;

    @Getter @Setter
    private PedidosService tipoServicio;

    @Getter @Setter
    private String tipoDeCliente;

    public void pedirPedido(Pedido pedido) throws EsDeudorException, NoCantOrdenamientoDisponibleException, NoCantLimpiezasDisponibleException {
        tipoServicio.realizarPedido(pedido,this);
    }

}
