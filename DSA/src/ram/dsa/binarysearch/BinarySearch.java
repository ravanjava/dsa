package ram.dsa.binarysearch;

public class BinarySearch {

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8};

        if(search(arr,7)){
            System.out.println("found!");
        }
    }

    private static boolean search(int[] arr, int k){
        int start=0;
        int end = arr.length -1;

        while(start<=end){

            int mid = start+ (end-start)/2;
            if(k==arr[mid]){
                return true;
            }

            if(arr[mid]<k){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }


        return false;
    }
}
