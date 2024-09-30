package s08_graphics;

public class Circle extends Graphic {
    private Point center;
    private int radius;

    public Circle(String label, Point center, int radius) {
        super(label);
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return this.center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public int getRadius() {
        return this.radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public double getCircumference() {
        return 2 * Math.PI * this.radius;
    }

    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    public void draw() {
        System.out.printf("Circle '%s'[%s-%d: %.2f, %.2f]%n", this.label, this.center, this.radius, getCircumference(), getArea());
    }
}
