public class Solution {
    //f(n) = f(n-1) + f(n-2) 本质上是斐波那契
    public int JumpFloor(int target) {
        if (1 == target)
            return 1;
        if (2 == target)
            return 2;
        int t1 = 1;
        int t2 = 2;
        int temp = 0;
        for (int i = 3; i <= target; i++){
            temp = t2;
            t2 += t1;
            t1 = temp;
        }
        return t2;
    }
}