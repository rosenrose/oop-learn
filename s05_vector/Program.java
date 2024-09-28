package s05_vector;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Program {
    public static void main(String[] args) {
        Vector vector = new Vector(2, 5);
        Class<? extends Vector> vectorClass = vector.getClass();

        System.out.printf("Name: %s%n", vectorClass.getName());
        System.out.printf("Package name: %s%n", vectorClass.getPackageName());
        System.out.printf("Canonical name: %s%n", vectorClass.getCanonicalName());
        System.out.printf("Simple name: %s%n", vectorClass.getSimpleName());
        System.out.printf("Type name: %s%n%n", vectorClass.getTypeName());

        Method[] methods = vectorClass.getMethods();
        System.out.printf("All Methods: %d%n", methods.length);

        for (Method method : methods) {
            System.out.printf("name: %s%n", method.getName());
            System.out.printf("  toGenericString: %s%n", method.toGenericString());
            System.out.printf("  toString       : %s%n", method);
        }
        System.out.println();

        methods = vectorClass.getDeclaredMethods();
        System.out.printf("Declared Methods: %d%n", methods.length);

        for (Method method : methods) {
            System.out.printf("name: %s%n", method.getName());
            System.out.printf("  toString: %s%n", method);
        }
        System.out.println();

        try {
            System.out.println(vectorClass.getMethod("toString"));
        } catch (NoSuchMethodException e) {
            System.out.printf("no method: %s%n", e);
        }

        try {
            System.out.println(vectorClass.getDeclaredMethod("toString"));
        } catch (NoSuchMethodException e) {
            System.out.printf("no method: %s%n", e);
        }

        try {
            System.out.println(vectorClass.getDeclaredMethod("crossProduct"));
        } catch (NoSuchMethodException e) {
            System.out.printf("no method: %s%n", e);
        }

        try {
            System.out.println(vectorClass.getDeclaredMethod("add", Vector.class));
        } catch (NoSuchMethodException e) {
            System.out.printf("no method: %s%n", e);
        }

        try {
            System.out.println(vectorClass.getDeclaredMethod("add", Vector.class, int.class));
        } catch (NoSuchMethodException e) {
            System.out.printf("no method: %s%n", e);
        }
        System.out.println();

        Field[] fields = vectorClass.getFields();
        System.out.printf("Public Fields: %d%n", fields.length);

        for (Field field : fields) {
            System.out.printf("name: %s%n", field.getName());
            System.out.printf("  toGenericString: %s%n", field.toGenericString());
            System.out.printf("  toString       : %s%n", field);
        }
        System.out.println();

        fields = vectorClass.getDeclaredFields();
        System.out.printf("Declared fields: %d%n", fields.length);

        for (Field field : fields) {
            System.out.printf("name: %s%n", field.getName());
            System.out.printf("  toString       : %s%n", field);
        }
        System.out.println();

        Class<?> obj = vectorClass.getSuperclass();
        System.out.printf("Name: %s%n", obj.getName());
        System.out.printf("Package name: %s%n", obj.getPackageName());
        System.out.printf("Canonical name: %s%n", obj.getCanonicalName());
        System.out.printf("Simple name: %s%n", obj.getSimpleName());
        System.out.printf("Type name: %s%n", obj.getTypeName());
    }
}
