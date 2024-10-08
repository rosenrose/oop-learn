package s13_widgets;

public final class Button extends Widget implements IClickable {
    public Button() {
        super();
    }

    public Button(int x, int y) {
        super(x, y);
    }

    public Button(String label, int x, int y) {
        super(label, x, y);
    }

    @Override
    public void onClick() {
        System.out.printf("Button %s clicked%n", this.label);
    }
}
