package ram.dsa.slidingwindow;

public class MaxSumSubArray {
    public static void main(String[] args) {
            int[] a = {2,1,5,1,3,2};
            System.out.println(maxSum(a,3));
    }

    private static int maxSum(int[] a, int k){
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for (int i=0;i<k;i++) {
            sum += a[i];
        }
        int start =1;
        int end = k;
        ans = Math.max(ans,sum);
        while(end<a.length){
            sum = sum - a[start-1] + a[end];
            ans = Math.max(ans,sum);
            start++;
            end++;
        }
        return ans;
    }
}
