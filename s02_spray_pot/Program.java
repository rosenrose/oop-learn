package s02_spray_pot;

public class Program {
    public static void main(String[] args) {
        SprayHead head = new SprayHead(5);
        SprayBody body = new SprayBody(100);
        body.fillUp();

        WaterSpray spray = new WaterSpray(head, body);
        FlowerPot pot = new FlowerPot(10);

        for (int i = 0; i < 2; i++) {
            pot.addWater(spray);
        }

        pot.liveOneDay();
        System.out.printf("Is alive?: %s%n", pot.isAlive());
        System.out.printf("Water amount: %d%n", body.getWaterInMl());
    }
}
