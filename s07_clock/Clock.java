package s07_clock;

public class Clock {
    private int timeInSecond = 0;
    static final int HALF_DAY_IN_SECONDS = 60 * 60 * 12;
    static final int ANGLE_PER_HOUR_IN_DEGREE = 360 / 12;
    static final int ANGLE_PER_MIN_IN_DEGREE = 360 / 60;
    static final int ANGLE_PER_SEC_IN_DEGREE = 360 / 60;

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

    public short getHourAngleInDegree() {
        return (short) ((getHour() % 12 * ANGLE_PER_HOUR_IN_DEGREE) + (getMinute() * ANGLE_PER_HOUR_IN_DEGREE / 60));
    }

    public short getMinuteAngleInDegree() {
        return (short) ((getMinute() * ANGLE_PER_MIN_IN_DEGREE) + (getSecond() * ANGLE_PER_MIN_IN_DEGREE / 60));
    }

    public short getSecondAngleInDegree() {
        return (short) (getSecond() * ANGLE_PER_SEC_IN_DEGREE);
    }

    public void tick() {
        addSeconds((short) 1);
    }

    public void mount() {
        System.out.println("Mounted on the wall");
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
    }
}
