package avaj.weather;

import avaj.aircraft.*;
import avaj.weather.*;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather() {
        this.conditionsCnahged();
    }

    public void LetsBeTheFun(int changesCount) {
        for (int i = 0; i < changesCount; i++) {
            changeWeather();
        }
    }
}