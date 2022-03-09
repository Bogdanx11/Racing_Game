package org.example.domain.competitor;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Hulk implements Mobile {

    private double totalTraveledDistance;
    private boolean cooperative;
    private String name;


    public Hulk() {
        int mood = ThreadLocalRandom.current().nextInt(0,100);

        if(mood <=29){
            cooperative = true;
        }
    }

    @Override
    public double accelerate(double speed, double timeInHours) {
        System.out.println("Hulk is accelerating with " + speed + " for "+timeInHours+"hours.");
        double distance = speed * timeInHours;
        totalTraveledDistance += distance;
        return distance;
    }

    @Override
    public double getTotalTraveledDistance() {
        return totalTraveledDistance;
    }

    @Override
    public boolean canMove() {
        return cooperative;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hulk hulk = (Hulk) o;
        return Double.compare(hulk.totalTraveledDistance, totalTraveledDistance) == 0 && cooperative == hulk.cooperative && Objects.equals(name, hulk.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalTraveledDistance, cooperative, name);
    }
}


