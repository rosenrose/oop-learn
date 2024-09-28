package s02_spray_pot;

public class WaterSpray {
    private final int capacity;
    private int waterAmtInMl;

    public WaterSpray(int capacity) {
        this.capacity = capacity;
        this.waterAmtInMl = capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getWaterAmtInMl() {
        return waterAmtInMl;
    }

    public void setWaterAmtInMl(int waterAmtInMl) {
        this.waterAmtInMl = Math.min(waterAmtInMl, this.capacity);
    }

    public void addWater(int waterAmtInMl) {
        setWaterAmtInMl(this.waterAmtInMl + waterAmtInMl);
    }

    public void fillUp() {
        this.waterAmtInMl = this.capacity;
    }

    public void spray() {
        this.waterAmtInMl -= Math.min(5, this.waterAmtInMl);
    }
}
