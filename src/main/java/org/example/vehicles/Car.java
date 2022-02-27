package org.example.vehicles;

import org.example.Engine;

public class Car extends Autovehicle {

    private Engine engine;
    private  int DoorsNumber;

    public int getDoorsNumber() {
        return DoorsNumber;
    }

    public void setDoorsNumber(int doorsNumber) {
        DoorsNumber = doorsNumber;
    }

    public Car() {

    }

    public Car(Engine engine) {
        super(engine);
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", DoorsNumber=" + DoorsNumber +
                "} " + super.toString();
    }
}
