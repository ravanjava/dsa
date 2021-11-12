package ram.dsa.slidingwindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaxFruitCountOf2Types {

    public static void main(String[] args) {
        char[] fruits = {'A', 'B', 'C', 'A', 'C'};
        System.out.println(findLength(fruits));
    }

    public static int findLength(char[] arr) {
        int start = 0;
        int maxLen = Integer.MIN_VALUE;
        for (int end = 0; end < arr.length; end++) {
            int count = charCount(Arrays.copyOfRange(arr, start, end));
            if (2 == count) {
                maxLen = Math.max(maxLen, end - start + 1);
            }
            if (count > 2) {
                start++;
            }
        }
        return maxLen;
    }

    private static int charCount(char[] array) {

        Set<Character> set = new HashSet<>();
        for (char c : array) {
            set.add(c);
        }
        return set.size();
    }
}
