package s07_clock;

public class Program {
    public static void main(String[] args) {
        AnalogClock analogClock = new AnalogClock();

        analogClock.addSeconds((short) 10800);
        System.out.println(analogClock);

        analogClock.addSeconds((short) -10);
        System.out.println(analogClock);

        analogClock.addSeconds((short) 100);
        System.out.println(analogClock);
        System.out.println();

        analogClock = new AnalogClock(12615);
        System.out.println(analogClock);
        System.out.printf("hour angle: %d°%n", analogClock.getHourAngleInDegree());
        System.out.printf("minute angle: %d°%n", analogClock.getMinuteAngleInDegree());
        System.out.printf("second angle: %d°%n", analogClock.getSecondAngleInDegree());
        System.out.println();

        analogClock = new AnalogClock(8219);
        System.out.println(analogClock);
        analogClock.tick();
        System.out.println(analogClock);
        System.out.println();

        DigitalClock digitalClock = new DigitalClock(8219);
        System.out.println(digitalClock);
        digitalClock.tick();
        System.out.println(digitalClock);
        System.out.println();

        analogClock = new AnalogClock(61704);
        System.out.println(analogClock);
        analogClock.tick();
        System.out.println(analogClock);
        System.out.println();

        digitalClock = new DigitalClock(61704);
        System.out.println(digitalClock);
        digitalClock.tick();
        System.out.println(digitalClock);
        System.out.println();
    }
}
