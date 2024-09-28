package s02_spray_pot;

public class WaterSpray {
    private final int capacity;
    private int waterInMl = 0;

    public WaterSpray(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getWaterInMl() {
        return waterInMl;
    }

    public void setWaterInMl(int waterInMl) {
        this.waterInMl = Math.min(waterInMl, this.capacity);
    }

    public void addWater(int waterInMl) {
        setWaterInMl(this.waterInMl + waterInMl);
    }

    public void fillUp() {
        this.waterInMl = this.capacity;
    }

    public void spray() {
        this.waterInMl -= Math.min(5, this.waterInMl);
    }
}
