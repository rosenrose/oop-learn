package s15_liskov;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack();

        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);

        while (!stack.isEmpty()) {
            int num = stack.remove(0);
            System.out.println(num);
        }
        System.out.println();

        ArrayList<Integer> list = new ArrayList<>();
        addInOrder(list, 10);
        addInOrder(list, 2);
        addInOrder(list, 5);

        for (int num : list) {
            System.out.println(num);
        }
        System.out.println();

        list = new Stack<>();
        addInOrder(list, 10);
        addInOrder(list, 2);
        addInOrder(list, 5);

        for (int num : list) {
            System.out.println(num);
        }
    }

    private static void addInOrder(ArrayList<Integer> list, int num) {
        int idx;

        for (idx = 0; idx < list.size(); idx++) {
            if (list.get(idx) > num) {
                break;
            }
        }

        list.add(idx, num);
    }
}
