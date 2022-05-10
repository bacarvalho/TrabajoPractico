package com.grupo4.trabajo.Servicios;
import com.grupo4.trabajo.Empresa;
import com.grupo4.trabajo.Exceptions.EsDeudorException;
import com.grupo4.trabajo.Exceptions.NoCantLimpiezasDisponibleException;
import com.grupo4.trabajo.Exceptions.NoCantOrdenamientoDisponibleException;
import com.grupo4.trabajo.Pedido;
import com.grupo4.trabajo.Robots.*;
import com.grupo4.trabajo.*;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class Testeo4TP {
    Classic servicio;
    Cliente cliente;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        servicio = new Classic();
        cliente=new Cliente();
        cliente.setDeuda(2000);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }


    //Test Case Nro 2.

    @Test
    void denegarPedidoPorDeuda() {

        boolean thrown = false;

        try{
            servicio.validarDeuda(cliente);
        }catch(EsDeudorException e){
            thrown=true;
        }

        assertTrue(thrown);

    }
}

