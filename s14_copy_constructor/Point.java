package s14_copy_constructor;

public final class Point {
    private int x;
    private int y;

    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public Point(final Point other) {
        this(other.x, other.y);
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void set(int x, int y) {
        setX(x);
        setY(y);
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", this.x, this.y);
    }
}
