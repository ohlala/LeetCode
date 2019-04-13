//输入一组字符串,n个，每个按照长度为8进行拆分，长度不够8补零
//in : 3 abc 12345678
//out: 12345678 abc00000
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] arrstr = in.nextLine().substring(1).split(" ");

        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int len = arrstr[i].length() / 8;
            int last = arrstr[i].length() % 8;
            int j = 0;
            for (; j < len; j++) {
                result.add(arrstr[i].substring(j * 8, j * 8 + 8));
            }
            if (last > 0) {
                String temp = arrstr[i].substring((j) * 8, arrstr[i].length());
                while (temp.length() < 8) {
                    temp = temp + '0';
                }
                result.add(temp);
            }
        }

        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + ' ');
        }
        String res = result.stream().collect(Collectors.joining(" "));
        System.out.print(res);
    }
}

