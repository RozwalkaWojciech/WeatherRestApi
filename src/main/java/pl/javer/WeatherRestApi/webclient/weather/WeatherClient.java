package pl.javer.WeatherRestApi.webclient.weather;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherClient {

    private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/";
    private static final String API_KEY = "9475ef3eddb4ee346fa3072af4de6e99";
    private RestTemplate restTemplate = new RestTemplate();

    public String getWeatherForCity(String city) {
        return callGetMethod("weather?q={city}&appid={apiKey}&units=metric&lang=pl",
                String.class,
                city, API_KEY);
    }

    public String getForecast(double lat, double lon) {
        return callGetMethod("onecall?lat={lat}&lon={lon}&exclude=minutely,hourly&appid={apiKey}",
                String.class,
                lat, lon, API_KEY);
    }

    private <T> T callGetMethod(String url, Class<T> responseType, Object... objects) {
        return restTemplate.getForObject(WEATHER_URL + url, responseType, objects);
    }
}
