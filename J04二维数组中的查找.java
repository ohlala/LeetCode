public class Solution {
    public boolean Find(int target, int [][] array) {
        if (array == null)
            return false;
        int x = 0;
        int y = array[0].length - 1;   //����ĳ���length���ü����� ע��߽�����
        while (x < array.length && y >= 0){   //ע��߽�����
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