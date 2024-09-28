package s07_clock;

public class AnalogClock extends BaseClock {
    static final int ANGLE_PER_HOUR_IN_DEGREE = 360 / 12;
    static final int ANGLE_PER_MIN_IN_DEGREE = 360 / 60;
    static final int ANGLE_PER_SEC_IN_DEGREE = 360 / 60;

    public void addSeconds(short secondAmt) {
        int seconds = (this.timeInSecond + secondAmt) % HALF_DAY_IN_SECONDS;

        if (seconds < 0) {
            seconds += HALF_DAY_IN_SECONDS;
        }

        this.timeInSecond = seconds;
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
}
