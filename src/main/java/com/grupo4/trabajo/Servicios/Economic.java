package com.grupo4.trabajo.Servicios;

import com.grupo4.trabajo.Exceptions.EsDeudorException;
import com.grupo4.trabajo.Exceptions.NoCantLimpiezasDisponibleException;
import com.grupo4.trabajo.Exceptions.NoCantOrdenamientoDisponibleException;
import com.grupo4.trabajo.Cliente;
import com.grupo4.trabajo.Pedido;

public class Economic extends Servicio{
    public Economic(){
        setLimiteDeuda(0);
        setCantLimpiezas(3);
        setCantOrdenamientos(0);
    }

    @Override
    public void validarPedido(Pedido pedido, Cliente cliente)  {
        try {
            EsDeudor(pedido, cliente);
            LimpiezasDisponibles(pedido, cliente);
            OrdenamientosDisponibles(pedido, cliente);
        }
        catch (EsDeudorException | NoCantLimpiezasDisponibleException | NoCantOrdenamientoDisponibleException e ) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void EsDeudor(Pedido pedido, Cliente cliente) throws EsDeudorException{
        if(cliente.getDeuda() > getLimiteDeuda()){
            throw new EsDeudorException("El cliente Economic no puede deber");
        }

    }

    @Override
    public void LimpiezasDisponibles(Pedido pedido, Cliente cliente) throws NoCantLimpiezasDisponibleException{
        if(pedido.requiereLimpieza()){
            if(getCantLimpiezas() == 0){
                throw new NoCantLimpiezasDisponibleException("El cliente no tiene más limpiezas disponibles");
            }
        }
    }

    @Override
    public void OrdenamientosDisponibles(Pedido pedido, Cliente cliente) throws NoCantOrdenamientoDisponibleException{

        if(pedido.requiereOrdenamiento()){
            throw new NoCantOrdenamientoDisponibleException("El cliente Economic no puede ordenar");
        }
    }

}