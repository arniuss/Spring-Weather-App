package cz.vsb.connector;

import cz.vsb.City;
import cz.vsb.dto.WeatherApiDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

public class WeatherApiConnector {
    //https://api.weatherapi.com/v1/current.json?key=2f3d5a0c8d0a4dd7986132149232003&q=London

    private static String baseUrl = "https://api.weatherapi.com/";
    private static String urlParameters = "v1/current.json?key=";
    private static String apiKey = "2f3d5a0c8d0a4dd7986132149232003";
    private static String url = baseUrl + urlParameters + apiKey + "&q=";

    public WeatherApiDto getWeatherForCity(City city) {
        RestTemplate template = new RestTemplate();
        URI uri = null;
        try {
            uri = new URI(url + city);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ResponseEntity<WeatherApiDto> response = template.getForEntity(uri, WeatherApiDto.class);
        return response.getBody();
    }
}
