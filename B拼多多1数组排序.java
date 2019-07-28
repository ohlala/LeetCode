//从一个数组B中取一个最大的数，替换到一个差一个数就排好序的数组A中

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] numstr = str.split(" ");
        int[] a = new int[numstr.length];
        for (int i = 0; i < numstr.length; i++) {
            a[i] = Integer.parseInt(numstr[i]);
        }
        str = scanner.nextLine();
        numstr = str.split(" ");
        int[] b = new int[numstr.length];
        for (int i = 0; i < numstr.length; i++) {
            b[i] = Integer.parseInt(numstr[i]);
        }

        int index = a.length - 1;
        for (; index > 0; index--) {
            if (a[index] < a[index - 1])
                break;
        }
        Arrays.sort(b);
        boolean flag = true;
        if (index == a.length - 1) {
            for (int i = b.length - 1; i >= 0; i--) {
                if (b[i] > a[index - 1]) {
                    a[index] = b[i];
                    flag = false;
                    break;
                }
            }
        } else if (index == 0) {
            for (int i = b.length - 1; i >= 0; i--) {
                if (b[i] < a[index + 1]) {
                    a[index] = b[i];
                    flag = false;
                    break;
                }
            }
        } else {
            for (int i = b.length - 1; i >= 0; i--) {
                if (b[i] < a[index + 1] && b[i] > a[index - 1]) {
                    a[index] = b[i];
                    flag = false;
                    break;
                }
            }
        }
        if (flag == false) {
            for (int number : a) {
                System.out.print(number + " ");
            }
        } else {
            System.out.print("NO");
        }
    }
}