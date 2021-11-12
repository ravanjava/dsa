package ram.dsa.twopointers;

import java.util.Arrays;

public class RemoveNumberMatchingKey {


    public static int remove(int[] arr, int key) {
        int start=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=key){
                arr[start]=arr[i];
                start++;
            }
        }

        System.out.println(Arrays.toString(arr));

        return start;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 6, 3, 10, 9, 3};
        remove(arr,3);
    }
}
