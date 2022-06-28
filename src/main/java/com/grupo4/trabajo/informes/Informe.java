package com.grupo4.trabajo.informes;

import com.grupo4.trabajo.Cliente;
import com.grupo4.trabajo.Empleado.Empleado;
import com.grupo4.trabajo.Pedido.Pedido;
import com.grupo4.trabajo.Robots.Robot;

import java.util.List;

public class Informe {
    private int cantidadPedidosSimples;
    private int cantidadPedidosComplejos;
    private final static int AJUSTE_COMUN_DEFINIDO=3;
    private EstrategiaTarea estrategiaTarea;

    public int getAjusteComunDefinido() {
        return AJUSTE_COMUN_DEFINIDO;
    }

    public EstrategiaTarea getEstrategia() {
        return estrategiaTarea;
    }

    public void setEstrategia(EstrategiaTarea estrategiaTarea) {
        this.estrategiaTarea = estrategiaTarea;
    }

    public Informe(){
        this.cantidadPedidosComplejos=0;
        this.cantidadPedidosSimples=0;
    }

    //calcula costo del pedido para la empresa
    public float calcularCostoPedido(Pedido pedido, List<Robot> robotList, Empleado empleado){

        //si no se hizo un pedido de limpieza acompañado al de reparacion, asumimos que la tarea es simple
        if(pedido.getPedidoLimpieza()==null || pedido.getPedidoLimpieza().LimpiezaSimple()){
            setEstrategia(new TareaSimple());
        } else{
            setEstrategia(new TareaCompleja());
        }
        return estrategiaTarea.calcularCosto(pedido, robotList,empleado);
    }

    public float calcularCostoCliente(Cliente cliente){
        float totalCostoCliente=0;
        List<Float> costosCliente = cliente.getCostosDeServicios();
        for(int i = 0; i<costosCliente.size();i++){
            totalCostoCliente+=costosCliente.get(i);
        }
        return  totalCostoCliente;
    }

    public int getCantidadPedidosSimples() {
        return cantidadPedidosSimples;
    }

    public void setCantidadPedidosSimples(int cantidadPedidosSimples) {
        this.cantidadPedidosSimples = cantidadPedidosSimples;
    }

    public int getCantidadPedidosComplejos() {
        return cantidadPedidosComplejos;
    }

    public void setCantidadPedidosComplejos(int cantidadPedidosComplejos) {
        this.cantidadPedidosComplejos = cantidadPedidosComplejos;
    }

    public void incrementarContadorPedidos(Pedido pedido){
        if(pedido.getPedidoLimpieza().LimpiezaSimple()){
            setCantidadPedidosSimples(getCantidadPedidosSimples()+1);
        }else{
            setCantidadPedidosComplejos(getCantidadPedidosComplejos()+1);
        }
    }

}

