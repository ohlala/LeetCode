import static java.lang.Math.min;

public class Solution {
    public int GetUglyNumber_Solution(int index) {
        //边界情况要考虑
        if(index == 0)
            return 0;
        if(index == 1)
            return 1;
        int[] result = new int[index];
        result[0]  =  1;
        int cur = 0;
        int t2 = 0, t3 = 0, t5 = 0;
        int u2 = result[t2] * 2, u3 = result[t3] * 3, u5 = result[t5] * 5;

        while(true){
            while(u2<= result[cur]){
                t2++;
                u2 = result[t2]* 2;
            }
            while(u3<= result[cur]){
                t3++;
                u3 = result[t3]* 3;
            }
            while(u5<= result[cur]){
                t5++;
                u5 = result[t5]* 5;
            }
            result[++cur] = min(u2, min(u3, u5));
            if(cur == index-1)
                break;
        }
        return result[index-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.print(solution.GetUglyNumber_Solution(2));
    }
}