package com.grupo4.trabajo.Servicios;

import com.grupo4.trabajo.*;
import com.grupo4.trabajo.Empleado.Empleado;
import com.grupo4.trabajo.Robots.Robot;
import com.grupo4.trabajo.Robots.SuperficieEnum;
import com.grupo4.trabajo.Servicios.EmpleadoService.BuscadorEmpleados;
import com.grupo4.trabajo.Servicios.ServicioCliente.Classic;
import com.grupo4.trabajo.Servicios.ServicioCliente.Economic;
import com.grupo4.trabajo.Servicios.ServicioCliente.Servicio;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CostoEmpleadosTest {
    @Test
    void calculadorCostoDeReparacionGasDeComplejidadBaja(){
        Servicio servicio=new Economic();

        Cliente cliente = new Cliente(servicio);
        PedidoLimpieza pedidoLimpieza=null;
        PedidoReparacion pedidoReparacion=new PedidoReparacion(TipoReparacion.GAS,1);
        Pedido pedido=new Pedido(pedidoLimpieza,pedidoReparacion);
        Empleado empleado= BuscadorEmpleados.BuscarEmpleado(pedidoReparacion);
        assertEquals(343.75f,Empresa.getInstancia().getInforme().calcularCostoPedido(pedido, null,empleado));
    }

    @Test
    void calculadorCostoDeReparacionGasDeComplejidadMedia(){
        Servicio servicio=new Classic();

        Cliente cliente = new Cliente(servicio);
        PedidoLimpieza pedidoLimpieza=null;
        PedidoReparacion pedidoReparacion=new PedidoReparacion(TipoReparacion.GAS,5);
        Pedido pedido=new Pedido(pedidoLimpieza,pedidoReparacion);
        Empleado empleado= BuscadorEmpleados.BuscarEmpleado(pedidoReparacion);
        assertEquals(1718.75f,Empresa.getInstancia().getInforme().calcularCostoPedido(pedido, null,empleado));
    }

    @Test
    void calculadorCostoDeReparacionGasDeComplejidadAlta(){
        Servicio servicio=new Classic();

        Cliente cliente = new Cliente(servicio);
        PedidoLimpieza pedidoLimpieza=null;
        PedidoReparacion pedidoReparacion=new PedidoReparacion(TipoReparacion.GAS,8);
        Pedido pedido=new Pedido(pedidoLimpieza,pedidoReparacion);
        Empleado empleado= BuscadorEmpleados.BuscarEmpleado(pedidoReparacion);
        assertEquals(2750f,Empresa.getInstancia().getInforme().calcularCostoPedido(pedido, null,empleado));
    }


    @Test
    void calculadorCostoDeReparacionElectricidadDeComplejidadBaja(){
        Servicio servicio=new Economic();

        Cliente cliente = new Cliente(servicio);
        PedidoLimpieza pedidoLimpieza=null;
        PedidoReparacion pedidoReparacion=new PedidoReparacion(TipoReparacion.ELECTRICIDAD,1);
        Pedido pedido=new Pedido(pedidoLimpieza,pedidoReparacion);
        Empleado empleado= BuscadorEmpleados.BuscarEmpleado(pedidoReparacion);
        assertEquals(375f,Empresa.getInstancia().getInforme().calcularCostoPedido(pedido, null,empleado));
    }

    @Test
    void calculadorCostoDeReparacionElectricidadDeComplejidadMedia(){
        Servicio servicio=new Classic();

        Cliente cliente = new Cliente(servicio);
        PedidoLimpieza pedidoLimpieza=null;
        PedidoReparacion pedidoReparacion=new PedidoReparacion(TipoReparacion.ELECTRICIDAD,5);
        Pedido pedido=new Pedido(pedidoLimpieza,pedidoReparacion);
        Empleado empleado= BuscadorEmpleados.BuscarEmpleado(pedidoReparacion);
        assertEquals(1875f,Empresa.getInstancia().getInforme().calcularCostoPedido(pedido, null,empleado));
    }

    @Test
    void calculadorCostoDeReparacionElectricidadDeComplejidadAlta(){
        Servicio servicio=new Classic();

        Cliente cliente = new Cliente(servicio);
        PedidoLimpieza pedidoLimpieza=null;
        PedidoReparacion pedidoReparacion=new PedidoReparacion(TipoReparacion.ELECTRICIDAD,8);
        Pedido pedido=new Pedido(pedidoLimpieza,pedidoReparacion);
        Empleado empleado= BuscadorEmpleados.BuscarEmpleado(pedidoReparacion);
        assertEquals(3000f,Empresa.getInstancia().getInforme().calcularCostoPedido(pedido, null,empleado));
    }

}
