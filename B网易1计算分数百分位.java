import java.util.*;
//Õ∞≈≈–Ú
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> fenshu = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            hashMap.put(i + 1, temp);
            fenshu.add(temp);
        }
        fenshu.sort(Comparator.naturalOrder());
        ArrayList<Double> res = new ArrayList<>();
        int qureyn = sc.nextInt();
        for (int i = 0; i < qureyn; i++) {
            int id = sc.nextInt();
            int fen = hashMap.get(id);
            int index = fenshu.indexOf(fen);
            res.add(index * (1.0) * 100 / n);
        }
        for (int i = 0; i < qureyn; i++) {
            System.out.printf("%.6f\n", res.get(i));
        }
    }
}


import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int[] scores = new int[151];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            scores[nums[i]]++;
        }
        for (int i = 1; i < 151; i++) {
            scores[i] += scores[i - 1];
        }

        int q = sc.nextInt();
        int[] per = new int[q];
        for (int i = 0; i < q; i++)
            per[i] = sc.nextInt();
        for (int i = 0; i < q; i++) {
            System.out.printf("%.6f\n", calculate(per[i] - 1, nums, scores));
        }
    }

    private static double calculate(int per, int[] nums, int[] scores) {
//     System.out.println(per);
//     System.out.println(nums[per]);
        return ((scores[nums[per]] - 1) / (double) (scores[150])) * 100;
    }
}