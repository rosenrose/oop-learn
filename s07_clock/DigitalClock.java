package s07_clock;

import java.util.Arrays;

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
        hour = clamp(hour, (byte) 0, (byte) 23);

        super.timeInSecond += (hour - getHour()) * 60 * 60;
    }

    public void setMinute(byte minute) {
        minute = clamp(minute, (byte) 0, (byte) 59);

        super.timeInSecond += (minute - getMinute()) * 60;
    }

    public void setSecond(byte second) {
        second = clamp(second, (byte) 0, (byte) 59);

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

    public SevenSegmentDisplay[] getHourDisplay() {
        return convertToDisplay(getHour());
    }

    public SevenSegmentDisplay[] getMinuteDisplay() {
        return convertToDisplay(getMinute());
    }

    public SevenSegmentDisplay[] getSecondDisplay() {
        return convertToDisplay(getSecond());
    }

    private SevenSegmentDisplay[] convertToDisplay(byte num) {
        SevenSegmentDisplay[] displays = new SevenSegmentDisplay[2];

        displays[0] = new SevenSegmentDisplay((byte) (num / 10));
        displays[1] = new SevenSegmentDisplay((byte) (num % 10));

        return displays;
    }

    private byte clamp(byte val, byte lower, byte upper) {
        return (byte) Math.min(Math.max(val, lower), upper);
    }

    public void display() {
        String[] displayStrings = new String[5];
        Arrays.fill(displayStrings, "");

        for (SevenSegmentDisplay segDisplay : getHourDisplay()) {
            String[] hourDisplayStrings = segDisplay.getDisplayStrings();

            for (int i = 0; i < displayStrings.length; i++) {
                displayStrings[i] += hourDisplayStrings[i];
            }
        }

        displayStrings[0] += "   ";
        displayStrings[1] += " : ";
        displayStrings[2] += "   ";
        displayStrings[3] += " : ";
        displayStrings[4] += "   ";

        for (SevenSegmentDisplay segDisplay : getMinuteDisplay()) {
            String[] minuteDisplayStrings = segDisplay.getDisplayStrings();

            for (int i = 0; i < displayStrings.length; i++) {
                displayStrings[i] += minuteDisplayStrings[i];
            }
        }

        displayStrings[0] += "   ";
        displayStrings[1] += " : ";
        displayStrings[2] += "   ";
        displayStrings[3] += " : ";
        displayStrings[4] += "   ";

        for (SevenSegmentDisplay segDisplay : getSecondDisplay()) {
            String[] secondDisplayStrings = segDisplay.getDisplayStrings();

            for (int i = 0; i < displayStrings.length; i++) {
                displayStrings[i] += secondDisplayStrings[i];
            }
        }

        displayStrings[0] += "   ";
        displayStrings[1] += "   ";
        displayStrings[2] += isAm() ? " AM" : " PM";
        displayStrings[3] += "   ";
        displayStrings[4] += "   ";

        for (String displayString : displayStrings) {
            System.out.println(displayString);
        }
    }

    public String toString() {
        return String.format("%s %02d:%02d:%02d", isAm() ? "AM" : "PM", getHour(), getMinute(), getSecond());
    }
}
