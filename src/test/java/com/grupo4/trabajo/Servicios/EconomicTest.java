package com.grupo4.trabajo.Servicios;
import com.grupo4.trabajo.Cliente;
import com.grupo4.trabajo.Exceptions.NoCantLimpiezasDisponibleException;
import com.grupo4.trabajo.Exceptions.NoCantOrdenamientoDisponibleException;
import com.grupo4.trabajo.Pedido;
import com.grupo4.trabajo.Robots.SuperficieEnum;
import com.grupo4.trabajo.Superficie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EconomicTest {


    Pedido pedidoEco;
    PedidosService servicio;
    Cliente cliente;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        servicio = new Economic();
        pedidoEco = new Pedido(true,new Superficie(SuperficieEnum.MUEBLES), new Superficie(SuperficieEnum.PISOS),new Superficie(SuperficieEnum.PISOS));
        cliente = new Cliente();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }




    @Test
    void TpCaso1EconomicNoPudeOrdenar() throws NoCantLimpiezasDisponibleException, NoCantOrdenamientoDisponibleException {
        /*
         * 1. Un cliente Economic realiza un pedido de limpieza y ordenamiento. El pedido es rechazado ya que no puede solicitar ordenamiento.
         */

        servicio.LimpiezasDisponibles(pedidoEco,cliente);
        assertThrows(NoCantOrdenamientoDisponibleException.class, () -> servicio.OrdenamientosDisponibles(pedidoEco,cliente));
    }

}
