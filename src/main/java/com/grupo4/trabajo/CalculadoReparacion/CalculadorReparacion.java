package com.grupo4.trabajo.CalculadoReparacion;

import com.grupo4.trabajo.TipoReparacion;

public abstract class CalculadorReparacion {
    private final static float PRECIO_ELECTRICIDAD_COMPLEJIDAD_BAJA=2000;
    private final static float PRECIO_ELECTRICIDAD_COMPLEJIDAD_MEDIA=4573;
    private final static float PRECIO_ELECTRICIDAD_COMPLEJIDAD_ALTA=7359;
    private final static float PRECIO_GAS_COMPLEJIDAD_BAJA=1000;
    private final static float PRECIO_GAS_COMPLEJIDAD_MEDIA=3350;
    private final static float PRECIO_GAS_COMPLEJIDAD_ALTA=6389;

    public static float calcularCostoReparacion(TipoReparacion tipoReparacion, int complejidad, float sueldoEmpleado){
        float precio=0;

        if(tipoReparacion==TipoReparacion.GAS){
            precio=reparacionGas(complejidad);
        }
        if(tipoReparacion==TipoReparacion.ELECTRICIDAD){
            precio = reparacionElectricidad(complejidad);
        }

        return precio+(sueldoEmpleado/160)*complejidad;
    }

    private static float reparacionGas(int complejidad){
        if(complejidad<3){
            return PRECIO_GAS_COMPLEJIDAD_BAJA;
        }
        if(complejidad>=3 && complejidad<=6){
            return PRECIO_GAS_COMPLEJIDAD_MEDIA;
        }
        if(complejidad>6 && complejidad<9){
            return PRECIO_GAS_COMPLEJIDAD_ALTA;
        }
        return 0;
    }

    private static float reparacionElectricidad(int complejidad){
        if(complejidad<3){
            return PRECIO_ELECTRICIDAD_COMPLEJIDAD_BAJA;
        }
        if(complejidad>=3 && complejidad<=6){
            return PRECIO_ELECTRICIDAD_COMPLEJIDAD_MEDIA;
        }
        if(complejidad>6 && complejidad<9){
            return PRECIO_ELECTRICIDAD_COMPLEJIDAD_ALTA;
        }
        return 0;
    }
}
