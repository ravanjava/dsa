package ram.dsa.binarysearch;

public class RotatedBinarySearch {

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,1,2,3};
        System.out.println(findPivot(arr));
        System.out.println(rotatedSerach(arr,2));
    }

    public static int rotatedSerach(int[] arr, int element) {

        int pivot = findPivot(arr);
        if(pivot == -1){
            return orderAgonosticBS(arr,element,0,arr.length);
        }

        if(arr[pivot]==element){
            return  pivot;
        }

        if(arr[0]<element){
            return orderAgonosticBS(arr,element,0,pivot);
        }else{
            return orderAgonosticBS(arr,element,pivot+1,arr.length-1);
        }
    }

    static int findPivot(int[] arr) {
        int start=0;
        int end=arr.length-1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(mid<arr.length && arr[mid]>arr[mid+1]){
                return mid;
            }
            if (mid>0 && arr[mid] < arr[mid-1]) {
                return mid;
            }

            if(arr[start]>arr[mid]){
                end = mid-1;
            }
            if(arr[start]<arr[mid]){
                start = mid+1;
            }
        }
        return -1;
    }


    static int orderAgonosticBS(int[] arr, int target, int start, int end) {

        //int start=0;
        //int end=arr.length-1;

        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == arr[mid]) {
                return mid;
            }

            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
