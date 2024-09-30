package s07_clock;

public class AnalogClock extends BaseClock {
    static final int ANGLE_PER_HOUR_IN_DEGREE = 360 / 12;
    static final int ANGLE_PER_MIN_IN_DEGREE = 360 / 60;
    static final int ANGLE_PER_SEC_IN_DEGREE = 360 / 60;

    public AnalogClock() {
        this(0);
    }

    public AnalogClock(int timeInSecond) {
        super(timeInSecond);
    }

    public byte getHour() {
        int hour = super.getHour() % 12;

        return (byte) (hour == 0 ? 12 : hour);
    }

    public void addSeconds(short secondAmt) {
        int seconds = (super.timeInSecond + secondAmt) % DAY_IN_SECOND;

        if (seconds < 0) {
            seconds += DAY_IN_SECOND;
        }

        super.timeInSecond = seconds;
    }

    public short getHourAngleInDegree() {
        return (short) ((getHour() % 12 * ANGLE_PER_HOUR_IN_DEGREE) + (getMinute() * ANGLE_PER_HOUR_IN_DEGREE / 60));
    }

    public short getMinuteAngleInDegree() {
        return (short) ((getMinute() * ANGLE_PER_MIN_IN_DEGREE) + (getSecond() * ANGLE_PER_MIN_IN_DEGREE / 60));
    }

    public short getSecondAngleInDegree() {
        return (short) (getSecond() * ANGLE_PER_SEC_IN_DEGREE);
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
    }
}
