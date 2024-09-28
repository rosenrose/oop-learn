package s02_spray_pot;

public class WaterSpray {
    private SprayHead head;
    private SprayBody body;

    public WaterSpray(SprayHead head, SprayBody body) {
        this.head = head;
        this.body = body;
    }

    public WaterSpray(SprayAmount sprayAmount, BottleSize bottleSize) {
        this.head = switch (sprayAmount) {
            case SMALL -> new SprayHead(1);
            case MEDIUM -> new SprayHead(5);
            case LARGE -> new SprayHead(50);
        };

        this.body = switch (bottleSize) {
            case SMALL -> new SprayBody(100);
            case MEDIUM -> new SprayBody(500);
            case LARGE -> new SprayBody(1000);
        };
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
