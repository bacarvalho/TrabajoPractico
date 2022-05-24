package com.grupo4.trabajo.Robots;

public class K311Y_a extends Robot{
    public K311Y_a(){
        setSuperficie(SuperficieEnum.PISOSYMUEBLES);
        setPuedeOrdenar(true);
        setPuedeLustrar(true);
        setCosto(5000f);
    }

    @Override
    public String toString() {
        return "K311Y-a";
    }
}
