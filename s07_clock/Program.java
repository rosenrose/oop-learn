package s07_clock;

public class Program {
    public static void main(String[] args) {
        Clock clock = new Clock();

        clock.setTime((byte) -15, (byte) 104, (byte) -88);
        System.out.println(clock);

        clock.setTime((byte) 4, (byte) 10, (byte) 34);
        System.out.println(clock);
    }
}
