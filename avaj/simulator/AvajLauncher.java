package avaj.simulator;

import avaj.additional.*;
import avaj.aircraft.*;
import avaj.weather.*;
import avaj.parser.*;
import javax.sound.midi.SysexMessage;

public class AvajLauncher {
    public static void main(String[] args) {
        try {
            NewFileParser parser = NewFileParser.getParser();
            boolean a = false;
            if (args.length == 1) {
                parser.SetFileName(args[0]);
                WeatherTower tower = new WeatherTower();
                int flyWeatherChangeCount = parser.getWeatherChanges();
                if (flyWeatherChangeCount < 0) {
                    throw new Exception("Weather changes count can't be below zero.");
                }
                Flyable parseFlyObj;
                while (parser.input.hasNext()) {
                    parseFlyObj = parser.getFlyable();
                    parseFlyObj.registerTower(tower);
                }
                tower.LetsBeTheFun(flyWeatherChangeCount);
            } else {
                System.out.println("Error: Program expected 1 argument with file name");
            }
        } catch (Exception ex) {
            System.out.println("Program stoped with an error: " + ex.getMessage());
        }
    }
}