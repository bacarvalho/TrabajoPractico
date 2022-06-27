package com.grupo4.trabajo.Validators;

import com.grupo4.trabajo.Cliente;
import com.grupo4.trabajo.Exceptions.EsDeudorException;
import com.grupo4.trabajo.Exceptions.NoCantLimpiezasDisponibleException;
import com.grupo4.trabajo.Exceptions.NoCantOrdenamientoDisponibleException;
import com.grupo4.trabajo.Pedido.Pedido;

public class PedidoValidatorEconomic implements PedidoValidator,DeudorValidator,LimpiezasDisponiblesValidator,OrdenamientosDisponiblesValidator{
    @Override
    public void validarPedido(Pedido pedido, Cliente cliente) throws EsDeudorException, NoCantOrdenamientoDisponibleException, NoCantLimpiezasDisponibleException {
        try{
            esDeudor(cliente);
            limpiezasDisponibles(pedido,cliente);
            ordenamientosDisponibles(pedido,cliente);
        }
        catch (EsDeudorException | NoCantLimpiezasDisponibleException | NoCantOrdenamientoDisponibleException e){
            throw e;
        }
    }

    @Override
    public void esDeudor(Cliente cliente) throws EsDeudorException{
        if(cliente.getDeuda() > cliente.getTipoServicio().getLimiteDeuda()){
            throw new EsDeudorException("El cliente Economic no puede deber");
        }
    }

    @Override
    public void limpiezasDisponibles(Pedido pedido, Cliente cliente) throws  NoCantLimpiezasDisponibleException {
        if(pedido.getPedidoLimpieza().requiereLimpieza()){
            if(cliente.getTipoServicio().getCantLimpiezas() == 0){
                throw new NoCantLimpiezasDisponibleException("El cliente no tiene más limpiezas disponibles");
            }
        }
    }

    @Override
    public void ordenamientosDisponibles(Pedido pedido, Cliente cliente) throws NoCantOrdenamientoDisponibleException{
        if(pedido.getPedidoLimpieza().requiereOrdenamiento()){
            throw new NoCantOrdenamientoDisponibleException("El cliente Economic no puede ordenar");
        }
    }

}
