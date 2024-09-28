package s02_spray_pot;

public class FlowerPot {
    private boolean isAlive = true;
    private final int requiredDailyWaterInMl;
    private int receivedDailyWaterInMl = 0;

    public FlowerPot(int requiredDailyWaterInMl) {
        this.requiredDailyWaterInMl = requiredDailyWaterInMl;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public int getRequiredDailyWaterInMl() {
        return this.requiredDailyWaterInMl;
    }

    public void addWater(int waterInMl) {
        this.receivedDailyWaterInMl += waterInMl;
    }

    public void liveOneDay() {
        if (this.receivedDailyWaterInMl < this.requiredDailyWaterInMl) {
            isAlive = false;
        }

        this.receivedDailyWaterInMl = 0;
    }
}
