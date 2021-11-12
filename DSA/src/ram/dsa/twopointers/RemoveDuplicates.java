package ram.dsa.twopointers;

import java.util.Arrays;

public class RemoveDuplicates {


    public static int remove(int[] arr) {
        int nextNonDuplicate = 1; // index of the next non-duplicate element
        for (int i = 1; i < arr.length; i++) {
            if (arr[nextNonDuplicate - 1] != arr[i]) {
                swap(arr,nextNonDuplicate,i);
                nextNonDuplicate++;
            }
        }

        System.out.println(Arrays.toString(arr));
        return nextNonDuplicate;
    }


    private static void swap(int[] arr,int s,int e){
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 3, 3, 6, 6, 9};
        System.out.println(RemoveDuplicates.remove(arr));

        arr = new int[]{2, 2, 2, 11};
        System.out.println(RemoveDuplicates.remove(arr));
    }
}

