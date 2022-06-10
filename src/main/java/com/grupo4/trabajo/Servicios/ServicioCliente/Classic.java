package com.grupo4.trabajo.Servicios.ServicioCliente;


import com.grupo4.trabajo.Servicios.RobotsService.BuscadorRobotsEconomic;
import com.grupo4.trabajo.Servicios.RobotsService.RobotsService;
import com.grupo4.trabajo.Validators.PedidoValidatorClassic;

public class Classic extends Servicio{
    public Classic(){
        setLimiteDeuda(2000);
        setCantOrdenamientos(3);
        setPedidoValidator(new PedidoValidatorClassic());
        setRobotsService(new RobotsService(new BuscadorRobotsEconomic()));
    }
}
