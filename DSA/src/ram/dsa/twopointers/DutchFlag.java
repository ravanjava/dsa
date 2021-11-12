package ram.dsa.twopointers;

public class DutchFlag {

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 2, 0, 1, 2, 0  };
        DutchFlag.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void sort(int[] arr) {
        int s=0;
        int e=arr.length-1;
        int m=0;

        while(m<=e){
            switch(arr[m]){
                case 0: swap(arr,s,m);s++;m++;break;

                case 1: m++;break;
                case 2: swap(arr,e,m);e--;break;
                default : break;
            }
        }


    }

    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
