package ram.dsa.pramp;

import java.io.*;
import java.util.*;

class Sloution{

    static int[] scores = {6,3,1};

    public static void main(String[] arg){
        int totalScore = 8;
        System.out.println(getCount(totalScore));
    }

    private static int getCount(int target){
        int[][] dp = new int[scores.length+1][target+1];
        for(int i=1;i<scores.length;i++){
            for(int j=1;j<target;j++){
                if(scores[i-1]<=j){
                    dp[i][j] = dp[i-1][j-scores[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[scores.length][target];
    }
}
