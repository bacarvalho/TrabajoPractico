package com.grupo4.trabajo.Servicios;

import Exceptions.EsDeudorException;
import Exceptions.NoCantLimpiezasDisponibleException;
import Exceptions.NoCantOrdenamientoDisponibleException;
import com.grupo4.trabajo.Cliente;
import com.grupo4.trabajo.Empresa;
import com.grupo4.trabajo.Pedido;
import com.grupo4.trabajo.Robots.Robot;

import java.util.Collection;
import java.util.Iterator;

public abstract class Servicio {
    private int cantLimpiezas;
    private int cantOrdenamientos;
    private float limiteDeuda;
    private float couta;

    public abstract void validarPedido(Pedido pedido,Cliente cliente) throws EsDeudorException, NoCantOrdenamientoDisponibleException, NoCantLimpiezasDisponibleException;


    /*cambie la variable deuda por cliente ya que si solo ponemos la deuda, no es posible luego sumarle el costo final
    * cosa que con esta vatiable si puedo, se ve en la funcion actualizar servicio*/
    public void realizarPedido(Pedido pedido, Cliente cliente) throws EsDeudorException, NoCantOrdenamientoDisponibleException, NoCantLimpiezasDisponibleException{
        //proximamente se le agregara el try catch para atrapar excepciones


        //valida que se pueda realizar el pedido. que el cliente no sea moroso y el servicio pueda satisfacer el pedido
        validarPedido(pedido,cliente) ;

        //busca los robots necesarios para realizar el pedido
        Collection<Robot> robotsPedido = buscarRobots(pedido,Empresa.getRobots());

        //calcula el costo total del pedido
        float costo = getCostoRobots(robotsPedido);

        //agrega los pedidos pendientes a los robots
        agregarPedidoRobots(robotsPedido,pedido);

        //actualiza el servicio, sumandole el costo al cliente y restandole al servicio el ordenamiento y la limpieza que necesite
        actualizarServicio(pedido, cliente, costo);
    }

    public void agregarPedidoRobots(Collection<Robot> robots,Pedido pedido){
        Iterator<Robot> it = robots.iterator();
        while(it.hasNext()){
            it.next().agregarPedido(pedido);
        }
    }

    public float getCostoRobots(Collection<Robot> robots){
        float costo = 0f;
        Iterator<Robot> it = robots.iterator();
        while(it.hasNext()){
            costo += it.next().getCosto();
        }
        return costo;
    }

    public Collection<Robot> buscarRobots(Pedido pedido, Collection<Robot> robots){
        //condicion de busqueda: los robots mas economicos
        return null;
    }

    public void actualizarServicio(Pedido pedido, Cliente cliente, float costo) {
        if (pedido.isRequiereLimpieza()) {
            setCantLimpiezas(getCantLimpiezas() - 1);
        }
        if (pedido.isOrdenamiento()) {
            setCantOrdenamientos(getCantOrdenamientos() - 1);
        }
        cliente.setDeuda(cliente.getDeuda() + costo);
    }


    public int getCantLimpiezas() {
        return cantLimpiezas;
    }

    public void setCantLimpiezas(int cantLimpiezas) {
        this.cantLimpiezas = cantLimpiezas;
    }

    public int getCantOrdenamientos() {
        return cantOrdenamientos;
    }

    public void setCantOrdenamientos(int cantOrdenamientos) {
        this.cantOrdenamientos = cantOrdenamientos;
    }

    public float getLimiteDeuda() {
        return limiteDeuda;
    }

    public void setLimiteDeuda(float limiteDeuda) {
        this.limiteDeuda = limiteDeuda;
    }

    public float getCouta() {
        return couta;
    }

    public void setCouta(float couta) {
        this.couta = couta;
    }

    public void EsDeudor(Pedido pedido, Cliente cliente) throws EsDeudorException{
    }

    public void LimpiezasDisponibles(Pedido pedido, Cliente cliente) throws NoCantLimpiezasDisponibleException{
    }

    public void OrdenamientosDisponibles(Pedido pedido, Cliente cliente) throws NoCantOrdenamientoDisponibleException{

    }
}
