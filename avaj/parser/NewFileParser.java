package avaj.parser;

import avaj.weather.*;
import avaj.aircraft.*;
import avaj.additional.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class NewFileParser {
    private static NewFileParser _instance;
    private String fileName;
    public Scanner input;
    private AircraftFactory _factory;

    private NewFileParser() {
        _factory = new AircraftFactory();
    }

    public void SetFileName(String fileName) throws FileNotFoundException {
        if (this.fileName != null) return;
        input = new Scanner(new File(fileName));
        this.fileName = fileName;
    }

    public static NewFileParser getParser() {
        if (_instance == null) {
            _instance = new NewFileParser();
        }
        return _instance;
    }

    public int getWeatherChanges() {
        String nextToken = input.next();
        int result = Integer.parseInt(nextToken);
        return result;
    }

    public Flyable getFlyable() throws Exception {
        Flyable result = null;
        try {
            String type = input.next();
            String name = input.next();
            int longitude = Integer.parseInt(input.next());
            int latitude = Integer.parseInt(input.next());
            int height = Integer.parseInt(input.next());
            if (latitude < 0 || longitude < 0 || height < 0) {
                throw new ToLowValueException();
            }
            result = _factory.newAircraft(type, name, longitude, latitude, height);
        } catch (ToLowValueException ex) {
            System.out.println("Invalid variable in coordinates.");
            throw new Exception();
        } catch (Exception ex) {
            if (ex instanceof NoSuchElementException) {
                System.out.println("Invalid number of items in a line.");
            } else {
                System.out.println("Invalid integer argument in coordinates.");
            }
            throw new Exception();
        }
        return result;
    }

    private void getasd() {
        while(input.hasNext()) {
            String nextToken = input.next();
            String nextLine = input.nextLine();
        }

        input.close();
    }
}
