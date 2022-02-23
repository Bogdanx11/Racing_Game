package org.example;
public class Car extends Autovehicle {


    private  int DoorsNumber;

    public int getDoorsNumber() {
        return DoorsNumber;
    }

    public void setDoorsNumber(int doorsNumber) {
        DoorsNumber = doorsNumber;
    }




    public Car(Engine engine) {
        super(engine);
    }
}
