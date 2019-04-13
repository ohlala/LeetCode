//买巧克力，第一个人先选，他想选六个，n个人n块巧克力，有多少种选法
//首先就是把一个数k分解成正数相加的有多少种方法 2的k-1次幂 ，k从1加到n-7 还要在加1结果就是2的n-6次幂。所以这一题就是要求2的n-6次幂。在for循环里不停的把ans从1开始每次乘2并且用666666666取模这样ans就永远不会超出int范围了
import java.math.BigInteger;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n < 6){
            System.out.println(0);
            return;
        }
        BigInteger  result = new BigInteger("0");
        for (int i = 1; i <= n-6; i++){
            result = result.add(count(i));
        }
        result = result.add(BigInteger.ONE);
        System.out.println(result.mod(new BigInteger("666666666")).toString() );
    }

    public static BigInteger count(int target) {
        //f(n) = f(n-1) + f(n-2) + f(n-3) + + f(1) + 1;  = 2**n!!!!!!
        //long current = 1;
        //long total = 1;
        BigInteger current = new BigInteger("1");
        BigInteger total = new BigInteger("1");
        for (long i = 2; i <= target; i++){
            current = total.add(new BigInteger("1"));
            total = total.add(current);
        }
        return current;
    }
}

