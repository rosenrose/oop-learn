package s06_vector;

import java.util.List;

public class Vector {
    private final int x;
    private final int y;
    public List<Boolean> hello;

    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Vector add(Vector other) {
        return new Vector(this.x + other.x, this.y + other.y);
    }

    public Vector sub(Vector other) {
        return new Vector(this.x - other.x, this.y - other.y);
    }

    public int docProduct(Vector other) {
        return (this.x * other.x) + (this.y * other.y);
    }
}
