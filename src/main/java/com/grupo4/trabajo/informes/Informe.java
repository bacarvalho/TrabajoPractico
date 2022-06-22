package com.grupo4.trabajo.informes;

import com.grupo4.trabajo.Cliente;
import com.grupo4.trabajo.Pedido;

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

    public void calcularCostoPedido(Pedido pedido){
        if(pedido.limpiezaSimple()){
            setEstrategia(new TareaSimple());
        } else{
            setEstrategia(new TareaCompleja());
        }
        estrategia.calcularCosto(pedido);
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

    public float getAjusteComunDefinido() {
        return ajusteComunDefinido;
    }

    public void setAjusteComunDefinido(float ajusteComunDefinido) {
        this.ajusteComunDefinido = ajusteComunDefinido;
    }
}
