package avaj.aircraft;

import avaj.weather.*;
import avaj.additional.*;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String cond = weatherTower.getWeather(this.coordinates);
        switch (cond) {
            case "SUN":
                coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude() + 10,
                    coordinates.getHeight() + 2
                );
                FileWriter.Log(getFullInfoName() + ": This is hot.");
                break;
            case "RAIN":
                coordinates = new Coordinates(
                    coordinates.getLongitude() + 5,
                    coordinates.getLatitude(),
                    coordinates.getHeight()
                );
                FileWriter.Log(getFullInfoName() + ": It's raining. Better watch out for lightings.");
                break;
            case "FOG":
                coordinates = new Coordinates(
                    coordinates.getLongitude() + 1,
                    coordinates.getLatitude(),
                    coordinates.getHeight()
                );
                FileWriter.Log(getFullInfoName() + ": Nothing is visible, stupid fog.");
                break;
            case "SNOW":
                coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    coordinates.getHeight() - 12
                );
                FileWriter.Log(getFullInfoName() + ": My rotor is going to freeze!");
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
        return "Helicopter#" + this.name + "(" + this.id + ")";
    }
}