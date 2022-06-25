package com.grupo4.trabajo.Servicios;

import com.grupo4.trabajo.Cliente;
import com.grupo4.trabajo.Exceptions.EsDeudorException;
import com.grupo4.trabajo.Exceptions.NoCantOrdenamientoDisponibleException;
import com.grupo4.trabajo.Pedido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoRechazadoPorAgotarLimiteOrdenamientos {
    Classic servicio;
    Cliente cliente;
    Pedido pedido;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        servicio = new Classic();
        cliente=new Cliente();
        cliente.setDeuda(1000);
        servicio.setCantOrdenamientos(0);
        pedido = new Pedido(true, true, null, false,false);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }


    //Test Case Nro 2.
@Test
    void denegarPedidoPorExcesoDeOrdenamientos(){
        assertThrows(NoCantOrdenamientoDisponibleException, () -> servicio.validarPedido(pedido,cliente));
        assertEquals("No hay suficiente ordenamiento",servicio.validarPedido(pedido,cliente));
    }
}

