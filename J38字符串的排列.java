import java.util.*;
public class Solution {
       public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str != null){
            Permutation(result, str.toCharArray(), 0);
            TreeSet<String> set = new TreeSet<>(result);
            result = new ArrayList<>(set);
            //去重
        }
        return result;
    }

    public void Permutation(ArrayList<String> result, char[] str, int index) {
        if (index + 1 == str.length){
            result.add(String.valueOf(str));
            //result.add(new String(str));
            return;
        }
        for (int i = index; i < str.length; i++){
            swap(str, index, i);
            Permutation(result, str, index+1);   //这里是到下一层去 index表示的是层数
            swap(str, index, i);
        }
    }

    private void swap(char[] cs, int i, int j){
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}