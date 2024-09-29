package s02_spray_pot;

public class SprayBody {
    private final int capacityInMl;
    private int waterInMl;

    public SprayBody(int capacityInMl) {
        this.capacityInMl = capacityInMl;
    }

    public int getCapacityInMl() {
        return this.capacityInMl;
    }

    public int getWaterInMl() {
        return this.waterInMl;
    }

    public void setWaterInMl(int waterInMl) {
        this.waterInMl = Math.min(Math.max(waterInMl, 0), this.capacityInMl);
    }

    public void addWater(int waterInMl) {
        setWaterInMl(this.waterInMl + waterInMl);
    }

    public void reduceWater(int waterInMl) {
        setWaterInMl(this.waterInMl - waterInMl);
    }

    public void fillUp() {
        this.waterInMl = this.capacityInMl;
    }
}
