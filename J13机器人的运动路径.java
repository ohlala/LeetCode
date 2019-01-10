import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Solution1 right = new Solution1();
        System.out.println(right.movingCount(15,20,20));
        Solution mine = new Solution();
        System.out.println(mine.movingCount(15,20,20));
        System.out.println(mine.movingCountDFS(15,20,20));
    }

    public int movingCount(int threshold, int rows, int cols)
    {
        if (rows == 0 && cols == 0){ return 0; }
        boolean[] flag = new boolean[rows*cols];
        Queue<Integer> qu = new LinkedList<Integer>();
        qu.add(0);
        int count = 1;
        flag[0] = true;
        //0在循环外处理 在这里修改 count和flag的值 进入循环就直接判断他的邻接点了
        while(!qu.isEmpty()){
            int i = qu.poll();
            int r = i / cols;
            int c = i % cols;
            if (Count(threshold, rows, cols, r + 1, c, flag)){ qu.add((r+1)*cols); flag[(r+1)*cols] = true; count++;}
            if (Count(threshold, rows, cols, r - 1, c, flag)){ qu.add((r-1)*cols); flag[(r-1)*cols] = true; count++;}
            if (Count(threshold, rows, cols, r, c + 1, flag)){ qu.add(r*cols+c+1); flag[r*cols+c+1] = true; count++;}
            if (Count(threshold, rows, cols, r, c - 1, flag)){ qu.add(r*cols+c-1); flag[r*cols+c-1] = true; count++;}
        }
        return count;
    }

    public boolean Count(int threshold, int rows, int cols, int r, int c, boolean[] flag){
        if (r >= rows || r < 0 || c >= cols || c < 0|| flag[r*cols+c])
            return false;
        int sum = 0, tr = r, tc = c;
        while (tr> 0) {sum += tr % 10; tr /= 10;}
        while (tc> 0) {sum += tc % 10; tc /= 10;}
        if (sum <= threshold)
            return true;
        return false;
    }
    public int movingCountDFS(int threshold, int rows, int cols)
    {
        if (rows == 0 && cols == 0){ return 0; }
        boolean[] flag = new boolean[rows*cols];
        int r = 0 / cols;
        int c = 0 % cols;
        int count = 0;
        //包括0在内的所有点都是在CountDFS里面判断是否正确的 所以count和flag都要在CountDFS里面处理 这里不动
        return CountDFS(threshold, rows, cols, r , c, flag, count);
    }


    public int CountDFS(int threshold, int rows, int cols, int r, int c, boolean[] flag, int count){
        if (r >= rows || r < 0 || c >= cols || c < 0|| flag[r*cols+c])
            return count;
        int sum = 0, tr = r, tc = c;
        while (tr> 0) {sum += tr % 10; tr /= 10;}
        while (tc> 0) {sum += tc % 10; tc /= 10;}
        if (sum > threshold)
            return count;
        flag[r*cols+c] = true;
        count++;
        count = CountDFS(threshold, rows, cols, r - 1, c, flag, count);
        count = CountDFS(threshold, rows, cols, r + 1, c, flag, count);
        count = CountDFS(threshold, rows, cols, r, c - 1, flag, count);
        count = CountDFS(threshold, rows, cols, r, c + 1, flag, count);
        return count;
    }

}