package ram.dsa.slidingwindow;

public class NoRepeatSubstring {

    public static void main(String[] args) {
        System.out.println(findLength("abccdeefghi"));
    }

    public static int findLength(String str) {

        char[] arr = str.toCharArray();
        int start=0;
        int ans= Integer.MIN_VALUE;
        int count= 1;

        for(int end=0;end<arr.length-1;end++){
            if(arr[end]==arr[end+1]){
                start = end;
                count=1;
            }else{
                count++;
            }
            ans = Math.max(ans,count);
        }

        return ans;
    }
}
