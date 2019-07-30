import java.util.Arrays;

public class Solution {
    public static int GetNumberOfK(int[] array, int k) {
        int count = 0;
        int index = binarySearch(array, k);
        if (index < 0)
            count = 0;
        else {
            count = 1;
            int pre = index - 1;
            while (pre >= 0 && array[pre] == k) {
                count++;
                pre--;
            }
            int after = index + 1;
            while (after < array.length && array[after] == k) {
                count++;
                after++;
            }
        }
        return count;
    }

    public static int binarySearch(int[] arr, int k) {
        int from = 0;
        int to = arr.length - 1;
        int mid = 0;
        while (from <= to) {
            mid = (to - from) / 2 + from;
            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] > k) {
                to = mid - 1;
            }else {
                from = mid + 1;
            }
        }
        return  -1;
    }

    public static void main(String[] args) {

    }
}