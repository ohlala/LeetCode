import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        int plow = 0;
        int phigh = array.length - 1;
        while (phigh > plow) {
            int temp = array[phigh] + array[plow];
            if (temp == sum) {
                res.add(array[plow]);
                res.add(array[phigh]);
                break;
            } else if (temp > sum) {
                phigh--;
            } else {
                plow++;
            }
        }
        return res;
    }
}