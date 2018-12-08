public class Solution {
    public boolean Find(int target, int [][] array) {
        if (array == null)
            return false;
        int x = 0;
        int y = array[0].length - 1;   //数组的长度length不用加括号 注意边界条件
        while (x < array.length && y >= 0){   //注意边界条件
            if (array[x][y] == target)
                return true;
            else if (array[x][y] > target)
                y--;
            else 
                x++;
        }
        return false;
    }
}