package ram.dsa.stacks;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NearestSmallertoRight {


    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};
        System.out.println(Arrays.toString(find(arr)));
    }

    private static int[] find(int[] arr) {
        List<Integer> list = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {

            if ((!stack.isEmpty()) && arr[i] > stack.peek()) {
                list.add(0, stack.peek());
            } else {
                list.add(0, popStack(arr[i], stack));
            }
            stack.push(arr[i]);

        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int popStack(int ele, Stack<Integer> stack) {
        while (!stack.isEmpty() && ele <= stack.peek()) {
            stack.pop();
        }
        return stack.isEmpty() ? -1 : stack.peek();
    }


}
