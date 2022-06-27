package com.grupo4.trabajo.Robots;

import com.grupo4.trabajo.Pedido.SuperficieEnum;

public class K311Y_fl extends Robot{
    public K311Y_fl(){
        setSuperficie(SuperficieEnum.PISOS);
        setPuedeOrdenar(false);
        setPuedeLustrar(false);
        setCosto(1000f);
    }

    @Override
    public String toString() {
        return "K311Y-fl";
    }
}
