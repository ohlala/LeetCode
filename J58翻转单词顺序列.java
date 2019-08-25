import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static String ReverseSentence(String str) {
        String[] arr = str.split(" ");
        if (arr.length == 0)
            return str;
        Collections.reverse(Arrays.asList(arr));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length - 1; i++) {
            sb.append(arr[i]);
            sb.append(" ");
        }
        sb.append(arr[arr.length - 1]);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.print(ReverseSentence("    "));
    }
}