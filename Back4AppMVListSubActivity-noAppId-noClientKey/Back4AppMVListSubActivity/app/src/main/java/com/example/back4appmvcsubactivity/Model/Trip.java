package com.example.back4appmvcsubactivity.Model;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Trip")
public class Trip extends ParseObject{

    public Trip() {
    }

    public double getLatitud() {
        return  getDouble("latitud");
    }

    public void setLatitud(double latitud) {
        put("latitud",latitud);
    }

    public double getLongitud() {
       return getDouble("longitud");
    }

    public void setLongitud(double longitud) {
        put("longitud",longitud);
    }

    public String getNombre() {return getString("nombre");
    }

    public void setNombre(String nombre) {
        put("nombre",nombre);
    }

    public double getKmTotales() {
        return getDouble("kmTotales");
    }

    public void setKmTotales(double kmTotales) {
        put("kmTotales", kmTotales);
    }

    public int getDuracionEnMinutos() {
        return getInt("duracionEnMinutos");
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        put("duracionEnMinutos", duracionEnMinutos);
    }

    public String getClima() {
        return getString("clima");
    }

    public void setClima(String clima) {
        put("clima", clima);
    }

    @Override
    public String toString() {
        return this.getNombre()+" "+this.getLatitud()+" "+this.getLongitud();
    }
}
