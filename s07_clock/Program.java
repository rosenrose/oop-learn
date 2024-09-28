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
    }
}
