package com.grupo4.trabajo.Validators;

import com.grupo4.trabajo.Cliente;
import com.grupo4.trabajo.Exceptions.EsDeudorException;

public interface DeudorValidator {
    void esDeudor(Cliente cliente) throws EsDeudorException;
}
