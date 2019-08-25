// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String tempa = in.next();
            String a = tempa.split(" ")[0];
            tempa = in.next();
            String b = tempa.split(" ")[0];
            String[] arra = a.split("\\.");
            String[] arrb = b.split("\\.");
            ArrayList<String> arrayLista = new ArrayList<>(Arrays.asList(arra));
            ArrayList<String> arrayListb = new ArrayList<>(Arrays.asList(arrb));
            while (arrayLista.size()>arrayListb.size()){
                arrayListb.add("0");
            }
            while (arrayListb.size()>arrayLista.size()){
                arrayLista.add("0");
            }
            boolean flag = false;
            for (int j = 0; j < arrayLista.size(); j++) {
                if (Integer.valueOf(arrayLista.get(j)) > Integer.valueOf(arrayListb.get(j))) {
                    System.out.println("false");
                    flag = true;
                    break;
                }else if (Integer.valueOf(arrayLista.get(j)) < Integer.valueOf(arrayListb.get(j))) {
                    System.out.println("true");
                    flag = true;
                    break;
                }
                
            }
            if(flag == false){
                System.out.println("false");
            }
        }
    }
}


import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String a = in.next();
            HashSet<Integer> hashSet = new HashSet<>();
            boolean flag = true;
            while (Integer.valueOf(a) != 1) {
                int temp = 0;
                for (int j = 0; j < a.length(); j++) {
                    temp += (a.charAt(j) - '0') * (a.charAt(j) - '0');
                }
                if(hashSet.contains(temp)){
                    System.out.println("false");
                    flag = false;
                    break;
                }else {
                    hashSet.add(temp);
                }
                a = String.valueOf(temp);
            }
            if (flag){
                System.out.println("true");
            }
        }
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        String[] arra = a.split(" ");
        String[] arrb = b.split(" ");
        int j = 0;
        for (int i = 0; i < arra.length; i++) {
            System.out.print(arra[i] + " ");
            if ((i + 1) % 4 == 0 && j < arrb.length) {
                System.out.print(arrb[j] + " ");
                j++;
            }
        }
        for (; j < arrb.length; j++) {
            System.out.print(arrb[j] + " ");
        }
    }
}