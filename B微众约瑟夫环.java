//N个人编号1到n报数，到M的退出，下一个从1开始报，输出退出顺序
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        if (n == 1){
            System.out.print("1");
            return;
        }
        ArrayList<Integer> arr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            arr.add(i + 1);
        }
        int i = -1, count = 0;
        while (arr.size() > 1) {
            i++;
            if (i >= arr.size()) {
                i -= arr.size();
            }
            count++;
            if (count == m){
                count = 0;
                System.out.print(arr.remove(i));
                System.out.print(' ');
                i--;
            }

        }
        System.out.println();
        System.out.print(arr.get(0));
    }
}