import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (k > input.length || k <= 0){
            return new ArrayList<Integer>();
        }
        PriorityQueue pq = new PriorityQueue(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < input.length; i++) {
            if (pq.size() < k) {
                pq.add(input[i]);
            } else {
                int temp = (int) pq.poll();
                temp = temp > input[i] ? input[i] : temp;
                pq.add(temp);
            }
        }
        ArrayList<Integer> res = new ArrayList<>(pq);
        Comparator comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        };
        //res.sort(comparator);
       Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> res = GetLeastNumbers_Solution(arr, 4);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}

