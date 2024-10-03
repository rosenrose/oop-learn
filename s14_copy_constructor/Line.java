package s14_copy_constructor;

public final class Line implements Cloneable {
    private Point p1;
    private Point p2;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Line(Line other) {
        this(new Point(other.p1), new Point(other.p2));
    }

    @Override
    public String toString() {
        return String.format("[%s-%s]", this.p1, this.p2);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Line cloned = (Line) super.clone();
        cloned.p1 = (Point) this.p1.clone();
        cloned.p2 = (Point) this.p1.clone();

        return cloned;
    }
}
