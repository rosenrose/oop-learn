package s11_object_equals;

import java.util.HashSet;

public class Program {
    public static void main(String[] args) {
        Point p1 = new Point(4, 1);
        Point p2 = p1;

        Point p3 = new Point(4, 1);
        Point p4 = new Point(9, 13);

        System.out.printf("p1 == p2     : %s%n", p1 == p2);
        System.out.printf("p1.equals(p2): %s%n", p1.equals(p2));
        System.out.printf("p1 == p3     : %s%n", p1 == p3);
        System.out.printf("p1.equals(p3): %s%n", p1.equals(p3));
        System.out.println();

        Line l1 = new Line(p1, p4);
        Line l2 = new Line(p1, p4);

        System.out.printf("l1 == l2     : %s%n", l1 == l2);
        System.out.printf("l1.equals(l2): %s%n", l1.equals(l2));

        Point p5 = new Point(4, 1);
        Point p6 = new Point(9, 13);
        Line l3 = new Line(p6, p5);

        System.out.printf("l1 == l3     : %s%n", l1 == l3);
        System.out.printf("l1.equals(l3): %s%n", l1.equals(l3));
        System.out.println();

        HashSet<Point> points = new HashSet<>();
        points.add(p1);

        System.out.printf("points.contains(p3): %s%n", points.contains(p3));
        System.out.printf("points.contains(p4): %s%n", points.contains(p4));
        System.out.println();

        HashSet<Line> lines = new HashSet<>();
        lines.add(l2);

        System.out.printf("lines.contains(l1): %s%n", lines.contains(l1));
        System.out.printf("lines.contains(l3): %s%n", lines.contains(l3));
        System.out.println();
    }
}
