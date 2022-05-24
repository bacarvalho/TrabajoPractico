package com.grupo4.trabajo.Servicios;


import com.grupo4.trabajo.*;
import com.grupo4.trabajo.Exceptions.EsDeudorException;
import com.grupo4.trabajo.Exceptions.NoCantOrdenamientoDisponibleException;

public class Classic extends Servicio{
    public Classic(){
        setLimiteDeuda(2000);
        setCantOrdenamientos(3);
    }

    @Override
    public void validarPedido(Pedido pedido, Cliente cliente) {
        //solo consultamos si pide ordenamiento porque las limpiezas son ilimitadas
        try{
            validarDeuda(cliente);
            ordenamientosDisponibles(pedido);

        }catch (NoCantOrdenamientoDisponibleException | EsDeudorException e){
            System.out.println(e.getMessage());
        }
    }

    private void ordenamientosDisponibles(Pedido pedido) throws NoCantOrdenamientoDisponibleException{
        if(pedido.requiereOrdenamiento() != null && getCantOrdenamientos()==0){
            throw new NoCantOrdenamientoDisponibleException("No hay suficiente ordenamiento");
        }
    }

    public void validarDeuda(Cliente cliente) throws EsDeudorException {
        if(cliente.getDeuda()>=getLimiteDeuda()){
            throw new EsDeudorException("Cliente es deudor");
        }
    }
}
