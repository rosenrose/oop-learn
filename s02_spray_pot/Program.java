package s02_spray_pot;

public class Program {
    public static void main(String[] args) {
        WaterSpray spray = new WaterSpray(100);
        spray.fillUp();

        FlowerPot pot = new FlowerPot(10);

        for (int i = 0; i < 2; i++) {
            int beforeAmt = spray.getWaterInMl();
            spray.spray();
            int sprayAmt = beforeAmt - spray.getWaterInMl();

            pot.addWater(sprayAmt);
        }

        pot.liveOneDay();
        System.out.printf("Is alive?: %s%n", pot.isAlive());
    }
}
