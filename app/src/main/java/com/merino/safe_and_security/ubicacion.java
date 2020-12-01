package com.merino.safe_and_security;

public class ubicacion {
    private double latitud;
    private double longitud;
    private String txtnombre;

    public ubicacion(double latitud, double longitud, String txtnombre) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.txtnombre = txtnombre;
    }

    public ubicacion() {
    }

    public String getTxtnombre() {
        return txtnombre;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public void setTxtnombre(String txtnombre) {
        this.txtnombre = txtnombre;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }
}
