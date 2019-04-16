// n个勇士学K个技能，有m个先知，要多久？
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int m = in.nextInt();
        if (n * k % m > 0){
            System.out.print(n * k / m + 1); //!!!!! 要考虑学生的数量，一次最多学n个人
        }else
            System.out.print(n * k / m);
    }
}