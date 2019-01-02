public class Solution {
    public int RectCover(int target) {
        //f(n) = f(n-1) + f(n-1)
        if (1 == target)
            return 1;
        if (2 == target)
            return 2;
        int p = 1;
        int q = 2;
        int r = 0;
        for (int i = 3; i <= target; i++){
            r = p + q;
            p = q;
            q = r;
        }
        return r;
    }
}