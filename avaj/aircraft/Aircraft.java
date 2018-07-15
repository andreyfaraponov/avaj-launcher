package avaj.aircraft;

import avaj.weather.*;
import avaj.additional.*;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 1;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        id = nextId();
    }

    private static long nextId() {
        long result = idCounter;
        idCounter++;
        return result;
    }
}