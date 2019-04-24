/*
�������
        ʱ�����ƣ�C/C++���� 1000MS���������� 3000MS
        �ڴ����ƣ�C/C++���� 65536KB���������� 589824KB
        ��Ŀ������
        С������һЩ����һ��ʱ���С����ˣʱ�����������ɢ���ڼ��У�һ�죬С������������������Ϊһ��������ֻ��һ����ɫ���򣬿��ж�����ӷ�ͬһ��ɫ����ÿ���������������2��������С������ú���ʹ�������в�����������ͬ�ģ�����ΪС��������ˡ���һ�����ֱ�ʾһ����ɫ����һ������ʾС���Ѿ��ҵ��˵Ĳ�����С�����ҵ���ȫ�������ܰ����������ô��
        ����
        ��һ�в�������: n,  2<n<10000
        �ڶ���һ������ai,  1<ai<10000  (�ų�aiȫ����ȵ����)
        ���
        ��������ã���С������������0
        ��������
        6
        1 1 2 2 2 2
        �������
        3

        ��ʾ
        ��������:
        6
        1 1 2 2 2 2
        �������:
        3      	tip: [1, 1] [2, 2] [2, 2]
        ��������:
        5
        1 1 1 2 2
        �������:
        0     		tip: [1 1 1] [2 2]

        ��������:
        6
        1 1 1 2 2 2
        �������:
        2      	tip: [1 1 1] [2 2 2]
*/

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0 ; i < n; i ++){
            int temp = in.nextInt();
            map.putIfAbsent(temp, 0);
            map.put(temp, map.get(temp)+1);
        }
        ArrayList<Integer> arrval = new ArrayList<>(map.values());
        int count = mgcd(arrval);
        if (count > 1){
            for(int i : arrval){
                res += i / count;
            }
        }
        System.out.println(String.valueOf(res));

    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static int mgcd(ArrayList<Integer> a) {

        int count = 0;
        if (a.size() == 2)
            return gcd(a.get(0), a.get(1));
        for (int i = 2; i < a.size(); i++) {
            count = gcd(gcd(a.get(i - 2), a.get(i-1)), a.get(i));
        }
        return count;
    }
}
