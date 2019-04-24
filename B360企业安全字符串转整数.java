/*
�ַ���ת����
        ʱ�����ƣ�C/C++���� 1000MS���������� 3000MS
        �ڴ����ƣ�C/C++���� 65536KB���������� 589824KB
        ��Ŀ������
        ��һ���ַ���ת����һ����������ֵΪ0�������ַ����Ȳ���һ���Ϸ�����ֵ�򷵻�0��С��ֱ��ȡ�������֡�Ҫ�󣺲���ʹ���ַ���ת�������Ŀ⺯��
*/

import java.util.*;

public class Main {


    /*������������������ʵ����ĿҪ��Ĺ���
    ��Ȼ����Ҳ���Բ������������ģ����������ȫ�����Լ����뷨�� ^-^
    ******************************��ʼд����******************************/
    static int string2int(String str) {
        String unsign;
        if (str.equals(""))
            return 0;
        if (str.charAt(0) == '-')
            unsign = str.substring(1);
        else
            unsign = str;
        int countOfDot = 0;
        for (int i = 0; i < unsign.length(); i++) {
            if (!Character.isDigit(unsign.charAt(i)) && unsign.charAt(i) != '.')
                return 0;
            if (unsign.charAt(i) == '.')
                countOfDot++;
        }
        if (countOfDot > 1) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < unsign.length(); i++) {
            if (unsign.charAt(i) == '.')
                break;
            result = (result + (unsign.charAt(i) - '0')) * 10;
        }
        result /= 10;
        if (str.charAt(0) == '-')
            result *= -1;
        return result;
    }

    /******************************����д����******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        String _str;
        try {
            _str = in.nextLine();
        } catch (Exception e) {
            _str = null;
        }

        res = string2int(_str);
        System.out.println(String.valueOf(res));

    }
}
