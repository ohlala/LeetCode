import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    //默认为最小堆
    PriorityQueue<Integer> right = new PriorityQueue<Integer>();
    PriorityQueue<Integer> left = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer i1, Integer i2) {
            return i2 - i1;
        }
    });

    public void Insert(Integer num) {
        //需要考虑初始情况
        if (left.size() == 0) {
            left.add(num);
            return;
        }
        if (right.size() == left.size()) {
            if (num <= right.peek()) {
                left.add(num);
            } else {
                left.add(right.poll());
                right.add(num);
            }
        } else {
            Integer temp = left.peek();
            if (temp <= num) {
                right.add(num);
            } else {
                right.add(left.poll());
                left.add(num);
            }
        }
    }

    public Double GetMedian() {
        if (right.size() == left.size()) {
            return (right.peek() + left.peek()) / 2.0;
        } else {
            return left.peek() * 1.0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {5, 2, 3, 4, 1, 6, 7, 0, 8};
        for (int i = 0; i < arr.length; i++) {
            solution.Insert(arr[i]);
            System.out.print(solution.GetMedian() + "  ");
        }
    }
}