package ram.dsa.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinSizeSubArraySum {


    public static int findMaxSubArraySum(int sum,int[] arr){
        int s=0;
        int windowSum=0;
        int windowLen=0;
        for(int e=0;e<arr.length;e++){
            windowSum +=arr[e];
            while (windowSum>=sum){
                windowLen = Math.max(windowLen,e-s+1);
                windowSum -=arr[s];
                s++;
            }
        }

        return windowLen;
    }
    public static int findMinSubArrayLen(int S, int[] arr) {
        int windowSum = 0, minLength = Integer.MAX_VALUE;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element
            // shrink the window as small as possible until the 'windowSum' is smaller than 'S'
            while (windowSum >= S) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static int[] findMinSubArray(int S, int[] arr) {
        int windowSum = 0;
        int windowStart = 0;
        int minLength = Integer.MAX_VALUE;
        Map<Integer, int[]> map = new HashMap<>();
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element
            // shrink the window as small as possible until the 'windowSum' is smaller than 'S'
            while (windowSum >= S) {
                int[] pair = {arr[windowStart],arr[windowEnd]};
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                map.put(windowEnd-windowStart+1,pair);
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }

        return map.get(minLength);
    }


    public static void main(String[] args) {
        int result = MinSizeSubArraySum.findMinSubArrayLen(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);

        int[] resultArr = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Min Sub Array for Sum: "+Arrays.toString(resultArr));

        int result3 = MinSizeSubArraySum.findMaxSubArraySum(5, new int[] { 4,1,1,1,2,3,5 });
        System.out.println("Largest subarray length: " + result3);

    }
}
