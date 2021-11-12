package ram.dsa.stacks;

import ram.dsa.commons.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class StockSpan {

    // Identify the PrevLargestElement int the array and store their indexes
    // ip       : 100, 80, 60, 70,60,75,85
    // PGE      : -1, 100,80,80,70,80,100
    // PGE Index: -1, 0, 1,1,3,1,0
    // Sol = ArrayIndex - PGEIndex


    public static void main(String[] args) {
        int[] arr = find(new int[]{100, 80, 60, 70, 60, 75, 85});

        for(int i=0;i<arr.length;i++){
            System.out.print(i-arr[i] + " , ");
        }

    }

    private static int[] find(int[] arr) {
        List<Integer> list = new LinkedList<>();
        Stack<Pair> stack = new Stack<>();
        list.add(-1);
        stack.push(new Pair(arr[0], 0));

        for (int i = 1; i < arr.length; i++) {

            if ((!stack.isEmpty()) && arr[i] < stack.peek().getFirst()) {
                list.add(stack.peek().getSecond());
            } else {
                list.add(popStack(arr[i], stack));
            }
            Pair pair = new Pair(arr[i], i);
            stack.push(pair);

        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int popStack(int ele, Stack<Pair> stack) {
        while (!stack.isEmpty() && ele > stack.peek().getFirst()) {
            stack.pop();
        }
        return stack.isEmpty() ? -1 : stack.peek().getSecond();
    }


}
