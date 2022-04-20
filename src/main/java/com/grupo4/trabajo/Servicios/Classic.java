package com.grupo4.trabajo.Servicios;

import com.grupo4.trabajo.Pedido;

public class Classic extends Servicio{
    public Classic(){
        setLimiteDeuda(2000);
        setCantOrdenamientos(3);
    }

    @Override
    public void validarPedido(Pedido pedido, float deuda) {

    }
}
