package s08_graphics;

public class Program {
    public static void main(String[] args) {
        Point p1 = new Point("P1", 2, 7);
        Point p2 = new Point("P2", 1, 8);
        p1.draw();
        p2.draw();
        System.out.println();

        Line l1 = new Line("L1", p1, p2);
        l1.draw();
        System.out.println();

        Circle c1 = new Circle("C1", p1, 5);
        Circle c2 = new Circle("C2", p2, 10);
        c1.draw();
        c2.draw();
        System.out.println();

        Picture pic1 = new Picture("line and circle");
        pic1.add(l1);
        pic1.add(c1);
        pic1.draw();
        System.out.println();

        Picture pic2 = new Picture("nested pic");
        pic2.add(pic1);
        pic2.add(c2);
        pic2.draw();
        System.out.println();

        Picture pic3 = new Picture("pictures");
        pic3.add(pic1);
        pic3.add(pic2);
        pic3.draw();
    }
}
