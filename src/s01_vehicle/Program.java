package s01_vehicle;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        Passenger john = new Passenger("John");
        john.sayName();

        Vehicle motorcycle = new Vehicle(VehicleType.MOTORCYCLE);
        motorcycle.addPassenger(john);
        motorcycle.addFuel(22.0);

        ArrayList<Passenger> taxiPassengers = new ArrayList<>();
        taxiPassengers.add(new Passenger("Tony"));
        taxiPassengers.add(new Passenger("Thor"));

        Vehicle taxi = new Vehicle(VehicleType.SEDAN, taxiPassengers);
        taxi.addFuel(60.0);

        ArrayList<Passenger> vanPassengers = new ArrayList<>();
        vanPassengers.add(new Passenger("A"));
        vanPassengers.add(new Passenger("B"));
        vanPassengers.add(new Passenger("C"));
        vanPassengers.add(new Passenger("D"));
        vanPassengers.add(new Passenger("E"));

        Vehicle van = new Vehicle(VehicleType.MINIVAN, vanPassengers, 70.5);

        System.out.println("Motorcycle:");
        motorcycle.drive(50);

        System.out.println("Taxi:");
        taxi.drive(50);

        System.out.println("Van:");
        van.drive(50);

        van.removePassenger("C");
        van.removePassenger("D");

        System.out.println("Van:");
        van.drive(1000);

        System.out.println("Van:");
        van.addFuel(50.0);
        van.drive(100);
    }
}
