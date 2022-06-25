package com.grupo4.trabajo.Servicios;

import com.grupo4.trabajo.Cliente;
import com.grupo4.trabajo.Exceptions.EsDeudorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AceptarPedidoSinExcedenteDeDeudaTest {
    Classic servicio;
    Cliente cliente;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        servicio = new Classic();
        cliente=new Cliente();
        cliente.setDeuda(500);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }


    //Test Case Nro 2.

    @Test
    void aceptarPedidoPorqueNoSuperaLimiteDeuda() {

        boolean thrown = true;

        try{
            servicio.validarDeuda(cliente);
        }catch(EsDeudorException e){
            thrown=false;
        }

        assertTrue(thrown);

    }
}
