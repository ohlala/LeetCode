//n个男生n个女生，w克水，每个人一个杯子容量为Wi；要求男生的水是女生的二倍，同性别一样，能用多少水
//我以为杯子是前一半是男生的后一半是女神的，结果是小的一半是女生的
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int w = in.nextInt();
        int[] arrboy = new int[n];
        int[] arrgirl = new int[n];
        for (int i = 0; i < n; i++)
            arrboy[i] = in.nextInt();
        for (int i = 0; i < n; i++)
            arrgirl[i] = in.nextInt();
//        Arrays.sort(arrboy);
//        Arrays.sort(arrgirl);
//        int boy = arrboy[0];
//        int girl = arrgirl[0];
        int boy = Arrays.stream(arrboy).min().getAsInt();
        int girl = Arrays.stream(arrgirl).min().getAsInt();
        double level = 0;
        if (boy > girl * 2)
            level = girl;
        else
            level = boy / 2.0;
        if (level * 3 * n < w)
            System.out.println(String.format("%.6f", level* 3 * n));
        else
            System.out.println(String.format("%.6f", w));
    }
}

