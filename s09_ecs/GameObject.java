package s09_ecs;

import java.util.ArrayList;

public class GameObject {
    private final String name;
    private final ArrayList<Component> components = new ArrayList<>();

    public GameObject(String name) {
        this.name = name;
    }

    public void addComponent(Component component) {
        this.components.add(component);
    }

    public void update() {
        System.out.printf("Update GameObject '%s'%n", this.name);

        for (Component component : this.components) {
            component.update();
        }
    }
}
