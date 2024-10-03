package s13_widgets;

public final class Card extends Widget implements IDraggable {
    private String content;

    public Card() {
        super();
    }

    public Card(int x, int y) {
        super(x, y);
    }

    public Card(String label, int x, int y) {
        super(label, x, y);
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void onDrag(int x, int y) {
        System.out.printf("Drag card %s from (%d,%d) -> (%d,%d)%n", this.label, this.x, this.y, x, y);
        this.x = x;
        this.y = y;
    }
}
