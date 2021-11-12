package ram.dsa.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringKDistinct {

    public static void main(String[] args) {
        System.out.println(findLength("acaaccci", 1));
    }

    private static int findLength(String input, int k) {
        int start = 0;
        char[] a = input.toCharArray();
        int maxLen = Integer.MIN_VALUE;

        for (int end = 0; end < input.length(); end++) {
            int count = charCount(input.substring(start, end + 1));
            if (k == count) {
                maxLen = Math.max(maxLen, end - start + 1);
            }
            if (count > k) {
                start++;
            }
        }
        return maxLen;
    }

    private static int charCount(String input) {
        char[] array = input.toCharArray();

        Set<Character> set = new HashSet<>();
        for (char c : array) {
            set.add(c);
        }
        return set.size();
    }
}
