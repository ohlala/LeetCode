import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Solution mine = new Solution();
        int [][] ma = {{1,2,3,4,5}};
        System.out.println(mine.printMatrix(ma));
    }
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int col = matrix[0].length;
        int row = matrix.length;
        int len = col;
        if (len > row) len = row;

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < (len+1)/2; i++){
            for (int l = i; l < col-i; l++){
                result.add(matrix[i][l]);
            }
            for (int h = i+1 ; h < row-i; h++){
                result.add(matrix[h][col-i-1]);
            }
            for (int l = col-i-2; l >=i && (i*2+1!=row); l--){
                result.add(matrix[row-i-1][l]);
            }
            for (int h = row-i-2; h > i && (i*2+1!=col); h--){
                result.add(matrix[h][i]);
            }
        }
        return result;
    }
}