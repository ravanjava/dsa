package ram.dsa.binarysearch;

public class OrderAgnosticBS {

    public static void main(String[] args) {
        int[] arr ={10,9,8,7,6,5,4,3,2,1};
        System.out.println(orderAgonosticBS(arr,6));
    }


    static int orderAgonosticBS(int[] arr,int target){
        int start=0;
        int end=arr.length-1;
        boolean isAsc=arr[start]<arr[end];

        while (start<=end){
            int mid = start + (end-start)/2;

            if(target==arr[mid]){
                return mid;
            }

            if(isAsc){
                if(target<arr[mid]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else{
                if(target>arr[mid]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }
        }



        return -1;
    }
}
