package org.example;

public class Vehicle {
    String name;
    double mileage;
    double fuellevel;
    boolean damaged;
    double totalTraveledDistance;

    // accelerate method
    public double accelerate(double speed, double timeInHours){

        System.out.println("Vehicle" + name + "is accelerating with " + speed + "for " + timeInHours + "h" );

        double distance = speed * timeInHours;

        totalTraveledDistance += distance;
        System.out.println("Total traveled distance is " + totalTraveledDistance);
        damaged = true;
        System.out.println("Is damaged the car ?" + damaged);
        double usedFuel = distance * mileage / 100;

        fuellevel -= usedFuel;
        System.out.println("Remaining fuel level is " + fuellevel);
        return distance;
    }
}
