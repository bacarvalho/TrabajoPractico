package com.grupo4.trabajo.Servicios;

import com.grupo4.trabajo.Pedido;
import com.grupo4.trabajo.Robots.Robot;
import com.grupo4.trabajo.Validators.pedidoValidatorPlatinium;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

//Faltan todas las e

public class Platinium extends Servicio{
    public Platinium(){
        setLimiteDeuda(getCouta());
        setPedidoValidator(new pedidoValidatorPlatinium());

    }

    //Esto lo modificaria a "Robot" porque entiendo que esto deberia devolverte el robot que se le va a asignar.
    //Otro tema para charlar: No deberiamos definir de que tipo va a ser la Collection?
}
