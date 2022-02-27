package org.example.vehicles.cheater;

import org.example.vehicles.Vehicle;

public class CheatingVehicles extends Vehicle {

    @Override
    public double accelerate(double speed, double timeInHours) {
        System.out.println(getName()+" is accelerating with "+ speed+" km/h for "+ timeInHours+ " h.");

        System.out.println("Cheater!!!");

        double distance = speed * timeInHours * 2;

        totalTraveledDistance += distance;
        System.out.println("Total traveled distance for " + getName()+" is " + totalTraveledDistance);

        return distance;
    }

    //cheat method
    public void cheat(){
        totalTraveledDistance = totalTraveledDistance*2;
    }

    //reset method


    @Override
    public CheatingVehicles reset() {
         super.reset();
         return this;
    }
}
