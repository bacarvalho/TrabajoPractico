package com.grupo4.trabajo.Robots;

import com.grupo4.trabajo.Exceptions.SinPedidosPendientesException;
import com.grupo4.trabajo.Pedido.PedidoLimpieza;
import com.grupo4.trabajo.Pedido.SuperficieEnum;

import java.util.ArrayList;
import java.util.List;

public abstract class Robot {
    private List<PedidoLimpieza> pedidosPendientes;
    private String idRobot;
    private SuperficieEnum superficie;
    private boolean puedeOrdenar;
    private boolean puedeLustrar;
    private float costo;

    public void agregarPedido(PedidoLimpieza pedido){
        if (pedidosPendientes == null){
            pedidosPendientes = new ArrayList<>();
        }
        pedidosPendientes.add(pedido);
    }

    public void finalizarPedido() throws SinPedidosPendientesException{
        /*si la lista de pedidos esta vacia, lanza una excepcion, de lo contrario elimina el primer
        * pedido de la lista*/
        if(pedidosPendientes.isEmpty()){
            throw new SinPedidosPendientesException("No hay pedidos pendientes.");
        }
        pedidosPendientes.remove(pedidosPendientes.get(0));
    }

    public List<PedidoLimpieza> getPedidosPendientes() {
        return pedidosPendientes;
    }

    public int getIntPedidosPendientes() {
        if (pedidosPendientes == null)
            return 0;

        return pedidosPendientes.size() ;
    }

    public void setPedidosPendientes(List<PedidoLimpieza> pedidosPendientes) {
        this.pedidosPendientes = pedidosPendientes;
    }

    public String getIdRobot() {
        return idRobot;
    }

    public void setIdRobot(String idRobot) {
        this.idRobot = idRobot;
    }

    public SuperficieEnum getSuperficie() {
        return superficie;
    }

    public void setSuperficie(SuperficieEnum superficie) {
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
