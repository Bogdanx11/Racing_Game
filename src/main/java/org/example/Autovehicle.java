package org.example;

public class Autovehicle extends Vehicle{

    private Engine engine;

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }



    public Autovehicle(Engine engine){
        this.engine = engine;
    }

}
