package ram.dsa.pramp;

import java.util.ArrayList;
import java.util.List;

public class MatrixSpiralCopy {

    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiral(arr).toString());
    }


    static List<Integer> spiral(int[][] matrix){
        List<Integer> list =  new ArrayList<>();
        int top=0,left=0;
        int bottom = matrix.length-1;
        int right= matrix[0].length-1;

        while (top<=bottom && left<=right){

            // ------>
            for(int i=left;i<=right;i++){
                list.add(matrix[top][i]);
            }
            top++;

            // to BOTTOM
            for(int i=top;i<=bottom;i++){
                list.add(matrix[i][right]);
            }
            right--;

            //<------
            if (top != bottom) {
                for(int i=right;i>=left;i--){
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // ^
            // |
            if (left != right) {
                for(int i=bottom;i>=top;i--){
                    list.add(matrix[i][left]);
                }
                left++;
            }

        }
        return list;
    }
}
