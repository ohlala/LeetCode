public class Solution {
    public int NumberOf1(int n) {
        //若是两个负数，则是按二进制补码形式进行按位与
        int count = 0;
        while(n != 0){
            count ++;
            n = n & (n-1);
        }
        return count;
    }
}