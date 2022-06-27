package com.grupo4.trabajo.Validators;

import com.grupo4.trabajo.Cliente;
import com.grupo4.trabajo.Exceptions.EsDeudorException;
import com.grupo4.trabajo.Exceptions.NoCantLimpiezasDisponibleException;
import com.grupo4.trabajo.Exceptions.NoCantOrdenamientoDisponibleException;
import com.grupo4.trabajo.Pedido.Pedido;

public class pedidoValidatorPlatinium implements PedidoValidator,DeudorValidator{
    @Override
    public void validarPedido(Pedido pedido, Cliente cliente) throws EsDeudorException, NoCantOrdenamientoDisponibleException, NoCantLimpiezasDisponibleException {
        try{
            esDeudor(cliente);
        }
        catch (EsDeudorException e){
            throw e;
        }
    }

    @Override
    public void esDeudor(Cliente cliente) throws EsDeudorException {
        if(cliente.getDeuda() > cliente.getTipoServicio().getLimiteDeuda()){
            throw new EsDeudorException("Cuenta con una deuda mayor al de una cuota");
        }
    }
}
