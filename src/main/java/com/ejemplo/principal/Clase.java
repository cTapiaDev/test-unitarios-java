package com.ejemplo.principal;

import com.ejemplo.servicio.Servicio;

public class Clase {
    
    private final Servicio servicio;

    public Clase(Servicio servicio) {
        this.servicio = servicio;
    }

    public String metodo() {
        return servicio.getDato();
    }
}
