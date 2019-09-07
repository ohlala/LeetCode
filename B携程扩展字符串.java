import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String resolve(String expr) {
        int count1 = 0;
        int count2 = 0;
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < expr.length(); i++) {
            if (expr.charAt(i) == ')'){
                count1++;
            }
            if (expr.charAt(i) == '('){
                count2++;
            }
            if (expr.charAt(i) != ')'){
                list.add(expr.charAt(i));
            }else{
                StringBuilder sb =  new StringBuilder();
                while (list.peekLast() != '('){
                    sb.append(list.peekLast());
                    list.pollLast();
                }
                list.pollLast();
                for(int j = 0; j< sb.length();j++){
                    list.add(sb.charAt(j));
                }
            }
        }
        StringBuilder res =  new StringBuilder();
        for (char ch: list) {
            res.append(ch);
        }
        if (count1 != count2){
            return  "";
        }
        return  res.toString();

    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}
