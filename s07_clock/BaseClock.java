package s07_clock;

public class BaseClock {
    protected int timeInSecond = 0;
    protected static final int HALF_DAY_IN_SECONDS = 60 * 60 * 12;

    public byte getHour() {
        int hour = this.timeInSecond / 60 / 60;

        return (byte) (hour == 0 ? 12 : hour);
    }

    public byte getMinute() {
        return (byte) (this.timeInSecond / 60 % 60);
    }

    public byte getSecond() {
        return (byte) (this.timeInSecond % 60);
    }

    public void tick() {
        this.timeInSecond = (this.timeInSecond + 1) % HALF_DAY_IN_SECONDS;
    }

    public void mount() {
        System.out.println("Mounted on the wall");
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
    }
}
