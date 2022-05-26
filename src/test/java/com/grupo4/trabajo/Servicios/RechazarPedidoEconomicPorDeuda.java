package com.grupo4.trabajo.Servicios;

import com.grupo4.trabajo.Cliente;
import com.grupo4.trabajo.Exceptions.EsDeudorException;
import com.grupo4.trabajo.Pedido;
import org.junit.jupiter.api.Test;
import com.grupo4.trabajo.Robots.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RechazarPedidoEconomicPorDeuda {
    Economic servicio;
    Cliente cliente;
    Pedido pedido;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        servicio = new Economic();
        cliente = new Cliente();
        cliente.setDeuda(2000);
        pedido = new Pedido(true, false, null, false,false);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }


    //Test Case Nro 2.

    @Test
    void denegarPedidoEconomicPorDeuda(){
        assertThrows(EsDeudorException.class, () -> servicio.EsDeudor(pedido,cliente));
    }
}
