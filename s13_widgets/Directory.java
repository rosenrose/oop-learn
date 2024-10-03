package s13_widgets;

public final class Directory extends Widget implements IClickable, IDraggable, IDroppable {
    public Directory() {
        super();
    }

    public Directory(int x, int y) {
        super(x, y);
    }

    public Directory(String label, int x, int y) {
        super(label, x, y);
    }

    @Override
    public void onClick() {
        System.out.printf("Button %s clicked%n", this.label);
    }

    @Override
    public void onDrag(int x, int y) {
        System.out.printf("Drag card %s from (%d,%d) -> (%d,%d)%n", this.label, this.x, this.y, x, y);
        this.x = x;
        this.y = y;
    }

    @Override
    public void onDrop(Widget widget) {
        System.out.printf("Widget %s was dropped within Directory %s%n", widget.getLabel(), this.label);
    }
}
