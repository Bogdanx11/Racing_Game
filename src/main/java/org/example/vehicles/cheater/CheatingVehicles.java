package org.example.vehicles.cheater;

import org.example.vehicles.Vehicle;

public class CheatingVehicles extends Vehicle {
    public void cheat(){
        totalTraveledDistance = totalTraveledDistance*2;
    }
}
