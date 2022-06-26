package com.grupo4.trabajo.Servicios;
import com.grupo4.trabajo.Cliente;
import com.grupo4.trabajo.Exceptions.EsDeudorException;
import com.grupo4.trabajo.Exceptions.NoCantLimpiezasDisponibleException;
import com.grupo4.trabajo.Exceptions.NoCantOrdenamientoDisponibleException;
import com.grupo4.trabajo.Pedido;
import com.grupo4.trabajo.Robots.SuperficieEnum;
import com.grupo4.trabajo.Servicios.ServicioCliente.ActualizadorServicio;
import com.grupo4.trabajo.Servicios.ServicioCliente.Economic;
import com.grupo4.trabajo.Servicios.ServicioCliente.Servicio;
import com.grupo4.trabajo.Superficie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EconomicTest {
   /* Pedido pedidoEco;
    Servicio servicio;
    Cliente cliente;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        servicio = new Economic();
        cliente = new Cliente(servicio);
        pedidoEco = new Pedido(true,new Superficie(SuperficieEnum.MUEBLES), new Superficie(SuperficieEnum.PISOS),new Superficie(SuperficieEnum.PISOS));
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        cliente.setDeuda(0);
        servicio.setCantLimpiezas(3);
    }


    @Test
    void ClienteEconomicSolicitaPedidoYEsRechazadoPorSerDeudor(){
        cliente.setDeuda(2);
        assertThrows(EsDeudorException.class, () -> servicio.getPedidoValidator().validarPedido(pedidoEco,cliente));
    }

    @Test
    void ClienteEconomicSolicitaPedidoDeOrdenamientosYesRechazadoPorqueElServicioNoOfreceOrdenamientos(){
        assertThrows(NoCantOrdenamientoDisponibleException.class, () -> servicio.getPedidoValidator().validarPedido(pedidoEco,cliente));
    }

    @Test
    void ClienteEconomicConServiciosDeLimpiezasAgotadasSolicitaUnPedidoDeLimpiezaYEsRechazada(){
        servicio.setCantLimpiezas(0);
        assertThrows(NoCantLimpiezasDisponibleException.class, () -> servicio.getPedidoValidator().validarPedido(pedidoEco,cliente));
    }

    @Test
    void ClienteEconomicSinDeudaSolicitaUnPedidoDeLimpiezaYSeLeDescuentaLaCantidadDeLimpiezas(){
        int cantLim = servicio.getCantLimpiezas();
        pedidoEco = new Pedido(true,null, new Superficie(SuperficieEnum.PISOS) ,null);
        ActualizadorServicio.actualizarServicio(pedidoEco,servicio);
        assertEquals(cantLim-1,servicio.getCantLimpiezas());
    }
*/
}
