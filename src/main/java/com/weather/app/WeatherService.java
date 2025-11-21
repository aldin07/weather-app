package com.weather.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service // Tell spring to manage this class as a Service bean
public class WeatherService {
    
    //RestTemplate is a single HTTP client we use to call external APIs
    private final RestTemplate restTemplate = new RestTemplate();

    //Inject the base URL from application.properties
    @Value("${weather.api.url}")
    private String apiUrl;
    
    @Value("${weather.api.key}")
    private String apiKey;
     
    public Map<String, Object> getWeather(String city){
        
        //Build the full URL using values injected above
        String url = apiUrl + "?q=" + city + "&appid=" + apiKey + "&units=metric";
        System.out.println("Request URL: " + url);
        return restTemplate.getForObject(url, Map.class);
    }

}
