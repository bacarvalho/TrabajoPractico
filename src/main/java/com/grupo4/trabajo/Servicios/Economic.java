package com.grupo4.trabajo.Servicios;

import Exceptions.EsDeudorException;
import Exceptions.NoCantLimpiezasDisponibleException;
import Exceptions.NoCantOrdenamientoDisponibleException;
import com.grupo4.trabajo.Cliente;
import com.grupo4.trabajo.Pedido;

public class Economic extends Servicio{
    public Economic(){
        setLimiteDeuda(0);
        setCantLimpiezas(3);
        setCantOrdenamientos(0);
    }

    @Override
    public void validarPedido(Pedido pedido, Cliente cliente) throws EsDeudorException, NoCantOrdenamientoDisponibleException, NoCantLimpiezasDisponibleException {
        try {
            EsDeudor(pedido, cliente);
            LimpiezasDisponibles(pedido, cliente);
            OrdenamientosDisponibles(pedido, cliente);
        }
        catch (EsDeudorException e) {}
        catch (NoCantLimpiezasDisponibleException e) {}
        catch (NoCantOrdenamientoDisponibleException e){}
    }


    @Override
    public void EsDeudor(Pedido pedido, Cliente cliente) throws EsDeudorException{
        if(cliente.getDeuda() > getLimiteDeuda()){
            throw new EsDeudorException();
        }

    }

    @Override
    public void LimpiezasDisponibles(Pedido pedido, Cliente cliente) throws NoCantLimpiezasDisponibleException{
        if(pedido.isRequiereLimpieza()){
            if(getCantLimpiezas() == 0){
                throw new NoCantLimpiezasDisponibleException();
            }
        }
    }

    @Override
    public void OrdenamientosDisponibles(Pedido pedido, Cliente cliente) throws NoCantOrdenamientoDisponibleException{

        if(pedido.isOrdenamiento()){
            throw new NoCantOrdenamientoDisponibleException();
        }
    }

}