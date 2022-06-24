package com.grupo4.trabajo.informes;

import com.grupo4.trabajo.Cliente;
import com.grupo4.trabajo.Pedido;
import com.grupo4.trabajo.Robots.Robot;

import java.util.List;

public class Informe {
    private int cantidadPedidosSimples;
    private int cantidadPedidosComplejos;
    private final static float AJUSTE_COMUN_DEFINIDO=3;
    private Estrategia estrategia;

    public Estrategia getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(Estrategia estrategia) {
        this.estrategia = estrategia;
    }

    public Informe(){
        this.cantidadPedidosComplejos=0;
        this.cantidadPedidosSimples=0;
    }

    public float calcularCostoPedido(Pedido pedido, List<Robot> robotList){
        if(pedido.limpiezaSimple()){
            setEstrategia(new TareaSimple());
        } else{
            setEstrategia(new TareaCompleja());
        }
        return estrategia.calcularCosto(pedido, robotList);
    }

    public void calcularCostoCliente(Cliente cliente){

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
        if(pedido.limpiezaSimple()){
            setCantidadPedidosSimples(getCantidadPedidosSimples()+1);
        }else{
            setCantidadPedidosComplejos(getCantidadPedidosComplejos()+1);
        }
    }

}
