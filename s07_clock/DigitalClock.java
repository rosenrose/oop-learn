package s07_clock;

public class DigitalClock extends BaseClock {
    public DigitalClock() {
        this(0);
    }

    public DigitalClock(int timeInSecond) {
        super(timeInSecond);
    }

    public boolean isAm() {
        return super.timeInSecond < (DAY_IN_SECOND / 2);
    }

    public void setHour(byte hour) {
        hour = (byte) Math.min(Math.max(hour, 0), 23);
        super.timeInSecond += (hour - getHour24()) * 60 * 60;
    }

    public void setMinute(byte minute) {
        minute = (byte) Math.min(Math.max(minute, 0), 59);
        super.timeInSecond += (minute - getMinute()) * 60;

    }

    public void setSecond(byte second) {
        second = (byte) Math.min(Math.max(second, 0), 59);
        super.timeInSecond += (second - getSecond());
    }

    public void setIsAm(boolean inputIsAm) {
        if (isAm() == inputIsAm) {
            return;
        }

        super.timeInSecond = (super.timeInSecond + DAY_IN_SECOND / 2) % DAY_IN_SECOND;
    }

    public void setTime(byte hour, byte minute, byte second, boolean isAm) {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
        setIsAm(isAm);
    }

    public String toString() {
        return String.format("%s %02d:%02d:%02d", isAm() ? "AM" : "PM", getHour24(), getMinute(), getSecond());
    }
}
