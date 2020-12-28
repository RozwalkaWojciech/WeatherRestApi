package pl.javer.WeatherRestApi.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.javer.WeatherRestApi.model.WeatherDto;

@Service
@Slf4j
public class WeatherService {

    private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/";
    private static final String API_KEY = "9475ef3eddb4ee346fa3072af4de6e99";
    private RestTemplate restTemplate = new RestTemplate();

    public WeatherDto getWeather() {
        String response = getWeatherForCity("lublin");
        log.info(response);
        return null;
    }

    private String getWeatherForCity(String city) {
        return restTemplate.getForObject(WEATHER_URL + "weather?q={city}&appid={apiKey}&units=metric&lang=pl",
                String.class, city, API_KEY);
    }
}
