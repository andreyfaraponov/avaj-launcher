package avaj.weather;

import avaj.aircraft.*;
import avaj.weather.*;
import java.util.*;

public class WeatherProvider {
    private static WeatherProvider weatherProvider  = null;
    private final String[] weather;

    private WeatherProvider() {
        weather = new String[]{"SUN", "RAIN", "FOG", "SNOW"};
    }

    public static WeatherProvider getProvider() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return weather[(new Random()).nextInt(4)];
    }
}