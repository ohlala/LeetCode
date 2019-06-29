import static java.lang.Math.pow;

public class Solution {
    //21345为例
    public int NumberOf1Between1AndN_Solution(int n) {
        String strn = String.valueOf(n);
        return core(strn);
    }

    public int core(String strn) {
    		//不能使用valueOf(strn.charAt()); 否则出现的是ascll码
        int charat0 = Integer.valueOf(strn.substring(0,1));
        if (strn.length() == 1)
            return charat0 == 0 ? 0 : 1;
        //分为三部分计算 第一位 1346-21345  或者 1356-11345 分为两种情况 （考虑10000的特殊情况）（三目运算多加括号）
        int first = charat0 > 1 ? (int) pow(10, strn.length() - 1) : ((charat0 >= 1 ? 1 : 0) + Integer.valueOf(strn.substring(1)));
        //第二部分为 除去最高位以外 剩下的几位 选一个为1(Cn1)乘以10的n次方
        int other = (charat0 - 0) * (strn.length() - 1) * (int) pow(10, strn.length() - 2);
        //第三部分为 递归处理 0-1345部分
        return first + other + core(strn.substring(1));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.NumberOf1Between1AndN_Solution(21345));
    }
}