package s02_spray_pot;

public class WaterSpray {
    private final int capacityInMl;
    private int waterInMl = 0;

    public WaterSpray(int capacityInMl) {
        this.capacityInMl = capacityInMl;
    }

    public int getCapacityInMl() {
        return this.capacityInMl;
    }

    public int getWaterInMl() {
        return waterInMl;
    }

    public void setWaterInMl(int waterInMl) {
        this.waterInMl = Math.min(waterInMl, this.capacityInMl);
    }

    public void addWater(int waterInMl) {
        setWaterInMl(this.waterInMl + waterInMl);
    }

    public void fillUp() {
        this.waterInMl = this.capacityInMl;
    }

    public void spray() {
        this.waterInMl -= Math.min(5, this.waterInMl);
    }

    /* 1번 방법: 분무기를 화분에 대고 뿌린다
    public void sprayTo(FlowerPot pot) {
        int sprayAmtInMl = Math.min(5, this.waterInMl);

        pot.addWater(sprayAmtInMl);
        this.waterInMl -= sprayAmtInMl;
    }
    */
}
