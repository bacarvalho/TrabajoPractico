package com.grupo4.trabajo.Servicios.ServicioCliente;

import com.grupo4.trabajo.Servicios.RobotsService.BuscadorRobotsPlatinium;
import com.grupo4.trabajo.Servicios.RobotsService.RobotsService;
import com.grupo4.trabajo.Validators.pedidoValidatorPlatinium;

//Faltan todas las e

public class Platinium extends Servicio{
    public Platinium(){
        setLimiteDeuda(getCouta());
        setPedidoValidator(new pedidoValidatorPlatinium());
        setRobotsService(new RobotsService(new BuscadorRobotsPlatinium()));
    }

    //Esto lo modificaria a "Robot" porque entiendo que esto deberia devolverte el robot que se le va a asignar.
    //Otro tema para charlar: No deberiamos definir de que tipo va a ser la Collection?
}
