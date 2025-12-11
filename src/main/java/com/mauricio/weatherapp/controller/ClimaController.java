
package com.mauricio.weatherapp.controller;

import com.mauricio.weatherapp.model.ClimaData;
import org.springframework.web.bind.annotation.*;
import com.mauricio.weatherapp.service.ClimaService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController //Esta clase manejará peticiones web y devolverá JSON
@RequestMapping("/api/weather")  //Todas las URLs empezarán con /api/weather
@CrossOrigin(origins="*")  //Permite que tu HTML (en otro puerto) se comunique con este backend
public class ClimaController {
    
    @Autowired
    private ClimaService climaService;
    
    @GetMapping("/city/{nombreCiudad}") //Crea un endpoint: GET /api/weather/city/Madrid 
    public ClimaData getClima(@PathVariable String nombreCiudad){ 
        return climaService.obtenerClimaReal(nombreCiudad);
    }
    
    @GetMapping("/test")
    public String test(){
        return "Tu api esta funcionando";
    }
}
