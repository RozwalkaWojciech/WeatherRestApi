package pl.javer.WeatherRestApi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.javer.WeatherRestApi.model.WeatherDto;
import pl.javer.WeatherRestApi.webclient.weather.WeatherClient;

@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherClient weatherClient;

    public WeatherDto getWeather() {
        String response = weatherClient.getWeatherForCity("lublin");
        log.info(response);
        response = weatherClient.getForecast(52.23, 21.01);
        log.info(response);
        return null;
    }
}
