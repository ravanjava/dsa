package ram.dsa.binarysearch;

public class CeilingNumber {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 7, 9};
        System.out.println(ceilNumber(arr, 6));
    }

    static int ceilNumber(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == arr[mid]) {
                return arr[mid];
            }

            if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return arr[start];
    }
}
