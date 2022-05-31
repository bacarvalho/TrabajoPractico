package com.grupo4.trabajo.Servicios;


import com.grupo4.trabajo.*;
import com.grupo4.trabajo.Exceptions.EsDeudorException;
import com.grupo4.trabajo.Exceptions.NoCantOrdenamientoDisponibleException;
import com.grupo4.trabajo.Validators.PedidoValidatorClassic;

public class Classic extends Servicio{
    public Classic(){
        setLimiteDeuda(2000);
        setCantOrdenamientos(3);
        setPedidoValidator(new PedidoValidatorClassic());
    }
}
