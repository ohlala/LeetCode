//数组上的值表示加血或者减血，从左上到右下，保持血量不低于1，初试血量最少是多少
//3
//3
//-2 -3 3 -5 10 1 0 30 -5
//

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] arr = new int[n][m];
        int[][] mask = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = in.nextInt();
                mask[i][j] = 0;
            }
        }

        mask[n - 1][m - 1] = -arr[n - 1][m - 1] + 1;
        for (int j = m - 2; j >= 0; j--) {
            mask[n - 1][j] = Math.max(mask[n - 1][j + 1] - arr[n - 1][j], 1);
        }

        for (int i = n - 2; i >= 0; i--) {
            mask[i][m - 1] = Math.max(mask[i + 1][m - 1] - arr[i][m - 1], 1);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                mask[i][j] = Math.min(mask[i + 1][j], mask[i][j + 1]);
                mask[i][j] -= arr[i][j];
                mask[i][j] = Math.max(mask[i][j], 1);
            }
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(mask[i][j]+' ');
//            }
//            System.out.println();
//        }

        System.out.println(mask[0][0]);
    }
}
