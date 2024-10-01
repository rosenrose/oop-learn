package s11_object_equals;

public class Line {
    private final Point p1;
    private final Point p2;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Line other) || this.hashCode() != other.hashCode()) {
            return false;
        }

        return (this.p1.equals(other.p1) && this.p2.equals(other.p2))
                || (this.p1.equals(other.p2) && this.p2.equals(other.p1));
    }

    public int hashCode() {
        int hash = 17;
        hash = hash * 31 + this.p1.hashCode();
        hash = hash * 31 + this.p2.hashCode();

        return hash;
    }
}
