package com.grupo4.trabajo;

import com.grupo4.trabajo.Exceptions.EsDeudorException;
import com.grupo4.trabajo.Exceptions.NoCantLimpiezasDisponibleException;
import com.grupo4.trabajo.Exceptions.NoCantOrdenamientoDisponibleException;
import com.grupo4.trabajo.Pedido.Pedido;
import com.grupo4.trabajo.Servicios.ServicioCliente.Servicio;


import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String direccion;
    private float deuda;
    private Servicio tipoServicio;
    private List<Float> costosDeServicios; //sumar los costos de las reparaciones


    public Cliente(Servicio tipoServicio){
        this.tipoServicio = tipoServicio;
        this.costosDeServicios=new ArrayList<>();
    }

    public void pedirPedido(Pedido pedido) throws EsDeudorException, NoCantOrdenamientoDisponibleException, NoCantLimpiezasDisponibleException {
        tipoServicio.realizarPedido(pedido,this);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public float getDeuda() {
        return deuda;
    }

    public void setDeuda(float deuda) {
        this.deuda = deuda;
    }

    public Servicio getTipoServicio() {
        return tipoServicio;
    }

    public List<Float> getCostosDeServicios() {
        return costosDeServicios;
    }

    public void agregarCostoPedido(Float costo){
        this.costosDeServicios.add(costo);
    }

    public void setTipoServicio(Servicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

}
