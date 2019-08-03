// 本题为考试多行输入输出规范示例，无需提交，不计分。
//5
//        A11B
//        (AA)2A
//        ((A2B)2)2G
//        (YUANFUDAO)2JIAYOU
//        A2BC4D2

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            int index = 0;
            boolean done = false;
            LinkedList<Character> linkedList = new LinkedList<>();

            while (!done) {
                done = true;
                for (; index < str.length(); index++) {
                    if (str.charAt(index) != ')' && !Character.isDigit(str.charAt(index))) {
                        linkedList.addLast(str.charAt(index));
                        continue;
                    }
                    StringBuilder sb = new StringBuilder();
                    if (str.charAt(index) == ')') {
                        char temp;
                        while ((temp = linkedList.pollLast()) != '(') {
                            sb.append(temp);
                        }
                        sb.reverse();
                        index++;
                    } else {
                        sb.append(linkedList.pollLast());
                    }

                    int beishu = 0;
                    if (Character.isDigit(str.charAt(index))) {
                        beishu = (str.charAt(index) - '0');
                        while (index + 1 < str.length() && Character.isDigit(str.charAt(index + 1))) {
                            beishu = beishu * 10 + str.charAt(index) - '0';
                            index++;
                        }
                    }
                    StringBuilder newsb = new StringBuilder();
                    for (int j = 0; j < beishu; j++)
                        newsb.append(sb);

                    for (int j = 0; j < newsb.length(); j++){
                        linkedList.addLast(newsb.charAt(j));
                    }
                    done = false;
                }
            }

            for (Character ch: linkedList) {
                System.out.print(ch);
            }
            System.out.println();
        }

    }

    public static void expand(String[] args) {

    }
}