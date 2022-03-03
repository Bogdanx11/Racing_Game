package org.example.vehicles;

import org.example.Engine;

public abstract class Autovehicle extends Vehicle {

    private Engine engine;



    public Autovehicle(){
        this(new Engine());
    }


    public Autovehicle(Engine engine){
        this.engine = engine;
    }


    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Autovehicle{" +
                "engine=" + engine +
                "} " + super.toString();
    }


}
