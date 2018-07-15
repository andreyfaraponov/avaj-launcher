package avaj.aircraft;

import avaj.weather.*;
import avaj.additional.*;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String cond = weatherTower.getWeather(this.coordinates);
        switch (cond) {
            case "SUN":
                coordinates = new Coordinates(
                    coordinates.getLongitude() + 2,
                    coordinates.getLatitude(),
                    coordinates.getHeight() + 4
                );
                FileWriter.Log(getFullInfoName() + ": Let's enjoy the good weather and take some pics.");
                break;
            case "RAIN":
                coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    coordinates.getHeight() - 5
                );
                FileWriter.Log(getFullInfoName() + ": Damn you rain! You messed up my baloon.");
                break;
            case "FOG":
                coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    coordinates.getHeight() - 3
                );
                FileWriter.Log(getFullInfoName() + " Nothing is visible, stupid fog.");
                break;
            case "SNOW":
                coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    coordinates.getHeight() - 15
                );
                FileWriter.Log(getFullInfoName() + ": It's snowing. We're gonna crash.");
                break;
        }
        if (coordinates.getHeight() == 0) {
            Landing();
        }
    }
    private void Landing() {
        FileWriter.Log(getFullInfoName() + " landing.");
        FileWriter.Log(getFullInfoName() + ": Coords: longitude = " + coordinates.getLongitude() +
        " latitude = " + coordinates.getLatitude() + " height = " + coordinates.getHeight());
        weatherTower.unregister(this);
    }

    public void registerTower(WeatherTower weatherTower) {
        if (weatherTower != null) {
            this.weatherTower = weatherTower;
            this.weatherTower.register(this);
        }
    }

    public String getFullInfoName() {
        return "Baloon#" + this.name + "(" + this.id + ")";
    }
}