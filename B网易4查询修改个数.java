import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//输入n个数，查询q次，每次查询输入一个值，将大于该值的所有数减一并输出被修改的数的个数

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] fenshu = new int[n];
        for (int i = 0; i < n; i++) {
            fenshu[i] = sc.nextInt();
        }
        Arrays.sort(fenshu);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int index = 0;
            index = Math.abs(Arrays.binarySearch(fenshu, x));
            if (index >= n) {
                res.add(0);
                continue;
            }
            while (index > 0 && fenshu[index - 1] >= fenshu[index]) {
                index--;
            }
            res.add(n - index);
            for (int j = index; j < n; j++) {
                fenshu[j]--;
            }
        }
        for (int i = 0; i < res.size() -1; i++ ){
            System.out.println(res.get(i));
        }
        System.out.print(res.get(res.size()-1));
    }
}