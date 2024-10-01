package s08_graphics;

public class Point extends Graphic {
    private int x;
    private int y;

    public Point(String label) {
        this(label, 0, 0);
    }

    public Point(String label, int x, int y) {
        super(label);
        this.x = x;
        this.y = y;
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

    @Override
    public String toString() {
        return String.format("(%d,%d)", this.x, this.y);
    }

    public void draw() {
        System.out.printf("Point '%s'%s%n", this.label, this);
    }
}
