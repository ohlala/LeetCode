import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for (int n = (int) Math.sqrt(2 * sum); n > 1; n--) {
            if ((sum % n) == 0 && (n & 1) == 1 || (sum % n) * 2 == n) {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int j = sum / n - (n - 1) / 2, k = 0; k < n; k++, j++) {
                    temp.add(j);
                }
                res.add(temp);
            }
        }
        return res;
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence1(int sum) {
        //存放结果
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        //两个起点，相当于动态窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
        int plow = 1, phigh = 2;
        while (phigh > plow) {
            //由于是连续的，差为1的一个序列，那么求和公式是(a0+an)*n/2
            int cur = (phigh + plow) * (phigh - plow + 1) / 2;
            //相等，那么就将窗口范围的所有数添加进结果集
            if (cur == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = plow; i <= phigh; i++) {
                    list.add(i);
                }
                result.add(list);
                plow++;
                //如果当前窗口内的值之和小于sum，那么右边窗口右移一下
            } else if (cur < sum) {
                phigh++;
            } else {
                //如果当前窗口内的值之和大于sum，那么左边窗口右移一下
                plow++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print(FindContinuousSequence(100));
    }

}