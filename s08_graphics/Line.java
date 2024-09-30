package s08_graphics;

public class Line extends Graphic {
    private Point p1;
    private Point p2;

    public Line(String label, Point p1, Point p2) {
        super(label);
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point getP1() {
        return this.p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return this.p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public double getLength() {
        int xDiff = this.p1.getX() - this.p2.getX();
        int yDiff = this.p1.getY() - this.p2.getY();

        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    public void draw() {
        System.out.printf("Line '%s'[%s-%s: %.2f]%n", this.label, this.p1, this.p2, getLength());
    }
}
