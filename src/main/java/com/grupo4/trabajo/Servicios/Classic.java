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
    public void validarPedido(Pedido pedido, Cliente cliente) throws EsDeudorException, NoCantOrdenamientoDisponibleException {
        try{
            validarDeuda(cliente);
            ordenamientosDisponibles(pedido);

        }catch (NoCantOrdenamientoDisponibleException | EsDeudorException e){
            throw e;
        }
    }

    private void ordenamientosDisponibles(Pedido pedido) throws NoCantOrdenamientoDisponibleException{
        if(pedido.requiereOrdenamiento() && getCantOrdenamientos()==0){
            throw new NoCantOrdenamientoDisponibleException("No hay suficiente ordenamiento");
        }
    }

    public void validarDeuda(Cliente cliente) throws EsDeudorException {
        if(cliente.getDeuda()>=getLimiteDeuda()){
            throw new EsDeudorException("Cliente es deudor");
        }
    }
}
