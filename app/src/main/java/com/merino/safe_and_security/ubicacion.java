package com.merino.safe_and_security;

public class ubicacion {
    private double latitud;
    private double longitud;


    public ubicacion(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;

    }

    public ubicacion() {
    }



    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }
}
