package s01_vehicle;

public class Passenger {
    private final String name;

    public Passenger(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void sayName() {
        System.out.printf("I'm %s!%n", this.name);
    }
}
