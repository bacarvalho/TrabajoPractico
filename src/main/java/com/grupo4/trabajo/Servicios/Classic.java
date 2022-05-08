package com.grupo4.trabajo.Servicios;


import com.grupo4.trabajo.*;

public class Classic extends Servicio{
    public Classic(){
        setLimiteDeuda(2000);
        setCantOrdenamientos(3);
    }

    @Override
    public void validarPedido(Pedido pedido, Cliente cliente) {
        //solo consultamos si pide ordenamiento porque las limpiezas son ilimitadas
        try{
            ordenamientosDisponibles(pedido);
            validarDeuda(cliente);
        }catch (NoCantOrdenamientoDisponibleException || EsDeudorException e){}
    }

    private void ordenamientosDisponibles(Pedido pedido) throws NoCantOrdenamientoDisponibleException{
        if(pedido.isOrdenamiento() && getCantOrdenamientos()==0){
            throw new NoCantOrdenamientoDisponibleException();
        }
    }

    private void validarDeuda(Cliente cliente) throws EsDeudorException {
        if(cliente.getDeuda()>getLimiteDeuda()){
            throw new EsDeudorException("Cliente es deudor");
        }
    }
}
