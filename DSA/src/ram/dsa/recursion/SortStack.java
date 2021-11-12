package ram.dsa.recursion;

import java.util.Stack;

public class SortStack {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(7);
        s.push(4);
        s.push(8);
        s.push(6);
        s.push(1);

        sort(s);
        System.out.println(s.toString());

        deleteMid(s);
        System.out.println(s.toString());
    }

    public static void sort(Stack<Integer> s) {
        if (s.size() == 1) {
            return;
        }

        int temp = s.pop();
        sort(s);
        insert(s, temp);
    }

    public static void insert(Stack<Integer> s, int ele) {

        if (s.size() == 0 || s.peek() < ele) {
            s.push(ele);
            return;
        }
        int temp = s.pop();
        insert(s, ele);
        s.push(temp);
    }

    public static void deleteMid(Stack<Integer> s) {
        if (s.size() == 0)
            return;
        int mid = s.size() / 2 + 1;
        deleteRecurr(s, mid);
    }

    public static void deleteRecurr(Stack<Integer> s, int mid) {
        if (mid == 1) {
            s.pop();
            return;
        }
        int temp = s.pop();
        deleteRecurr(s, mid - 1);
        s.push(temp);
    }
}
