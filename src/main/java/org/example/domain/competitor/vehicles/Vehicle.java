package org.example.domain.competitor.vehicles;

import org.example.domain.competitor.Mobile;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Vehicle implements Mobile {


    //static variable
    private static int totalVehicleCount;

    public boolean canMove(){
        return fuellevel > 0 && !damaged;
    }


    //instance variables
    private String name;
    private double mileage;
    private double fuellevel;
    private boolean damaged;
    protected double totalTraveledDistance;
    private double maxSpeed;
    private LocalDate manufacturingDate;


    //getter for read-only variable totalVehicleCount
    public static int getTotalVehicleCount() {
        return totalVehicleCount;
    }


    //getter and setter for variables
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public double getFuellevel() {
        return fuellevel;
    }

    public void setFuellevel(double fuellevel) {
        this.fuellevel = fuellevel;
    }

    public boolean isDamaged(boolean b) {
        return damaged;
    }

    public void setDamaged(boolean damaged) {
        this.damaged = damaged;
    }

    public double getTotalTraveledDistance() {
        return totalTraveledDistance;
    }

    public void setTotalTraveledDistance(double totalTraveledDistance) {
        this.totalTraveledDistance = totalTraveledDistance;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }


    //constructors


    public Vehicle() {
        totalVehicleCount++;
    }


    public double accelerate(double speed){
        return accelerate(speed,1);
    }

    // accelerate method
    public double accelerate(double speed, double timeInHours) {

        double mileageMultiplier = 1;
        //mileage condition
        if (speed > 120) {
            mileageMultiplier = speed / 100;
        }

        if(!canMove()){
            System.out.println("You cannot accelerate!!");
        }


        //speed condition
        if (speed > maxSpeed) {
            System.out.println("Max speed exceeded.");
            return 0;
        }

        //return
        System.out.println("Vehicle " + name + " is accelerating with " + speed + " for " + timeInHours + " h.");

        double distance = speed * timeInHours;

        totalTraveledDistance += distance;
        System.out.println("Total traveled distance is " + totalTraveledDistance);

        System.out.println("Is damaged the car ? " + damaged);


        double usedFuel = distance * mileage * mileageMultiplier / 100;

        fuellevel -= usedFuel;
        System.out.println("Remaining fuel level is " + fuellevel);
        return distance;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", mileage=" + mileage +
                ", fuellevel=" + fuellevel +
                ", damaged=" + damaged +
                ", totalTraveledDistance=" + totalTraveledDistance +
                ", maxSpeed=" + maxSpeed +
                ", manufacturingDate=" + manufacturingDate +
                '}';
    }

    //reset
    protected Vehicle reset(){
        totalTraveledDistance = 0;
        damaged = false;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Double.compare(vehicle.mileage, mileage) == 0 && Double.compare(vehicle.fuellevel, fuellevel) == 0 && damaged == vehicle.damaged && Double.compare(vehicle.totalTraveledDistance, totalTraveledDistance) == 0 && Double.compare(vehicle.maxSpeed, maxSpeed) == 0 && Objects.equals(name, vehicle.name) && Objects.equals(manufacturingDate, vehicle.manufacturingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mileage, fuellevel, damaged, totalTraveledDistance, maxSpeed, manufacturingDate);
    }
}
