
package com.mauricio.weatherapp.service;

import com.mauricio.weatherapp.model.ClimaData;
import com.mauricio.weatherapp.model.OpenWeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClimaService {
    //con la Anotacion Value busca la apikey en aplicattion.properities
    @Value("${openweather.api.key}")
    private String apiKey;
    //aqui busca la api de la url
    @Value("${openweather.api.url}")
    private String apiUrl;
    //Declara variable para hacer peticiones HTTP
    private final RestTemplate restTemplate;
    //Constructor que crea una instancia de RestTemplate
    public ClimaService(){
        this.restTemplate = new RestTemplate();
    }
    //
    public ClimaData obtenerClimaReal(String ciudad){
        //Construit la URL
        String urlCompleta = apiUrl + "?q=" + ciudad + "&appid=" + apiKey + "&units=metric&lang=es";
        //recibe un JSON de terceros y lo usa para convertirlo en clase con getForObject
        OpenWeatherResponse respuestaApi = restTemplate.getForObject(urlCompleta, OpenWeatherResponse.class);
        
        return convertirFormato(respuestaApi);
    }
    
    private ClimaData convertirFormato(OpenWeatherResponse respuestaApi){
        
        ClimaData clima = new ClimaData();
        double tempCelsius = respuestaApi.getMain().getTemp();
        clima.setTemperatura(Math.round(tempCelsius) + "°C");
        clima.setCiudad(respuestaApi.getName());
        if(respuestaApi.getWeather().length>0){
            String descripcion = respuestaApi.getWeather()[0].getDescription();
            clima.setDescripcion(emojiDescripcion(descripcion));
        }
        clima.setHumedad(respuestaApi.getMain().getHumidity() + "%");
        double vientoKmh = respuestaApi.getWind().getSpeed() * 3.6;
        clima.setViento(Math.round(vientoKmh) + "km/h");
        return clima;
    }
    
    private String emojiDescripcion(String descripcion){
        //Dependiendo de la descripcion usaremos el siguiente emoji
        if(descripcion.contains("sol")){
            return "☀️ " + descripcion;
        }
        if(descripcion.contains("lluvia")){
            return "🌧️ " + descripcion;
        }
        if(descripcion.contains("nieve")){
            return "❄️ " + descripcion;
        }
        return descripcion;
    }
}

    
