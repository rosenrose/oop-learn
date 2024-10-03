package s13_widgets;

import java.util.ArrayList;
import java.util.Random;

public class Program {
    public static void main(String[] args) {
        final Button b1 = new Button("Button1", 10, 5);
        final Button b2 = new Button("Button2", 5, 0);
        final Card c1 = new Card("Card1", 0, 1);
        final Card c2 = new Card("Card2", -10, -1);
        final Directory d1 = new Directory("Dir1", 5, 9);
        final Directory d2 = new Directory("Dir2", 12, 22);

        final ArrayList<Widget> widgets = new ArrayList<>();
        widgets.add(b1);
        widgets.add(b2);
        widgets.add(c1);
        widgets.add(c2);
        widgets.add(d1);
        widgets.add(d2);

        for (Widget widget : widgets) {
            System.out.println(widget.getLabel());
        }
        ((IClickable) widgets.getFirst()).onClick();
        System.out.println();

        final ArrayList<IClickable> clickables = new ArrayList<>();
        clickables.add(b1);
        clickables.add(b2);
        clickables.add(d1);
        clickables.add(d2);

        for (IClickable clickable : clickables) {
            clickable.onClick();
        }
        System.out.println();

        final ArrayList<IDraggable> draggables = new ArrayList<>();
        draggables.add(c1);
        draggables.add(c2);
        draggables.add(d1);
        draggables.add(d2);

        final Random random = new Random(10);

        for (IDraggable draggable : draggables) {
            draggable.onDrag(random.nextInt(100), random.nextInt(100));
        }
        System.out.println();

        final ArrayList<IDroppable> droppables = new ArrayList<>();
        droppables.add(d1);
        droppables.add(d2);

        for (IDroppable droppable : droppables) {
            droppable.onDrop(b1);
        }
    }
}
