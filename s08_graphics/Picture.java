package s08_graphics;

import java.util.ArrayList;
import java.util.List;

public class Picture extends Graphic {
    private List<Graphic> graphics;

    public Picture(String label) {
        super(label);
        this.graphics = new ArrayList<>();
    }

    public List<Graphic> getGraphics() {
        return this.graphics;
    }

    public void setGraphics(List<Graphic> graphics) {
        this.graphics = graphics;
    }

    public void add(Graphic graphic) {
        this.graphics.add(graphic);
    }

    public void draw() {
        if (this.graphics.isEmpty()) {
            return;
        }

        System.out.printf("Picture '%s'%n", this.label);

        for (Graphic graphic : this.graphics) {
            System.out.print("  ");

            switch (graphic.getClass().getSimpleName()) {
                case "Point" -> ((Point) graphic).draw();
                case "Line" -> ((Line) graphic).draw();
                case "Circle" -> ((Circle) graphic).draw();
                case "Picture" -> ((Picture) graphic).draw();
            }
        }
    }
}
