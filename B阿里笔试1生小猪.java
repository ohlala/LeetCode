//С����һ����ѧ�ң���ϲ�������ָ�����������ţ������Լ����Ϊ1��ͬʱ��2019��С��������һ��ũ����׼����ʼ��ĸ����ר�Ÿ�ũ����ĸ������������2��3��4��5��7��9��12��16��21��28��37��49��65��86��114��151...��������������ũ����ĸ����Զ��������Сĸ�������3�����죬�����ӵ����꿪ʼÿ��ֻ����һֻСĸ����һ��ũ������һֻ�ոճ�����Сĸ���һֻ�����ĸ��(���겻����С����һ�꿪ʼ��С��)���������Ǳ��Ϊ2��3�����ʣ���mֻĸ����Ϊ���٣�������һ������ģ�С����׼����1�����ר�Ű��ũ����1��mֻ��ĸ��佱���佱��������:ѡ����1��mֻ��ĸ��ת���(114��ŷ�תΪ411)Ϊ��k���ĸ����а佱�������ǵڼ�ֻ��񽱣���ʾ: f(n)=f(n-2)+f(n-3)
//
//����������: 549 / 10000   ����
//�������汾: Java 1.8.0_66
//��ʹ�ñ�׼�������(System.in, System.out)���ѽ���ͼ�Ρ��ļ������硢ϵͳ��صĲ�������java.lang.Process , javax.swing.JFrame , Runtime.getRuntime����Ҫ�Զ�������ƣ�����ᱨ������Ҫ���package answer֮�����䣻������д�ܶ���࣬���Ǳ�����һ������ΪMain������Ϊpublic���ԣ�����MainΪΨһ��public class��Main�������������һ������Ϊ'main'�ľ�̬����������������������ǳ�������
//ʱ������: 2S (C/C++���������Ϊ: 4 S)   �ڴ�����: 128M (C/C++���������Ϊ: 640 M)
//����:
//��������������Ƕ��ŷָ�
//m,k
//���:
//����������ְ�Ƕ��ŷָ�
//��mֻĸ����,��һ�����,�ڼ�ֻС���
//���뷶��:
//20,3
//�������:
//465,2024,15


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

/** ������������������ʵ����ĿҪ��Ĺ��� **/
 /** ��Ȼ����Ҳ���Բ��������ģ����������ȫ�����Լ����뷨�� ^-^  **/
    static String calculate(int m, int k) {


    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(",");
        int m = Integer.valueOf(line[0]);
        int k = Integer.valueOf(line[1]);;
        System.out.println(calculate(m, k));

    }
}







import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

/** ������������������ʵ����ĿҪ��Ĺ��� **/
    /**
     * ��Ȼ����Ҳ���Բ��������ģ����������ȫ�����Լ����뷨�� ^-^
     **/
    static int sum(int [] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }

    static String calculate(int m, int k) {
        StringBuffer result = new StringBuffer();
        int[] arr = new int[m + 5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        for (int i = 4; i <= m; i++) {
            arr[i] = arr[i - 2] + arr[i - 3];
        }
        result.append(arr[m]);
        result.append(',');

        int year = 2017;
        int len = 4;
        int[] number = new int[len];
        for (int i = 0; i < len; i++) {
            number[i] = 0;
        }
        number[0] = 1;
        number[len-1] = 1;
        while(sum(number) < m){
            year ++;
            number[len-1] += number[len-2];
            for (int i = len-2; i>0 ; i--) {
                number[i] = number[i-1];
            }
            number[0] = number[len-1];
        }
        result.append(year);
        result.append(',');

        String[] str = new String[m+5];
        for (int i = 1;i <= m;i++){
            str[i] = String.valueOf(arr[i]);
            StringBuffer temp = new StringBuffer(str[i]);
            temp = temp.reverse();
            str[i] = temp.toString();
        }

        int[] order = new int[m+1];
        order[0] = 0;
        for (int i = 1;i <= m;i++){
            order[i] = Integer.valueOf(str[i]);
        }
        Arrays.sort(order);

        String aaa = String.valueOf(order[m+1-k]);
        StringBuffer bbb = n


        return result.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(",");
        int m = Integer.valueOf(line[0]);
        int k = Integer.valueOf(line[1]);
        ;
        System.out.println(calculate(m, k));

    }
}