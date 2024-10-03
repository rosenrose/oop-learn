package s13_widgets;

public abstract class Widget {
    private static int widgetCnt = 0;
    protected String label;
    protected int x;
    protected int y;

    public Widget() {
        this(0, 0);
    }

    public Widget(final int x, final int y) {
        this(String.format("Widget %d", widgetCnt), x, y);
    }

    public Widget(final String label, final int x, final int y) {
        this.label = label;
        this.x = x;
        this.y = y;
        widgetCnt++;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
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
}
