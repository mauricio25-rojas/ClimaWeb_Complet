
package com.mauricio.weatherapp.model;

public class ClimaData {
    private String ciudad;
    private String temperatura;
    private String descripcion;
    private String humedad;
    private String viento;
    
    public ClimaData(){
    }
    
    public ClimaData(String ciudad,String temperatura,String descripcion,String humedad){
        this.ciudad = ciudad;
        this.temperatura = temperatura;
        this.descripcion = descripcion;
        this.humedad = humedad;
    }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public String getTemperatura() { return temperatura; }
    public void setTemperatura(String temperatura) { this.temperatura = temperatura; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
    public String getHumedad() { return humedad; }
    public void setHumedad(String humedad) { this.humedad = humedad; }
    
    public String getViento() { return viento; }
    public void setViento(String viento) { this.viento = viento; }
}
