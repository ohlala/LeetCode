import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] li = new int[n];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++)
            li[i] = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            hashMap.put(li[i], scanner.nextInt());
        }
        Arrays.sort(li);
        int[] res = new int[n];
        res[0] = 1;
        int[] wi = new int[n];
        wi[0] = hashMap.get(li[0]);
        for (int i = 1; i < n; i++) {
            if (hashMap.get(li[i]) * 7 >= wi[i - 1]) {
                wi[i] = wi[i - 1] + hashMap.get(li[i]);
                res[i] = res[i - 1] + 1;
            } else {
                wi[i] = wi[i - 1];
                res[i] = res[i - 1];
            }
        }
        System.out.print(res[n-1]);

    }
}