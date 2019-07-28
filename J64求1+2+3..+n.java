public class Solution {
    public static int Sum_Solution(int n) {
        int sum  = n;
        boolean b = (n != 0) && (sum += Sum_Solution(--n)) > 0;
        return sum;
    }
}