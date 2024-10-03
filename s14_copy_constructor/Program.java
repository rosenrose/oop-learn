package s14_copy_constructor;

public class Program {
    public static void main(String[] args) {
        final Point p1 = new Point(1, 1);
        final Point p2 = new Point(p1);

        p1.set(-4, -8);

        System.out.printf("p1: %s%n", p1);
        System.out.printf("p2: %s%n", p2);

        final Point p3 = new Point(5, 7);
        final Line l1 = new Line(p2, p3);
        final Line l2 = new Line(l1);

        p2.set(10, 15);

        System.out.printf("l1: %s%n", l1);
        System.out.printf("l2: %s%n", l2);
    }
}
