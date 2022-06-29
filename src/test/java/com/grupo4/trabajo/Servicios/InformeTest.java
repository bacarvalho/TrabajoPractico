package com.grupo4.trabajo.Servicios;

import com.grupo4.trabajo.Cliente;
import com.grupo4.trabajo.Empleado.Empleado;
import com.grupo4.trabajo.Empresa;
import com.grupo4.trabajo.Exceptions.EsDeudorException;
import com.grupo4.trabajo.Exceptions.NoCantLimpiezasDisponibleException;
import com.grupo4.trabajo.Exceptions.NoCantOrdenamientoDisponibleException;
import com.grupo4.trabajo.Pedido.*;
import com.grupo4.trabajo.Robots.*;
import com.grupo4.trabajo.Servicios.EmpleadoService.BuscadorEmpleados;
import com.grupo4.trabajo.Servicios.ServicioCliente.Classic;
import com.grupo4.trabajo.Servicios.ServicioCliente.Platinium;
import com.grupo4.trabajo.Servicios.ServicioCliente.Servicio;
import com.grupo4.trabajo.informes.Informe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InformeTest {

    Pedido pedido;
    Pedido pedido2;
    Pedido pedido3;
    Cliente cliente;
    Servicio servicio;
    List<Robot> robotsPedido;

    @BeforeEach
    void setUp() {



        Superficie sup = new Superficie(SuperficieEnum.PISOSYMUEBLES);
        sup.setResiduo(TipoResiduos.POLVO);

        pedido = new Pedido(
                    new PedidoLimpieza(new Superficie(null), sup,new Superficie(SuperficieEnum.PISOS),0,5),
                    new PedidoReparacion(TipoReparacion.ELECTRICIDAD, 7)
                );

        pedido2 = new Pedido(null, new PedidoReparacion(TipoReparacion.ELECTRICIDAD, 3));

        Superficie sup2 = new Superficie(SuperficieEnum.PISOSYMUEBLES);
        sup2.setResiduo(TipoResiduos.BARRO);
        pedido3 = new Pedido(new PedidoLimpieza(new Superficie(null), sup,new Superficie(SuperficieEnum.PISOS),3,20), null );

    }

    @Test
    public void cantidadDePedidosSimplesYComplejosQueTuvoLaJornada() throws EsDeudorException, NoCantOrdenamientoDisponibleException, NoCantLimpiezasDisponibleException {
        servicio = new Classic();
        servicio.setCantOrdenamientos(5);
        cliente = new Cliente(servicio);

        cliente.pedirPedido(pedido);
        cliente.pedirPedido(pedido2);
        cliente.pedirPedido(pedido3);

        assertEquals(1, Empresa.getInstancia().getInforme().getCantidadPedidosSimples());  //Al ser una instacia el test falla, porque cambia el valor de la cantidad. Si se corre solo, anda.
        assertEquals(2, Empresa.getInstancia().getInforme().getCantidadPedidosComplejos());
    }

    @Test
    public void conocerLosGastosTotalesRealizadosPorUnCliente() throws EsDeudorException, NoCantOrdenamientoDisponibleException, NoCantLimpiezasDisponibleException {

        float total = 0;
        Empleado empleado;

        servicio = new Classic();
        servicio.setCantOrdenamientos(3);
        cliente = new Cliente(servicio);

        cliente.pedirPedido(pedido);
        cliente.pedirPedido(pedido2);
        cliente.pedirPedido(pedido3);

        empleado = BuscadorEmpleados.BuscarEmpleado(pedido.getPedidoReparacion());
        robotsPedido = servicio.getRobotsService().getBuscadorRobots().buscarRobots(pedido.getPedidoLimpieza(), Empresa.getInstancia().getRobots());
        total += Empresa.getInstancia().getInforme().calcularCostoPedido(pedido,robotsPedido, empleado);


        empleado = BuscadorEmpleados.BuscarEmpleado(pedido2.getPedidoReparacion());
        robotsPedido = servicio.getRobotsService().getBuscadorRobots().buscarRobots(pedido2.getPedidoLimpieza(), Empresa.getInstancia().getRobots());

        total += Empresa.getInstancia().getInforme().calcularCostoPedido(pedido2,robotsPedido, empleado);

        empleado = null; // el pedido 3 no requiere de reparacion.
        robotsPedido = servicio.getRobotsService().getBuscadorRobots().buscarRobots(pedido3.getPedidoLimpieza(), Empresa.getInstancia().getRobots());
        total += Empresa.getInstancia().getInforme().calcularCostoPedido(pedido3,robotsPedido, empleado);

        assertEquals(Empresa.getInstancia().getInforme().calcularCostoCliente(cliente), total);
    }

}
