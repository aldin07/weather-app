package com.weather.app;

import org.springframework.beans.factory.annotation.Autowired; // For dependency injection
import org.springframework.stereotype.Controller; // Marks this class as an MVC controller
import org.springframework.ui.Model; // Used to pass data to Thymeleaf templates
import org.springframework.web.bind.annotation.GetMapping; // Maps GET requests
import org.springframework.web.bind.annotation.PostMapping; // Maps POST requests
import org.springframework.web.bind.annotation.RequestParam; // Binds form input to method parameters

import java.util.Map; //Represents weather JSON response as a MAP

@Controller // Marks this class as a Spring MVC controller that returns HTML views
public class WeatherController {

    @Autowired //Automatically inject WeatherService bean
    private WeatherService weatherService;

    // Get request to "/" shows the input form
    @GetMapping("/")
    public String form(){
        return "weather-form"; // Returns Thymeleaf template weather-form.html
    }

    // POST request to "/forecast" handles from submission
    @PostMapping("/forecast")
    public String getForecast(@RequestParam String city, Model model){
        // Call service to fetch weather data
        Map<String, Object> weather = weatherService.getWeather(city);
        
        // Pass weather data to the Thymeleaf template
        model.addAttribute("weather", weather);

        return "weather-result"; // Returns Thymeleaf template weather-result.html
    }

}
