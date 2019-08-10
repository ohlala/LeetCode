//K个人 M次 传回自己手里

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        BigInteger[][] arr = new BigInteger[k + 1][n + 1];
        arr[0][1] = BigInteger.ONE;
        arr[1][2] = BigInteger.ONE;;
        arr[1][n] = BigInteger.ONE;;
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == 1)
                    arr[i][1] = arr[i - 1][2].add(arr[i - 1][n]) ;
                else if (j == n)
                    arr[i][n] = arr[i - 1][n - 1].add(arr[i - 1][1]) ;
                else
                    arr[i][j] = arr[i - 1][j - 1].add(arr[i - 1][j + 1]);
            }
        }
        BigInteger result = arr[k][1].mod(BigInteger.valueOf(1000000007));
        String res = result.toString();
        System.out.println(res);
    }
}