package com.grupo4.trabajo.Robots;

import com.grupo4.trabajo.Pedido.SuperficieEnum;

public class P011H extends Robot{
    public P011H(){
        setSuperficie(SuperficieEnum.PISOS);
        setPuedeOrdenar(false);
        setPuedeLustrar(true);
        setCosto(1500f);
    }

    @Override
    public String toString() {
        return "P011H";
    }
}
