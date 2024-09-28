package s07_clock;

public class Clock {
    private byte hour = 12;
    private byte minute = 0;
    private byte second = 0;

    public byte getHour() {
        return this.hour;
    }

    public void setHour(byte hour) {
        hour = (byte) ((hour - 1) % 12);

        if (hour < 0) {
            hour += 12;
        }

        this.hour = (byte) (hour + 1);
    }

    public byte getMinute() {
        return this.minute;
    }

    public void setMinute(byte minute) {
        minute %= 60;

        if (minute < 0) {
            minute += 60;
        }

        this.minute = minute;
    }

    public byte getSecond() {
        return this.second;
    }

    public void setSecond(byte second) {
        second %= 60;

        if (second < 0) {
            second += 60;
        }

        this.second = second;
    }

    public void setTime(byte hour, byte minute, byte second) {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }

    public short getHourAngle() {
        return (short) ((this.hour * 30) + (this.minute / 2));
    }

    public short getMinuteAngle() {
        return (short) ((this.minute * 6) + (this.second / 10));
    }

    public short getSecondAngle() {
        return (short) (this.second * 6);
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", this.hour, this.minute, this.second);
    }
}
