//https://blog.csdn.net/u013240038/article/details/40790681
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int i=0, j=0, x=n-1, y=n-1,count=0;
        boolean bLast=true;

        while(bLast)
        {
            if(x==i)
                bLast=false;
            if(a[x] > b[y])
            {
                x--;
                y--;
                count+=1;
            }
            else if(a[i]> b[j])
            {
                i++;
                j++;
                count += 1;
            }
            else
            {
                if(a[i] < b[j])
                    count -= 1;
                i++;
                y--;
            }
        }
        System.out.println(count);
    }
}