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

    /**
     * 2번 방법: 화분이 분무기를 사용한다
     * 좀 더 OOP 사고방식에 가까움
     * addWater(int)를 제거하고 분무기만 화분에 물을 줄 수 있음
     */
    public void addWater(WaterSpray spray) {
        int sprayAmtInMl = spray.getWaterInMl();
        spray.spray();
        sprayAmtInMl -= spray.getWaterInMl();

        this.receivedDailyWaterInMl += sprayAmtInMl;
    }

    public void liveOneDay() {
        if (this.receivedDailyWaterInMl < this.requiredDailyWaterInMl) {
            isAlive = false;
        }

        this.receivedDailyWaterInMl = 0;
    }
}
