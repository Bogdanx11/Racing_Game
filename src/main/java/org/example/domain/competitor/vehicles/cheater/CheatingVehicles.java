package org.example.domain.competitor.vehicles.cheater;

import org.example.domain.competitor.vehicles.Vehicle;

public class CheatingVehicles extends Vehicle {

    @Override
    public double accelerate(double speed, double timeInHours) {
        System.out.println(getName()+" is accelerating with "+ speed+" km/h for "+ timeInHours+ " h.");


        double distance = speed * timeInHours * 2;

        totalTraveledDistance += distance;
        System.out.println("Total traveled distance for " + getName()+" is " + totalTraveledDistance);

        System.out.println();
        System.out.println("Cheater!!!");

        System.out.println();
        return distance;
    }


    }


