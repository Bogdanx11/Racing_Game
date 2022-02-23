package org.example;



/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

    Game game = new Game();
        game.start();
/**
        //autovehicul
        Engine engine3 = new Engine();
        engine3.manufacturer = "vw";
        engine3.capacity = 2000;
        Autovehicle autovehicul1 = new Autovehicle(engine3);


        //engine1
        Engine engine1 = new Engine();
        engine1.manufacturer = "Valeo";
        engine1.capacity = 3000;

        System.out.println("Car1 engine manufacturer " + engine1.manufacturer);
        System.out.println("Car1 engine capacity " + engine1.capacity);


        //engine2
        Engine engine2 = new Engine();
        engine2.manufacturer = "Bosch";
        engine2.capacity = 4000;



        //car1
        System.out.println("Hello World!");
        Car car1 = new Car(engine1);
        car1.name = "Ferrari";
        car1.mileage = 13;
        car1.fuellevel = 60;
        car1.damaged = false;
        car1.DoorsNumber = 4;
        car1.maxSpeed = 200;
        System.out.println("Properties of car " + car1.name);
        System.out.println("Mileage: " + car1.mileage);
        System.out.println("Fuel level : " + car1.fuellevel);
        System.out.println("Damaged: " + car1.damaged);
        System.out.println("Doors: " + car1.DoorsNumber);

        //car2
        Car car2 = new Car(engine2);
        car2.name = "Dacia";
        car2.mileage = 10;
        car2.fuellevel = 100;
        car2.damaged = false;
        car2.DoorsNumber = 4;
        car2.maxSpeed = 200;
        System.out.println("Properties of car " + car2.name);
        System.out.println("Mileage: " + car2.mileage);
        System.out.println("Fuel level : " + car2.fuellevel);
        System.out.println("Damaged: " + car2.damaged);
        System.out.println("Doors: " + car2.DoorsNumber);





        System.out.println("******************************");
        //invoking the accelerate method
        double distanceCar1 = car1.accelerate(60, 1);

        double distanceCar2 = car2.accelerate(130, 1);

        //create mechanic
        System.out.println("Engine name before repaired " + car1.engine.manufacturer);
        Mechanic mechanic1 = new Mechanic();
        System.out.println("Engine name after repaired " + car1.engine.manufacturer);
        mechanic1.repair(car1);
*/
    }
}
