package com.grupo4.trabajo.Robots;

public abstract class Robot {
    private int pedidosPendientes;
    private String idRobot;
    private String superficie;
    private boolean puedeOrdenar;
    private boolean puedeLustrar;
    private float costo;

    public void agregarPedido(){

    }

    public void finalizarPedido(){

    }

    public int getPedidosPendientes() {
        return pedidosPendientes;
    }

    public void setPedidosPendientes(int pedidosPendientes) {
        this.pedidosPendientes = pedidosPendientes;
    }

    public String getIdRobot() {
        return idRobot;
    }

    public void setIdRobot(String idRobot) {
        this.idRobot = idRobot;
    }

    public String getSuperficie() {
        return superficie;
    }

    public void setSuperficie(String superficie) {
        this.superficie = superficie;
    }

    public boolean isPuedeOrdenar() {
        return puedeOrdenar;
    }

    public void setPuedeOrdenar(boolean puedeOrdenar) {
        this.puedeOrdenar = puedeOrdenar;
    }

    public boolean isPuedeLustrar() {
        return puedeLustrar;
    }

    public void setPuedeLustrar(boolean puedeLustrar) {
        this.puedeLustrar = puedeLustrar;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
}
