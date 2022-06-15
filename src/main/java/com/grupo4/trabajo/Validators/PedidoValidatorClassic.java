package com.grupo4.trabajo.Validators;

import com.grupo4.trabajo.Cliente;
import com.grupo4.trabajo.Exceptions.EsDeudorException;
import com.grupo4.trabajo.Exceptions.NoCantLimpiezasDisponibleException;
import com.grupo4.trabajo.Exceptions.NoCantOrdenamientoDisponibleException;
import com.grupo4.trabajo.Pedido;

public class PedidoValidatorClassic implements PedidoValidator,DeudorValidator,OrdenamientosDisponiblesValidator{
    @Override
    public void validarPedido(Pedido pedido, Cliente cliente) throws EsDeudorException, NoCantOrdenamientoDisponibleException, NoCantLimpiezasDisponibleException {
        try{
            esDeudor(cliente);
            ordenamientosDisponibles(pedido,cliente);
        }
        catch (EsDeudorException | NoCantOrdenamientoDisponibleException e){
            throw e;
        }
    }

    @Override
    public void esDeudor(Cliente cliente) throws EsDeudorException {
        if(cliente.getDeuda() > cliente.getTipoServicio().getLimiteDeuda()){
            throw new EsDeudorException("Cliente es deudor");
        }
    }

    @Override
    public void ordenamientosDisponibles(Pedido pedido, Cliente cliente) throws NoCantOrdenamientoDisponibleException {
        if(pedido.requiereOrdenamiento() && cliente.getTipoServicio().getCantOrdenamientos() ==0 ){
            throw new NoCantOrdenamientoDisponibleException("No hay suficiente ordenamiento");
        }
    }
}
