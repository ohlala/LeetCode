//n������n��Ů����w��ˮ��ÿ����һ����������ΪWi��Ҫ��������ˮ��Ů���Ķ�����ͬ�Ա�һ�������ö���ˮ
//����Ϊ������ǰһ���������ĺ�һ����Ů��ģ������С��һ����Ů����
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

