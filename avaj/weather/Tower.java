package avaj.weather;

import avaj.additional.FileWriter;
import avaj.aircraft.*;
import avaj.weather.*;
import java.util.*;

public class Tower {
    private ArrayList<Flyable> observers;
    private ArrayList<Flyable> forUnregister;

    public void register(Flyable flyable) {
        String info = getInfo(flyable);
        if (observers == null) {
            observers = new ArrayList<Flyable>();
        }
        if (observers.contains(flyable)) {
            return;
        }
        try {
            FileWriter.Log("Tower says: " + info + " registered to weather tower.");
        }
        catch (Exception err) {
            System.out.println("Can't write log file.");
        }
        observers.add(flyable);
    }

    public void unregister (Flyable flyable) {
        int index = observers.indexOf(flyable);
        String info = getInfo(flyable);
        if (index >= 0) {
            try {
                FileWriter.Log("Tower says: " + info + " unregistered from weather tower.");
            }
            catch (Exception err) {
                System.out.println("Can't write log file.");
            }
            if (forUnregister == null) {
                forUnregister = new ArrayList<Flyable>();
            }
            forUnregister.add(flyable);
        }
    }

    protected void conditionsCnahged() {
        for (Flyable fly : observers) {
            fly.updateConditions();
        }
        if (forUnregister != null && forUnregister.size() > 0) {
            for (Flyable fly : forUnregister) {
                observers.remove(observers.indexOf(fly));
            }
            forUnregister.clear();
        }
    }

    private String getInfo(Flyable fly) {
        Baloon baloon = (fly instanceof Baloon ? (Baloon)fly : null);
        if (baloon != null) {
            return baloon.getFullInfoName();
        }
        JetPlane jetPlane = (fly instanceof JetPlane ? (JetPlane)fly : null);
        if (jetPlane != null) {
            return jetPlane.getFullInfoName();
        }
        Helicopter heli = (fly instanceof Helicopter ? (Helicopter)fly : null);
        if (heli != null) {
            return heli.getFullInfoName();
        }
        return null;
    }
}