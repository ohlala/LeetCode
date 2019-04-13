//题目描述
//给定一个字符串，字符串包含数字、大小写字母以及括号（包括大括号，中括号，小括号），括号可以嵌套，即括号里面可以出现数字和括号。
//按照如下规则对字符串进行展开，不需要考虑括号不成对的问题，不考虑数字后面没有括号的情况，即 2a2(b)不考虑。
//数字表示括号里的字符串重复的次数，展开后的字符串不包含括号
//将字符串进行逆序展开
//输入abc2{de3[fg]}
//输出gfgfgfedgfgfgfedcba
//解法
//利用栈进行计算，每次判断此时是否是右括号，如果是的话，拿到对应的左括号之前的所有字符，在拿到对应左括号的数字，对字符进行重复以后，全部入栈。
//
//如果不是右括号，那么直接入栈。
import java.util.LinkedList;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int len = line.length();
        LinkedList<String> stack1 = new LinkedList<>();
 
        //输入abc2{de3[fg]}
        //输出gfgfgfedgfgfgfedcba
        for (int i = 0; i < len; i++) {
            String temp = line.charAt(i) + "";
            if (")]}".contains(temp)) {
 
                //得到上一个（括号之前的字母
                StringBuilder dup = new StringBuilder();
                while (!"({[".contains(stack1.getFirst())) {
                    dup.insert(0,stack1.removeFirst());
                }
                stack1.removeFirst();
 
                //注意此时的坑，因为数字可能是多位数，因此需要得到所有的数字
                StringBuilder numStr = new StringBuilder();
                while (!stack1.isEmpty() && stack1.getFirst().matches("[0-9]")) {
                    numStr.insert(0, stack1.removeFirst());
                }
                int num = Integer.parseInt(numStr.toString());
 
                //按照(前的数字进行重复，并且再次压入栈
                StringBuilder str = new StringBuilder();
                while (num > 0) {
                    str.append(dup);
                    --num;
                }
                for (int k = 0; k < str.length(); k++) {
                    stack1.addFirst(str.charAt(k) + "");
                }
            } else {
                stack1.addFirst(temp);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack1.isEmpty()) {
            result.append(stack1.removeFirst());
        }
        System.out.println(result.toString());
    }
}