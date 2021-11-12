package ram.dsa.stacks;

import java.util.*;

public class BalanceBrackets {
// Add any helper functions you may need here


    boolean isBalanced(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            }


            if (c == ')') {
                if (stack.isEmpty())
                    return false;
                if (stack.peek() != '(')
                    return false;

                stack.pop();
            }

            if (c == ']') {
                if (stack.isEmpty())
                    return false;
                if (stack.peek() != '[')
                    return false;

                stack.pop();
            }

            if (c == '}') {
                if (stack.isEmpty())
                    return false;
                if (stack.peek() != '{')
                    return false;

                stack.pop();
            }

        }

        return stack.isEmpty();

    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;

    void check(boolean expected, boolean output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            System.out.print(expected);
            System.out.print(" Your output: ");
            System.out.print(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printString(String str) {
        System.out.print("[" + str + "]");
    }

    public void run() {
        String s_1 = "{[(])}";
        boolean expected_1 = false;
        boolean output_1 = isBalanced(s_1);
        check(expected_1, output_1);

        String s_2 = "{{[[(())]]}}";
        boolean expected_2 = true;
        boolean output_2 = isBalanced(s_2);
        check(expected_2, output_2);
    }

    public static void main(String[] args) {
        new BalanceBrackets().run();
    }
}
