package ram.dsa.slidingwindow;

import java.util.PriorityQueue;

public class MaxNumberInSubArray {

    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        solve(arr,3);
    }

    static void solve(int[] arr, int k){
        int s=0;
        PriorityQueue<Integer> q = new PriorityQueue<>(3,(a,b)->b-a);
        for (int e=0;e<arr.length;e++){
            q.offer(arr[e]);
            if(e-s+1==k){
                System.out.println(q.peek());
                s++;
            }
        }
    }
}
