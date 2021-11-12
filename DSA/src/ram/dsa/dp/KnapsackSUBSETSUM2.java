package ram.dsa.dp;

import java.util.Arrays;

public class KnapsackSUBSETSUM2 {

    static int countSubsetSum(int set[], int numberOfElement, int sum) {

        int matrix[][] = new int[numberOfElement + 1][sum + 1];

        for (int r = 1; r <= sum; r++)
            matrix[0][r] = 0;
        for (int c = 0; c <= numberOfElement; c++)
            matrix[c][0] = 1;

        for (int n = 1; n <= numberOfElement; n++) {
            for (int s = 1; s <= sum; s++) {
                int prevVal = matrix[n-1][s];
                int currVal = 0;
                int currNum = set[n-1];
                if (s >= currNum) {
                    int remainingNum = s - currNum;
                    currVal = matrix[n][remainingNum];
                }
                matrix[n][s] = prevVal + currVal;
            }
        }


        System.out.println(Arrays.deepToString(matrix));

        return matrix[numberOfElement][sum];
    }

    /* Driver code*/
    public static void main(String args[]) {
        int set[] = {1, 2, 5};
        int sum = 11;
        System.out.println("Count of a subsets with given sum : "+countSubsetSum(set, set.length, sum));

    }
}