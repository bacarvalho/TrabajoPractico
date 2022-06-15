package com.grupo4.trabajo.Validators;

import com.grupo4.trabajo.Cliente;
import com.grupo4.trabajo.Exceptions.NoCantLimpiezasDisponibleException;
import com.grupo4.trabajo.Pedido;

public interface LimpiezasDisponiblesValidator {
    void limpiezasDisponibles(Pedido pedido, Cliente cliente) throws NoCantLimpiezasDisponibleException;
}
