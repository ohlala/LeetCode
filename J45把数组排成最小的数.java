import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String PrintMinNumber(int[] numbers) {
        String[] strs = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strs[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                for (int i = 0; i < s1.length() || i < s2.length(); i++) {
                    if (i >= s1.length()) {
                        if (s1.charAt(s1.length() - 1) > s2.charAt(i))
                            return 1;
                        else if (s1.charAt(s1.length() - 1) < s2.charAt(i))
                            return -1;
                    } else if (i >= s2.length()) {
                        if (s2.charAt(s2.length() - 1) > s1.charAt(i))
                            return -1;
                        else if (s2.charAt(s2.length() - 1) < s1.charAt(i))
                            return 1;
                    } else if (s2.charAt(i) > s1.charAt(i))
                        return -1;
                    else if ((s2.charAt(i) < s1.charAt(i)))
                        return 1;
                }
                return 0;
            }

        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            sb.append(strs[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] arr = {3334, 3, 3333332};
        Solution solution = new Solution();
        System.out.print(solution.PrintMinNumber(arr));
    }
}