// n����ʿѧK�����ܣ���m����֪��Ҫ��ã�
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int m = in.nextInt();
        if (n * k % m > 0){
            System.out.print(n * k / m + 1); //!!!!! Ҫ����ѧ����������һ�����ѧn����
        }else
            System.out.print(n * k / m);
    }
}