package org.example;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        //car1
        System.out.println("Hello World!");
        Car car1 = new Car();
        car1.name = "Ferrari";
        car1.mileage = 50;
        car1.fuellevel = 60;
        car1.damaged = true;
        car1.DoorsNumber = 4;
        System.out.println("Properties of car " + car1.name);
        System.out.println("Mileage: " + car1.mileage);
        System.out.println("Fuel level : " + car1.fuellevel);
        System.out.println("Damaged: " + car1.damaged);
        System.out.println("Doors: " + car1.DoorsNumber);

        //car2
        Car car2 = new Car();
        car2.name = "Dacia";
        car2.mileage = 50;
        car2.fuellevel = 60;
        car2.damaged = true;
        car2.DoorsNumber = 4;
        System.out.println("Properties of car " + car2.name);
        System.out.println("Mileage: " + car2.mileage);
        System.out.println("Fuel level : " + car2.fuellevel);
        System.out.println("Damaged: " + car2.damaged);
        System.out.println("Doors: " + car2.DoorsNumber);

        //engine1
        Engine engine1 = new Engine();
        engine1.manufacturer = "Valeo";
        engine1.capacity = 3000;
        car1.engine = engine1;

        System.out.println("Car1 engine manufacturer " + engine1.manufacturer);
        System.out.println("Car1 engine capacity " + engine1.capacity);

        //engine2
        car2.engine = new Engine();
        car2.engine.manufacturer = "Bosch";
        car2.engine.capacity = 4000;

        System.out.println("Car2 engine manufacturer " + car2.engine.manufacturer);
        System.out.println("Car2 engine capacity " + car2.engine.capacity);

        //invoking the accelerate method
        double distanceCar1 = car1.accelerate(60, 1);

        double distanceCar2 = car2.accelerate(100, 1);

        //create mechanic
        System.out.println("Engine name before repaired " + car1.engine.manufacturer);
        Mechanic mechanic1 = new Mechanic();
        System.out.println("Engine name after repaired " + car1.engine.manufacturer);
        mechanic1.repair(car1);

    }
}
