package ram.dsa.slidingwindow;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeNumber {
    public static void main(String[] args) {
        int[] arr = {12,-1,-7,8,-15,30,16,28};
        solve(arr,3);
    }

    private static void solve(int[] arr, int k){
        int s=0;
        Queue<Integer> q =  new LinkedList<>();
        for(int e=0;e<arr.length;e++){
            if(arr[e]<0){
                q.offer(arr[e]);
            }

            if(e-s+1==k){
                if(!q.isEmpty())
                    System.out.print(q.poll());
                s++;
            }
        }
    }
}
