package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Car car1 = new Car();
        car1.name="Ferrari";
        car1.mileage=50;
        car1.fuellevel=60;
        car1.damaged=true;
        car1.DoorsNumber=4;
        System.out.println("Properties of car "+ car1.name);
        System.out.println("Mileage: "+ car1.mileage);
        System.out.println("Fuel level : "+ car1.fuellevel);
        System.out.println("Damaged: "+ car1.damaged);
        System.out.println("Doors: "+ car1.DoorsNumber);
        
        Car car2= new Car();
        car2.name="Dacia";
        car2.mileage=50;
        car2.fuellevel=60;
        car2.damaged=true;
        car2.DoorsNumber=4;
        System.out.println("Properties of car "+ car2.name);
        System.out.println("Mileage: "+ car2.mileage);
        System.out.println("Fuel level : "+ car2.fuellevel);
        System.out.println("Damaged: "+ car2.damaged);
        System.out.println("Doors: "+ car2.DoorsNumber);

    }
}
