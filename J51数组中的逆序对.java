import java.util.Arrays;

public class Solution {
    public int InversePairs(int[] array) {
        if (array.length <= 1)
            return 0;
        if (array.length == 2)
            return array[0] > array[1] ? 1 : 0;
        int[] copy = Arrays.copyOf(array, array.length);
        return core(array, copy, 0, array.length - 1);
    }

    public int core(int[] array, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = array[start];
            return 0;
        }
        int mid = (end - start) / 2 + start;
        int left = core(copy, array, start, mid)% 1000000007;
        int right = core(copy, array, mid + 1, end)% 1000000007;
        int count = 0;
        int copyindex = end;
        int i = mid;
        int j = end;

        while (i >= start && j >= mid + 1) {
            if (array[i] > array[j]) {
                count += j - mid;
                if(count>=1000000007)//数值过大求余
                {
                    count%=1000000007;
                }
                copy[copyindex--] = array[i];
                i--;
            } else {
                copy[copyindex--] = array[j];
                j--;
            }
        }
        for (; i >= start; i--) {
            copy[copyindex--] = array[i];
        }
        for (; j >= mid + 1; j--) {
            copy[copyindex--] = array[j];
        }
        return (left + right + count) % 1000000007;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 0};
        System.out.print(solution.InversePairs(arr));
    }
}