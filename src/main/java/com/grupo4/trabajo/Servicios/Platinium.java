package com.grupo4.trabajo.Servicios;

import com.grupo4.trabajo.Cliente;
import com.grupo4.trabajo.Exceptions.EsDeudorException;
import com.grupo4.trabajo.Exceptions.NoCantLimpiezasDisponibleException;
import com.grupo4.trabajo.Exceptions.NoCantOrdenamientoDisponibleException;
import com.grupo4.trabajo.Pedido;

public class Platinium extends PedidosService {
    public Platinium(){
        setLimiteDeuda(getCouta());

    }

    @Override
    public void validarPedido(Pedido pedido, Cliente cliente) throws EsDeudorException {
        try {
            EsDeudor(pedido, cliente);
        }
        catch (EsDeudorException e) {
            throw e;
        }
    }

    private void EsDeudor(Pedido pedido, Cliente cliente) throws EsDeudorException {
        if(cliente.getDeuda() > getLimiteDeuda()){
            throw new EsDeudorException("Cuenta con una deuda mayor al de una cuota");
        }
    }

}
