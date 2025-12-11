
package com.mauricio.weatherapp.model;
import com.fasterxml.jackson.annotation.JsonProperty;
// Importa la anotación para mapear nombres diferentes entre JSON y Java

public class OpenWeatherResponse {
    private String name;//Guarda el nombre de la ciudad (viene como "name" en el JSON)
    
    @JsonProperty("main")//Le dice a Jackson: "en el JSON esta propiedad se llama 'main'"
    private MainData main;
    
    @JsonProperty("weather")//Array para condiciones climáticas (puede tener múltiples elementos)
    private Weather[] weather;
    
    @JsonProperty("wind")
    private Wind wind;
    
    //Clases anidadas
    public static class MainData{
        private double temp;
        private int humidity;
        
        public double getTemp() { return temp; }
        public void setTemp(double temp) { this.temp = temp; }
        
        public int getHumidity() { return humidity; }
        public void setHumidity(int humidity) { this.humidity = humidity; }
    }
    
    public static class Weather{
        private String description;
        private String icon;
        
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
        
        public String getIcon() { return icon; }
        public void setIcon(String icon) { this.icon = icon; }
    }
    
    public static class Wind{
        private double speed;
        
        public double getSpeed() { return speed; }
        public void setSpeed( double speed) { this.speed = speed; }
    }
    
    //Metodos paraa tributos con compisicion
    public String getName() { return name; }
    public void setName( String name) { this.name = name; }
    
    public MainData getMain() { return main; }
    public void setMain( MainData main) { this.main = main; }
    
    public Weather[] getWeather() { return weather; }
    public void setWeather(Weather[] weather) { this.weather = weather; }
    
    public Wind getWind() { return wind; }
    public void setWind(Wind wind) { this.wind = wind; } 
}
