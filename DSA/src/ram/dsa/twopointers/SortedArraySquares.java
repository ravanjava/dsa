package ram.dsa.twopointers;

import java.util.Arrays;
import java.util.Collections;

public class SortedArraySquares {
        public static int[] makeSquares(int[] arr) {
            int[] squares = new int[arr.length];
            int start = 0;
            int end = arr.length-1;

            int i = arr.length-1;
            while (start < end) {
                int sqStart = arr[start] * arr[start];
                int sqEnd = arr[end] * arr[end];

                if (sqStart > sqEnd) {
                    squares[i--] = sqStart;
                    squares[i--] = sqEnd;
                } else {
                    squares[i--] = sqEnd;
                    squares[i--] = sqStart;
                }
                start++;
                end--;

            }
            return squares;
        }

    public static void main(String[] args) {
        int[] result = SortedArraySquares.makeSquares(new int[] { -2, -1, 0, 2, 3 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }
    }
