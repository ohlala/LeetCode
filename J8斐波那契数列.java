public class Solution {
    public int Fibonacci(int n) {
        //��̬�滮��
        int f = 0;
        int g = 1;
        while(n-- > 0){
            g += f;
            f = g - f; 
        }
        return f;
        //�Լ���� Ҫռ�ÿռ� �����ȵݹ����
//        int[] arr = new int[100];
//        arr[0] = 0;
//        arr[1] = 1;
//        arr[2] = 1;
//        for (int i = 3; i <= n; i++){
//            arr[i] = arr[i-1] + arr[i-2];
//        }
//        return arr[n];
    }
}