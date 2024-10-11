package s02_spray_pot;

public class WaterSpray {
    private SprayHead head;
    private SprayBody body;

    public WaterSpray(SprayHead head, SprayBody body) {
        this.head = head;
        this.body = body;
    }

    public WaterSpray(SprayAmount sprayAmount, BottleSize bottleSize) {
        switch (sprayAmount) {
            case SMALL -> this.head = new SprayHead(1);
            case MEDIUM -> this.head = new SprayHead(5);
            case LARGE -> this.head = new SprayHead(50);
            default -> {
                assert (false) : "Unknown size: " + sprayAmount;
            }
        }

        switch (bottleSize) {
            case SMALL -> this.body = new SprayBody(100);
            case MEDIUM -> this.body = new SprayBody(500);
            case LARGE -> this.body = new SprayBody(1000);
            default -> {
                assert (false) : "Unknown size: " + bottleSize;
            }
        }
    }

    public SprayHead getHead() {
        return this.head;
    }

    public void setHead(SprayHead head) {
        this.head = head;
    }

    public SprayBody getBody() {
        return this.body;
    }

    public void setBody(SprayBody body) {
        this.body = body;
    }

    public int getCapacityInMl() {
        return this.body.getCapacityInMl();
    }

    public int getWaterInMl() {
        return this.body.getWaterInMl();
    }

    public void addWater(int waterInMl) {
        this.body.addWater(waterInMl);
    }

    public void fillUp() {
        this.body.fillUp();
    }

    public void spray() {
        this.head.sprayFrom(this.body);
    }

    /* 1번 방법: 분무기를 화분에 대고 뿌린다
    public void sprayTo(FlowerPot pot) {
        int sprayAmtInMl = Math.min(5, this.waterInMl);

        pot.addWater(sprayAmtInMl);
        this.waterInMl -= sprayAmtInMl;
    }
    */
}
