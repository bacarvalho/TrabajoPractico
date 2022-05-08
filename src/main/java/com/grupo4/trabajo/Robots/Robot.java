package com.grupo4.trabajo.Robots;

import com.grupo4.trabajo.Pedido;
import com.grupo4.trabajo.SinPedidosPendientesException;

import java.util.ArrayList;
import java.util.List;

public abstract class Robot {
    private List<Pedido> pedidosPendientes;
    private String idRobot;
    private Superficie superficie;
    private boolean puedeOrdenar;
    private boolean puedeLustrar;
    private float costo;

    public void agregarPedido(Pedido pedido){
        if (pedidosPendientes == null){
            this.pedidosPendientes = new ArrayList<Pedido>();
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

    public List<Pedido> getPedidosPendientes() {
        return pedidosPendientes;
    }

/*     public void setPedidosPendientes(List<Pedido> pedidosPendientes) {
        this.pedidosPendientes = pedidosPendientes;
    }
 */
    public String getIdRobot() {
        return idRobot;
    }

    public void setIdRobot(String idRobot) {
        this.idRobot = idRobot;
    }

    public Superficie getSuperficie() {
        return superficie;
    }

    public void setSuperficie(Superficie superficie) {
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
