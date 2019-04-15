//5  试题数量
//5 4 3 5 2   分数-cost 
//2 2 3 5 1 	时间-time
//10					总时间-ti
//16					最高分

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt()+1;
        int[] value = new int[n];
        int[] time = new int[n];
        for (int i = 1; i < n; i++) {
            value[i] = in.nextInt();
        }
        for (int i = 1; i < n; i++) {
            time[i] = in.nextInt();
        }

        int ti = in.nextInt()+1;

        int[][] temp = new int[n][ti];
        for (int i = 0; i < ti; i++) {
            temp[0][i] = 0;
        }
        for (int i = 0; i < n; i++) {
            temp[i][0] = 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < ti; j++) {
                if (time[i] <= j)
                    temp[i][j] = Math.max(temp[i-1][j],temp[i-1][j-time[i]]+value[i]);
                else
                    temp[i][j] = temp[i-1][j];
            }
        }
        System.out.println(temp[n-1][ti-1]);
    }
}
