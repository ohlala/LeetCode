public class Solution {
    public int JumpFloorII(int target) {
        //f(n) = f(n-1) + f(n-2) + f(n-3) + + f(1) + 1;
        int current = 1;
        int total = 1;
        for (int i = 2; i <= target; i++){
            current = total + 1;
            total += current;
        }
        return current;
    }
}