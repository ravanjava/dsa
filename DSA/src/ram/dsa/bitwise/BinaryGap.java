package ram.dsa.bitwise;

public class BinaryGap {

    public static void main(String[] args) {

    }

    private static int gapZero(int n){

        n >>= Integer.numberOfTrailingZeros(n);

        int gap =0;

        while ((n & (n+1) ) !=0){
            n = n | n >> 1;
            gap++;
        }
        return gap;
    }
}
