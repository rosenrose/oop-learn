package s09_ecs;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

public class Program {
    public static final String FILENAME = "objects.csv";

    public static void main(String[] args) {
        Optional<GameObject> batman = loadGameObject("Batman");
        batman.ifPresent(GameObject::update);
        System.out.println();

        Optional<GameObject> tree = loadGameObject("Tree");
        tree.ifPresent(GameObject::update);
        System.out.println();

        Optional<GameObject> vampire = loadGameObject("Vampire");
        vampire.ifPresent(GameObject::update);
        System.out.println();
    }

    private static Optional<GameObject> loadGameObject(String name) {
        String directory = getClassPath();
        Path filePath = Paths.get(directory, FILENAME);
        File objectsFile = new File(filePath.toString());

        if (!objectsFile.exists() || !objectsFile.isFile()) {
            return Optional.empty();
        }

        List<String> lines;

        try {
            lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }

        Optional<String> objectLine = lines.stream().filter(line -> line.startsWith(name)).findAny();

        if (objectLine.isEmpty()) {
            return Optional.empty();
        }

        Optional<GameObject> obj = Optional.of(new GameObject(name));
        String[] components = objectLine.get().substring(name.length() + 1).split(",", -1);

        for (String component : components) {
            ComponentType type;

            try {
                type = ComponentType.valueOf(component.toUpperCase());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                return Optional.empty();
            }

            switch (type) {
                case AI -> obj.get().addComponent(new AiComponent());
                case CONTROLLABLE -> obj.get().addComponent(new ControllableComponent());
                case ENTITY -> obj.get().addComponent(new EntityComponent());
                case PHYSICS -> obj.get().addComponent(new PhysicsComponent());
            }
        }

        return obj;
    }

    private static String getClassPath() {
        String root = System.getProperty("user.dir");
        String packageName = Program.class.getPackageName();
        Path classPath = Paths.get(root, packageName.replace('.', '/'));

        return classPath.toAbsolutePath().normalize().toString();
    }
}
