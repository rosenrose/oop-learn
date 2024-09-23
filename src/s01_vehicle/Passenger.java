package s01_vehicle;

public class Passenger {
    public String name;

    public Passenger(String name) {
        this.name = name;
    }

    public void sayName() {
        System.out.printf("I'm %s!%n", this.name);
    }
}
