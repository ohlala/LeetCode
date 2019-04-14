import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arrh  = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++)
            arrh[i] = in.nextInt();

        res = arrh[n-1];
        for (int i = n-1; i >= 0; i--) {
            if (res > arrh[i]){
                res = res - (res - arrh[i]) / 2;
            }else if (res < arrh[i]){
                res = res + (arrh[i] + 1  - res) / 2;
            }
        }
        System.out.println(res);


    }
}
