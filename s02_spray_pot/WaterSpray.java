package s02_spray_pot;

public class WaterSpray {
    private SprayHead head;
    private SprayBody body;

    public WaterSpray(SprayHead head, SprayBody body) {
        this.head = head;
        this.body = body;
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

    /* 1번 방법: 분무기를 화분에 대고 뿌린다
    public void sprayTo(FlowerPot pot) {
        int sprayAmtInMl = Math.min(5, this.waterInMl);

        pot.addWater(sprayAmtInMl);
        this.waterInMl -= sprayAmtInMl;
    }
    */
}
