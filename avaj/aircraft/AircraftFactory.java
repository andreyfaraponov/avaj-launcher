package avaj.aircraft;

import avaj.weather.*;
import avaj.additional.*;

public class AircraftFactory {
    public Flyable newAircraft(
        String type,
        String name,
        int longitude,
        int latitude,
        int height
    ) throws CustomException {
        switch (type) {
            case "Baloon":
                return new Baloon(name, new Coordinates(longitude, latitude, height));
            case "JetPlane":
                return new JetPlane(name, new Coordinates(longitude, latitude, height));
            case "Helicopter":
                return new Helicopter(name, new Coordinates(longitude, latitude, height));
            default:
                throw new CustomException("Unsupported type of Flyable object");
        }
    }
}