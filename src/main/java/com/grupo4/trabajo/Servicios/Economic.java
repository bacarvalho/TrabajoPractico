package com.grupo4.trabajo.Servicios;

import com.grupo4.trabajo.Cliente;
import com.grupo4.trabajo.Empresa;
import com.grupo4.trabajo.Pedido;

public class Economic extends Servicio{
    public Economic(){
        setLimiteDeuda(0);
        setCantLimpiezas(3);
        setCantOrdenamientos(0);
    }

    @Override
    public void validarPedido(Pedido pedido, Cliente cliente) {
        if(cliente.getDeuda() > getLimiteDeuda()){
            //EsMorosoException
        }
        if(pedido.isRequiereLimpieza()){
            if(getCantLimpiezas() == 0){
                //NoCantLimpiezasDisponibleException
            }
        }
        if(pedido.isOrdenamiento()){
            //NoCantOrdenamientoDisponibleException
        }
    }
}
