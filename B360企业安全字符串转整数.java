/*
字符串转整数
        时间限制：C/C++语言 1000MS；其他语言 3000MS
        内存限制：C/C++语言 65536KB；其他语言 589824KB
        题目描述：
        将一个字符串转换成一个整数，数值为0或者是字符串等不是一个合法的数值则返回0，小数直接取整数部分。要求：不能使用字符串转换整数的库函数
*/

import java.util.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
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

    /******************************结束写代码******************************/


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
