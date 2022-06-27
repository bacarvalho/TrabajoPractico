package com.grupo4.trabajo.Servicios;
import com.grupo4.trabajo.Cliente;
import com.grupo4.trabajo.Exceptions.EsDeudorException;
import com.grupo4.trabajo.Exceptions.NoCantLimpiezasDisponibleException;
import com.grupo4.trabajo.Exceptions.NoCantOrdenamientoDisponibleException;
import com.grupo4.trabajo.Pedido.Pedido;
import com.grupo4.trabajo.Pedido.PedidoLimpieza;
import com.grupo4.trabajo.Pedido.SuperficieEnum;
import com.grupo4.trabajo.Servicios.ServicioCliente.ActualizadorServicio;
import com.grupo4.trabajo.Servicios.ServicioCliente.Economic;
import com.grupo4.trabajo.Servicios.ServicioCliente.Servicio;
import com.grupo4.trabajo.Pedido.Superficie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EconomicTest {
    PedidoLimpieza pedidoEco;
    Pedido pedido;
    Servicio servicio;
    Cliente cliente;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        servicio = new Economic();
        cliente = new Cliente(servicio);
        pedidoEco = new PedidoLimpieza(new Superficie(null),new Superficie(SuperficieEnum.PISOS), null,1,3);
        pedido = new Pedido(pedidoEco,null);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        cliente.setDeuda(0);
        servicio.setCantLimpiezas(3);
    }


    @Test
    void ClienteEconomicSolicitaPedidoYEsRechazadoPorSerDeudor(){
        cliente.setDeuda(2);
        assertThrows(EsDeudorException.class, () -> servicio.getPedidoValidator().validarPedido(pedido,cliente));
    }

    @Test
    void ClienteEconomicSolicitaPedidoDeOrdenamientosYesRechazadoPorqueElServicioNoOfreceOrdenamientos(){
        assertThrows(NoCantOrdenamientoDisponibleException.class, () -> servicio.getPedidoValidator().validarPedido(pedido,cliente));
    }

    @Test
    void ClienteEconomicConServiciosDeLimpiezasAgotadasSolicitaUnPedidoDeLimpiezaYEsRechazada(){
        servicio.setCantLimpiezas(0);
        assertThrows(NoCantLimpiezasDisponibleException.class, () -> servicio.getPedidoValidator().validarPedido(pedido,cliente));
    }

    @Test
    void ClienteEconomicSinDeudaSolicitaUnPedidoDeLimpiezaYSeLeDescuentaLaCantidadDeLimpiezas(){
        int cantLim = servicio.getCantLimpiezas();
        pedidoEco = new PedidoLimpieza(null,new Superficie(SuperficieEnum.PISOS), null,1,0);
        ActualizadorServicio.actualizarServicio(pedido,servicio);
        assertEquals(cantLim-1,servicio.getCantLimpiezas());
    }

}
