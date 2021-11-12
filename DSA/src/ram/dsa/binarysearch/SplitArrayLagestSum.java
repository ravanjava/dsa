package ram.dsa.binarysearch;

//https://leetcode.com/problems/split-array-largest-sum/
public class SplitArrayLagestSum {

    public static void main(String[] args) {
        int[] arr = {7,2,5,10,8};

        System.out.println(solve(arr,2));
    }

    public static int solve(int[] arr, int m){
        int leftSum=0, rightSum=0;
        for(int n:arr){
            rightSum +=n;
        }
        int i=0;
        do{
            leftSum += arr[i];
            rightSum -= arr[i];
        }while(leftSum<rightSum);

        return rightSum+arr[i];
    }
}
