import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>(n);
        boolean flag1 = false;
        boolean flag2 = false;
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            arr.add(temp);
            if (temp % 2 == 0)
                flag1 = true;
            if (temp % 2 == 1)
                flag2 = true;
        }
        if (flag1 && flag2)
            arr.sort(Comparator.naturalOrder());
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " " );
        }
    }
}