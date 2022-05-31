package com.grupo4.trabajo.Validators;

import com.grupo4.trabajo.Cliente;
import com.grupo4.trabajo.Pedido;

public interface PedidoValidator {
    void validarPedido(Pedido pedido, Cliente cliente);
}
