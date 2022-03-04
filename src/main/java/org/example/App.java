package org.example;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {

/**
 Vehicle cheatingVehicles = new CheatingVehicles();
 cheatingVehicles.setName("Cheater");
 cheatingVehicles.accelerate(60,1);

 //type casting
 //verification of type casting
 if(cheatingVehicles instanceof CheatingVehicles) {

 ((CheatingVehicles) cheatingVehicles).cheat();
 }
 */

        Game game = new Game();
        game.start();
        


        /**
         String email =" bogdan@yahoo.com";
         String[] emailParts = email.split("@");

         System.out.println("First part :" + emailParts[0]);
         System.out.println("Second part :" + emailParts[1]);
         */
/**
 //autovehicul
 Engine engine3 = new Engine();
 engine3.manufacturer = "vw";
 engine3.capacity = 2000;
 Autovehicle autovehicul1 = new Autovehicle(engine3);

 */

/**
 System.out.println("Car1 engine manufacturer " + engine1.manufacturer);
 System.out.println("Car1 engine capacity " + engine1.capacity);


 //engine2
 Engine engine2 = new Engine();
 engine2.manufacturer = "Bosch";
 engine2.capacity = 4000;


 */
/**
 //engine1
 Engine engine1 = new Engine();
 engine1.setManufacturer("Valeo");
 engine1.setCapacity(3000);
 //car1

 Car car1 = new Car();
 car1.setName("Ferrari");
 car1.setMileage(13);
 car1.setFuellevel(50);
 car1.isDamaged(false);
 car1.setDoorsNumber(4);
 car1.setMaxSpeed(200);
 System.out.println(car1);
 /**
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
 */
        /**
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
