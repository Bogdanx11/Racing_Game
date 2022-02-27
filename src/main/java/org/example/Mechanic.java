package org.example;

import org.example.vehicles.Autovehicle;

public class Mechanic {
    public void repair(Autovehicle autovehicle){
        autovehicle.setEngine(new Engine());

    }
}
