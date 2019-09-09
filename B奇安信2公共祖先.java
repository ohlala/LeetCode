import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int length = (int) Math.round(Math.pow(2,n));
        int[] tree = new int[length];
        tree[0] = -99;
        for (int i = 1; i < length; i++){
            tree[i] = in.nextInt();
        }
        int x = in.nextInt();
        int y = in.nextInt();
        if (x == -1 || y == -1){
            System.out.println(-1);
            return;
        }
        int indexx, indexy;
        for (indexx = 1; indexx < tree.length && tree[indexx] != x; indexx++);
        for (indexy = 1; indexy < tree.length && tree[indexy] != y; indexy++);
        if (indexx == tree.length || indexy == tree.length){
            System.out.println(-1);
            return;
        }
        ArrayList<Integer> xx = new ArrayList<>();
        ArrayList<Integer> yy = new ArrayList<>();
        while(indexx > 1){
            xx.add(indexx);
            indexx = indexx / 2;
        }
        while(indexy > 1){
            yy.add(indexy);
            indexy = indexy / 2;
        }
        Collections.reverse(xx);
        Collections.reverse(yy);
        int res = 1;
        for(int i = 0; i < xx.size()&&i<yy.size()&&(xx.get(i) == yy.get(i));i++ )
            res = xx.get(i);
        System.out.println(tree[res]);
    }

}