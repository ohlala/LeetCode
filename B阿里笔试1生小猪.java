//小明是一个数学家，他喜欢用数字给事物命名编号，他给自己编号为1，同时在2019年小明开办了一个农场，准备开始养母猪，他专门给农场的母猪用以下数列2，3，4，5，7，9，12，16，21，28，37，49，65，86，114，151...进行命名。假设农场的母猪永远不会死，小母猪出生后3年后成熟，成熟后从第三年开始每年只会生一只小母猪。第一年农场，有一只刚刚出生的小母猪和一只成熟的母猪(本年不再生小猪，下一年开始生小猪)，并给他们编号为2和3。请问，第m只母猪编号为多少？其是哪一年出生的？小明还准备了1份礼物，专门颁给农场第1到m只的母猪颁奖，颁奖规则如下:选出第1到m只的母猪翻转编号(114编号翻转为411)为第k大的母猪进行颁奖，请问是第几只猪获奖？提示: f(n)=f(n-2)+f(n-3)
//
//已输入字数: 549 / 10000   运行
//编译器版本: Java 1.8.0_66
//请使用标准输入输出(System.in, System.out)；已禁用图形、文件、网络、系统相关的操作，如java.lang.Process , javax.swing.JFrame , Runtime.getRuntime；不要自定义包名称，否则会报错，即不要添加package answer之类的语句；您可以写很多个类，但是必须有一个类名为Main，并且为public属性，并且Main为唯一的public class，Main类的里面必须包含一个名字为'main'的静态方法（函数），这个方法是程序的入口
//时间限制: 2S (C/C++以外的语言为: 4 S)   内存限制: 128M (C/C++以外的语言为: 640 M)
//输入:
//输入两个参数半角逗号分隔
//m,k
//输出:
//输出三个数字半角逗号分隔
//第m只母猪编号,哪一年出生,第几只小猪获奖
//输入范例:
//20,3
//输出范例:
//465,2024,15


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

/** 请完成下面这个函数，实现题目要求的功能 **/
 /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
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

/** 请完成下面这个函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
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