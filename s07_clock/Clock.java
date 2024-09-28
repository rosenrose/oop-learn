package s07_clock;

public class Clock {
    private int timeInSecond = 0;
    static final int HALF_DAY_IN_SECONDS = 60 * 60 * 12;

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

    public void addSeconds(short secondAmt) {
        int seconds = (this.timeInSecond + secondAmt) % HALF_DAY_IN_SECONDS;

        if (seconds < 0) {
            seconds += HALF_DAY_IN_SECONDS;
        }

        this.timeInSecond = seconds;
    }

    public short getHourAngle() {
        return (short) ((getHour() * 30) + (getMinute() / 2));
    }

    public short getMinuteAngle() {
        return (short) ((getMinute() * 6) + (getSecond() / 10));
    }

    public short getSecondAngle() {
        return (short) (getSecond() * 6);
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
    }
}
