package com.grupo4.trabajo.Robots;

public class K311Y_fu extends Robot {
    public K311Y_fu() {
        setSuperficie(SuperficieEnum.MUEBLES);
        setPuedeOrdenar(false);
        setPuedeLustrar(true);
        setCosto(500f);
    }

    @Override
    public String toString() {
        return "K311Y-fu";
    }
}
