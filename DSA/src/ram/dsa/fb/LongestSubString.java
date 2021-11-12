package ram.dsa.fb;

public class LongestSubString {


    public static void main(String[] args) {
        System.out.println(lengthOfSubString("abcabcdbbpqrstu"));
    }

    public static int lengthOfSubString(String str) {

        char[] arr = str.toCharArray();

        int start = 0;
        int end = 1;

        int count = 0;

        while (end < arr.length) {
            if (arr[end] == arr[start]) {
                start++;
                count--;
            } else {
                count = Math.max(count,end-start);
                end++;
            }
        }
        return count-1;
    }
}
