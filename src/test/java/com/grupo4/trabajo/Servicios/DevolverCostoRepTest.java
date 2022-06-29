package com.grupo4.trabajo.Servicios;

import com.grupo4.trabajo.CalculadoReparacion.CalculadorReparacion;
import com.grupo4.trabajo.Cliente;
import com.grupo4.trabajo.Pedido.PedidoReparacion;
import com.grupo4.trabajo.Pedido.TipoReparacion;
import com.grupo4.trabajo.Servicios.ServicioCliente.Classic;
import com.grupo4.trabajo.Servicios.ServicioCliente.Economic;
import com.grupo4.trabajo.Servicios.ServicioCliente.Servicio;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DevolverCostoRepTest {
    Cliente cliente;
    Servicio servicio;
    PedidoReparacion pedidoReparacion;

    @BeforeEach
    void setUp() {
        servicio = new Classic();
        cliente = new Cliente(servicio);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void clienteSolicitaPedidoDeReparacionDeElectricidadConComplejidad3YSeLeDevuelveElPrecio(){
        pedidoReparacion = new PedidoReparacion(TipoReparacion.ELECTRICIDAD,3);
        assertEquals(5698.0f,cliente.devolverCostoReparacion(CalculadorReparacion.calcularCostoReparacion(pedidoReparacion)));
    }

    @Test
    void clienteSolicitaPedidoDeReparacionDeGasConComplejidad7YSeLeDevuelveElPrecio(){
        pedidoReparacion = new PedidoReparacion(TipoReparacion.GAS,7);
        assertEquals(8795.25,cliente.devolverCostoReparacion(CalculadorReparacion.calcularCostoReparacion(pedidoReparacion)));
    }

    @Test
    void clienteSolicitaPedidoDeReparacionDeGasConComplejidad1YSeLeDevuelveElPrecio(){
        pedidoReparacion = new PedidoReparacion(TipoReparacion.GAS,1);
        assertEquals(1343.75f,cliente.devolverCostoReparacion(CalculadorReparacion.calcularCostoReparacion(pedidoReparacion)));
    }

    @Test
    void clienteSolicitaPedidoDeReparacionDeElectricidadConComplejidad6YSeLeDevuelveElPrecio(){
        pedidoReparacion = new PedidoReparacion(TipoReparacion.ELECTRICIDAD,6);
        assertEquals(6823.0f,cliente.devolverCostoReparacion(CalculadorReparacion.calcularCostoReparacion(pedidoReparacion)));
    }
}