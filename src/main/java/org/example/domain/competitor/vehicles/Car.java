package org.example.domain.competitor.vehicles;

public class Car extends Autovehicle {

    private Engine engine;






    public Car() {

    }



    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                "} " + super.toString();
    }


}
