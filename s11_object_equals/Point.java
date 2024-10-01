package s11_object_equals;

public final class Point {
    private final int x;
    private final int y;

    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Point other) || this.hashCode() != other.hashCode()) {
            return false;
        }

        return this.x == other.x && this.y == other.y;
    }

    public int hashCode() {
        return this.x * 31 + this.y;
    }
}
