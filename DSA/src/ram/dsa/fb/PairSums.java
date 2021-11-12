package ram.dsa.fb;

import java.io.*;
import java.util.*;
// Add any extra import statements you may need here


class PairSums {

    // Add any helper functions you may need here
    int numberOfWays(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : arr) {
            if (!map.containsKey(n))
                map.put(n, 0);
            map.put(n, map.get(n) + 1);
        }

        int twice_count = 0;

        for (int n : arr) {
            int find = k - n;
            if (map.get(find) != null)
                twice_count += map.get(find);
            if (find == n)
                twice_count--;
        }
        return twice_count / 2;

    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;

    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }

    public void run() {
        int k_1 = 4;
        int[] arr_1 = {2, 2, 1, 3};
        int expected_1 = 2;
        int output_1 = numberOfWays(arr_1, k_1);
        check(expected_1, output_1);

        int k_2 = 6;
        int[] arr_2 = {1, 5, 3, 3, 3};
        int expected_2 = 4;
        int output_2 = numberOfWays(arr_2, k_2);
        check(expected_2, output_2);


        int k_3 = 3;
        int[] arr_3 = {1, 2, 5};
        int expected_3 = 1;
        int output_3 = numberOfWays(arr_3, k_3);
        check(expected_3, output_3);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new PairSums().run();
    }
}
