package s02_spray_pot;

public class SprayHead {
    private final int sprayAmtInMl;

    public SprayHead(int sprayAmtInMl) {
        this.sprayAmtInMl = sprayAmtInMl;
    }

    public void sprayFrom(SprayBody body) {
        body.reduceWater(sprayAmtInMl);
    }
}
