package com.grupo4.trabajo.Servicios;
import com.grupo4.trabajo.Cliente;
import com.grupo4.trabajo.Empresa;
import com.grupo4.trabajo.Exceptions.NoCantLimpiezasDisponibleException;
import com.grupo4.trabajo.Exceptions.NoCantOrdenamientoDisponibleException;
import com.grupo4.trabajo.Pedido;
import com.grupo4.trabajo.Robots.K311Y_fl;
import com.grupo4.trabajo.Robots.Robot;
import com.grupo4.trabajo.Robots.S031RTY;
import com.grupo4.trabajo.Robots.Superficie;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EconomicTest {



    Pedido pedidoEco;
    Economic servicio;
    Cliente cliente;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        servicio = new Economic();
        pedidoEco = new Pedido(true,true, Superficie.PISOS,true,false);
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
