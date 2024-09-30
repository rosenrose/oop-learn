package s07_clock;

public class BaseClock {
    protected int timeInSecond;
    protected static final int DAY_IN_SECOND = 60 * 60 * 24;

    public BaseClock() {
        this(0);
    }

    public BaseClock(int timeInSecond) {
        this.timeInSecond = timeInSecond;
    }

    public byte getHour() {
        return (byte) (this.timeInSecond / 60 / 60 % 24);
    }

    public byte getMinute() {
        return (byte) (this.timeInSecond / 60 % 60);
    }

    public byte getSecond() {
        return (byte) (this.timeInSecond % 60);
    }

    public void tick() {
        this.timeInSecond = (this.timeInSecond + 1) % DAY_IN_SECOND;
    }

    public void mount() {
        System.out.println("Mounted on the wall");
    }
}
