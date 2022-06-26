package com.grupo4.trabajo.Servicios;

import com.grupo4.trabajo.CalculadoReparacion.CalculadorReparacion;
import com.grupo4.trabajo.PedidoReparacion;
import com.grupo4.trabajo.TipoReparacion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CostoReparacionTest {
    @Test
    void GasComplejidadUno(){
        PedidoReparacion pedidoReparacion = new PedidoReparacion(TipoReparacion.GAS,1);
        assertEquals(1343.75f, CalculadorReparacion.calcularCostoReparacion(pedidoReparacion));
    }

    @Test
    void GasComplejidadDos(){
        PedidoReparacion pedidoReparacion = new PedidoReparacion(TipoReparacion.GAS,2);
        assertEquals(1687.5f, CalculadorReparacion.calcularCostoReparacion(pedidoReparacion));
    }

    @Test
    void GasComplejidadTres(){
        PedidoReparacion pedidoReparacion = new PedidoReparacion(TipoReparacion.GAS,3);
        assertEquals(4381.25f, CalculadorReparacion.calcularCostoReparacion(pedidoReparacion));
    }

    @Test
    void GasComplejidadCuatro(){
        PedidoReparacion pedidoReparacion = new PedidoReparacion(TipoReparacion.GAS,4);
        assertEquals(4725f, CalculadorReparacion.calcularCostoReparacion(pedidoReparacion));
    }

    @Test
    void GasComplejidadCinco(){
        PedidoReparacion pedidoReparacion = new PedidoReparacion(TipoReparacion.GAS,5);
        assertEquals(5068.75f, CalculadorReparacion.calcularCostoReparacion(pedidoReparacion));
    }

    @Test
    void GasComplejidadSeis(){
        PedidoReparacion pedidoReparacion = new PedidoReparacion(TipoReparacion.GAS,6);
        assertEquals(5412.5f, CalculadorReparacion.calcularCostoReparacion(pedidoReparacion));
    }

    @Test
    void GasComplejidadSiete(){
        PedidoReparacion pedidoReparacion = new PedidoReparacion(TipoReparacion.GAS,7);
        assertEquals(8795.25f, CalculadorReparacion.calcularCostoReparacion(pedidoReparacion));
    }

    @Test
    void GasComplejidadOcho(){
        PedidoReparacion pedidoReparacion = new PedidoReparacion(TipoReparacion.GAS,8);
        assertEquals(9139f, CalculadorReparacion.calcularCostoReparacion(pedidoReparacion));
    }

    @Test
    void ElectricidadComplejidadUno(){
        PedidoReparacion pedidoReparacion = new PedidoReparacion(TipoReparacion.ELECTRICIDAD,1);
        assertEquals(2375f, CalculadorReparacion.calcularCostoReparacion(pedidoReparacion));
    }

    @Test
    void ElectricidadComplejidadDos(){
        PedidoReparacion pedidoReparacion = new PedidoReparacion(TipoReparacion.ELECTRICIDAD,2);
        assertEquals(2750f, CalculadorReparacion.calcularCostoReparacion(pedidoReparacion));
    }

    @Test
    void ElectricidadComplejidadTres(){
        PedidoReparacion pedidoReparacion = new PedidoReparacion(TipoReparacion.ELECTRICIDAD,3);
        assertEquals(5698f, CalculadorReparacion.calcularCostoReparacion(pedidoReparacion));
    }

    @Test
    void ElectricidadComplejidadCuatro(){
        PedidoReparacion pedidoReparacion = new PedidoReparacion(TipoReparacion.ELECTRICIDAD,4);
        assertEquals(6073f, CalculadorReparacion.calcularCostoReparacion(pedidoReparacion));
    }

    @Test
    void ElectricidadComplejidadCinco(){
        PedidoReparacion pedidoReparacion = new PedidoReparacion(TipoReparacion.ELECTRICIDAD,5);
        assertEquals(6448f, CalculadorReparacion.calcularCostoReparacion(pedidoReparacion));
    }

    @Test
    void ElectricidadComplejidadSeis(){
        PedidoReparacion pedidoReparacion = new PedidoReparacion(TipoReparacion.ELECTRICIDAD,6);
        assertEquals(6823f, CalculadorReparacion.calcularCostoReparacion(pedidoReparacion));
    }

    @Test
    void ElectricidadComplejidadSiete(){
        PedidoReparacion pedidoReparacion = new PedidoReparacion(TipoReparacion.ELECTRICIDAD,7);
        assertEquals(9984f, CalculadorReparacion.calcularCostoReparacion(pedidoReparacion));
    }

    @Test
    void ElectricidadComplejidadOcho(){
        PedidoReparacion pedidoReparacion = new PedidoReparacion(TipoReparacion.ELECTRICIDAD,8);
        assertEquals(10359f, CalculadorReparacion.calcularCostoReparacion(pedidoReparacion));
    }

}
