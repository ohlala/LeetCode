import java.util.ArrayList;
public class Solution {
        public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        B[0] = 1;
        for (int i = 1; i < A.length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        int temp = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            B[i] = B[i] * temp;
            temp = temp * A[i];
        }
        return B;
    }
}