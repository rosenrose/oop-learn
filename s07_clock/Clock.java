package s07_clock;

public class Clock {
    private byte hour = 12;
    private byte minute = 0;
    private byte second = 0;

    public byte getHour() {
        return this.hour;
    }

    public void setHour(byte hour) {
        this.hour = hour;
    }

    public byte getMinute() {
        return this.minute;
    }

    public void setMinute(byte minute) {
        this.minute = minute;
    }

    public byte getSecond() {
        return this.second;
    }

    public void setSecond(byte second) {
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
}
