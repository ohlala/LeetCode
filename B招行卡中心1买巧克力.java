//���ɿ�������һ������ѡ������ѡ������n����n���ɿ������ж�����ѡ��
//���Ⱦ��ǰ�һ����k�ֽ��������ӵ��ж����ַ��� 2��k-1���� ��k��1�ӵ�n-7 ��Ҫ�ڼ�1�������2��n-6���ݡ�������һ�����Ҫ��2��n-6���ݡ���forѭ���ﲻͣ�İ�ans��1��ʼÿ�γ�2������666666666ȡģ����ans����Զ���ᳬ��int��Χ��
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

