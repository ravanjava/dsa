package ram.dsa.dp;

import java.util.Arrays;

public class SubSetSum {

    static boolean isSubsetSum(int numArray[], int arrayLength, int sum) {

        boolean matrix[][] = new boolean[arrayLength + 1][sum + 1];

        for (int r = 1; r <= sum; r++)
            matrix[0][r] = false;
        for (int c = 0; c <= arrayLength; c++)
            matrix[c][0] = true;

        for (int n = 1; n <= arrayLength; n++) {
            for (int s = 1; s <= sum; s++) {

                boolean prevResult = matrix[n-1][s];
                boolean currResult = false;

                int currNum = numArray[n-1];
                if (s >= currNum) {
                    int remainingNum = s - currNum;
                    currResult = matrix[n][remainingNum];
                }
                matrix[n][s] = prevResult || currResult;
            }
        }
        System.out.println(Arrays.deepToString(matrix)); // Visualization of the table

        return matrix[arrayLength][sum];
    }

    public static void main(String args[]) {
        int set[] = {1, 5, 10};
        int sum = 25;
        int n = set.length;
        if (isSubsetSum(set, n, sum) == true)
            System.out.println("Found a subset with given sum");
        else
            System.out.println("No subset with given sum");
    }
}