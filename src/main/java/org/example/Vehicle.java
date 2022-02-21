package org.example;

public class Vehicle {
    String name;
    double mileage;
    double fuellevel;
    boolean damaged;
    double totalTraveledDistance;
    double maxSpeed;

    // accelerate method
    public double accelerate(double speed, double timeInHours){

        double mileageMultiplier = 1;
        //mileage condition
        if(speed>120){
            mileageMultiplier = speed/100;
        }


        //damage condition
        if(damaged){
            System.out.println("You cannot accelerate, the car is broken!");
            return 0;
        }


        //fuel level condition
        if (fuellevel<=0){
            System.out.println("You cannot accelerate.You ran out of gas.");
            return 0;
        }



        //speed condition
        if (speed > maxSpeed ) {
            System.out.println("Max speed exceeded.");
            return 0;
        }

        //return
        System.out.println("Vehicle " + name + " is accelerating with " + speed + " for " + timeInHours + " h." );

        double distance = speed * timeInHours;

        totalTraveledDistance += distance;
        System.out.println("Total traveled distance is " + totalTraveledDistance);

        System.out.println("Is damaged the car ?" + damaged);


        double usedFuel = distance * mileage * mileageMultiplier / 100;

        fuellevel -= usedFuel;
        System.out.println("Remaining fuel level is " + fuellevel);
        return distance;
    }
}
