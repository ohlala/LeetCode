import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || size < 1 || num.length < size) {
            return res;
        }
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < size - 1; i++) {
            while(!linkedList.isEmpty() && num[i] > num[linkedList.peekLast()])
                linkedList.pollLast();
            linkedList.add(i);
        }
        for (int i = size - 1; i < num.length; i++) {
            while(!linkedList.isEmpty() && num[i] > num[linkedList.peekLast()])
                linkedList.pollLast();
            linkedList.add(i);
            if (i - linkedList.peekFirst() + 1 > size)
                linkedList.pollFirst();
            res.add(num[linkedList.peekFirst()]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 2, 6, 2, 5, 1};
        System.out.print(maxInWindows(arr, 3));
    }

}