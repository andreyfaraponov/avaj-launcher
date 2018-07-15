package avaj.aircraft;

import avaj.weather.*;
import avaj.additional.*;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height) {
        if (height > 100)
            height = 100;
        else if (height < 0)
            height = 0;

        if (longitude < 0)
            longitude = 0;

        if (latitude < 0)
            latitude = 0;

        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public int getLongitude() {
        return longitude < 0 ? 0 : longitude;
    }

    public int getLatitude() {
        return latitude < 0 ? 0 : latitude;
    }

    public int getHeight() {
        if (height > 100)
            return 100;
        else if (height < 0)
            return 0;
        return height;
    }
}