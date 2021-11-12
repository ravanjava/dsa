package ram.dsa.binarysearch;

import java.util.Arrays;

public class FirstAndLastOccur {
    public static void main(String[] args) {
        int arr[] = {5,7,7,7,7,7,7,7,8,8,8,8,9,9};
        System.out.println( Arrays.toString(searchRange(arr,8)));
    }

    static  int[] searchRange(int[] nums , int target){
        int[] ans = {-1,-1};
        ans[0]  = bs(nums,target,true);
        ans[1]  = bs(nums,target,false);
        return ans;
    }

    static  int bs(int[] arr , int target,boolean firstOccr){
        int res = -1;
        int start=0;
        int end = arr.length -1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(target==arr[mid]){
                res = mid;
                if(firstOccr){
                    end = mid-1;
                }else {
                    start = mid+1;
                }
            }

            else if(arr[mid]<target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return res;
    }
}




