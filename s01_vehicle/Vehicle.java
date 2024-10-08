package s01_vehicle;

import java.util.ArrayList;

public class Vehicle {
    private final VehicleType type;
    private final ArrayList<Passenger> passengers;
    private double fuelAmount;
    private int mileage;

    public Vehicle(VehicleType type) {
        this(type, new ArrayList<>(), 0.0);
    }

    public Vehicle(VehicleType type, ArrayList<Passenger> passengers) {
        this(type, passengers, 0.0);
    }

    public Vehicle(VehicleType type, ArrayList<Passenger> passengers, double fuelAmount) {
        this.type = type;
        this.passengers = passengers;
        this.fuelAmount = fuelAmount;
        this.mileage = 0;
    }

    public void addPassenger(Passenger passenger) {
        this.passengers.add(passenger);
    }

    public void removePassenger(String passengerName) {
        for (Passenger p : this.passengers) {
            if (p.getName().equals(passengerName)) {
                this.passengers.remove(p);
                return;
            }
        }
    }

    public void addFuel(double fuelAmount) {
        this.fuelAmount += fuelAmount;
    }

    public void drive(int distance) {
        System.out.printf("Driving %dkm%n", distance);

        double gasMileage = switch (this.type) {
            case MOTORCYCLE -> 0.05;
            case SEDAN -> 0.07;
            case MINIVAN -> 0.1;
        };

        double requiredFuel = (gasMileage * distance) + (this.passengers.size() * 0.01);

        if (requiredFuel > this.fuelAmount) {
            System.out.printf("Not enough fuel: %.2fL.%n", this.fuelAmount);
            return;
        }

        this.fuelAmount -= requiredFuel;
        this.mileage += distance;

        System.out.printf("Fuel Amount: %.2fL.%n", this.fuelAmount);
        System.out.printf("Mileage: %dkm.%n%n", this.mileage);
    }
}
