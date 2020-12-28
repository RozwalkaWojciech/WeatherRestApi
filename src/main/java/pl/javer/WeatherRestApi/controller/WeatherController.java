package pl.javer.WeatherRestApi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.javer.WeatherRestApi.model.WeatherDto;
import pl.javer.WeatherRestApi.service.WeatherService;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping(name = "/weather")
    public WeatherDto getWeather() {
        return weatherService.getWeather();
    }
}
