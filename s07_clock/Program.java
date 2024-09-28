package s07_clock;

public class Program {
    public static void main(String[] args) {
        Clock clock = new Clock();

        clock.addSeconds((short) 10800);
        System.out.println(clock);

        clock.addSeconds((short) -10);
        System.out.println(clock);

        clock.addSeconds((short) 100);
        System.out.println(clock);
        System.out.println();

        clock = new Clock();
        clock.addSeconds((short) 12615);
        System.out.println(clock);
        System.out.printf("hour angle: %d%n", clock.getHourAngleInDegree());
        System.out.printf("minute angle: %d%n", clock.getMinuteAngleInDegree());
        System.out.printf("second angle: %d%n", clock.getSecondAngleInDegree());
    }
}
