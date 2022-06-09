package com.grupo4.trabajo.Servicios;

import com.grupo4.trabajo.Validators.PedidoValidatorEconomic;

public class Economic extends Servicio{
    public Economic(){
        setLimiteDeuda(0);
        setCantLimpiezas(3);
        setCantOrdenamientos(0);
        setPedidoValidator(new PedidoValidatorEconomic());
        setRobotsService(new RobotsService(new BuscadorRobotsEconomic()));
    }

}