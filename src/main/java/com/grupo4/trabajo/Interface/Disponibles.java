package com.grupo4.trabajo.Interface;

import com.grupo4.trabajo.Cliente;
import com.grupo4.trabajo.Exceptions.NoCantLimpiezasDisponibleException;
import com.grupo4.trabajo.Exceptions.NoCantOrdenamientoDisponibleException;
import com.grupo4.trabajo.Pedido;

public interface Disponibles {
    //Creo que esto está de mas, no se si hace falta esta interface, pero no creo que sea correcto que estas funciones esten dentro de PedidosService.
    public void LimpiezasDisponibles(Pedido pedido, Cliente cliente) throws NoCantLimpiezasDisponibleException;
    public void OrdenamientosDisponibles(Pedido pedido, Cliente cliente) throws NoCantOrdenamientoDisponibleException;

}
