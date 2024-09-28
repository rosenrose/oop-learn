package s02_spray_pot;

public class WaterSpray {
    private int waterAmtInMl = 0;

    public WaterSpray() {

    }

    public int getWaterAmtInMl() {
        return waterAmtInMl;
    }

    public void setWaterAmtInMl(int waterAmtInMl) {
        this.waterAmtInMl = waterAmtInMl;
    }

    public void addWater(int waterAmtInMl) {
        this.waterAmtInMl += waterAmtInMl;
    }

    public void spray() {
        this.waterAmtInMl -= Math.min(5, this.waterAmtInMl);
    }
}
