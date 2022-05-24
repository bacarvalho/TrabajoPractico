package com.grupo4.trabajo;

import com.grupo4.trabajo.Robots.SuperficieEnum;

public class Superficie {
    private SuperficieEnum superficie;

    public Superficie(SuperficieEnum superficie){
        this.superficie = superficie;
    }

    public SuperficieEnum getSuperficie() {
        return superficie;
    }

    public void setSuperficie(SuperficieEnum superficie) {
        this.superficie = superficie;
    }
}
