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

    public String toString() {
        return String.format("%s %02d:%02d:%02d", isAm() ? "AM" : "PM", getHour(), getMinute(), getSecond());
    }
}
