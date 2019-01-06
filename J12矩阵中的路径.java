public class Main { //类名和文件名要一致
    public static void main(String[] args) {
        Main result = new Main();  //要先生成类的实例才可以调用类的方法
        System.out.println(result.hasPath("ABCESFCSADEE".toCharArray(),3,4,"ABCCED".toCharArray()));

    }
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        boolean[] flag = new boolean[matrix.length];
        if (matrix.length == 0 || str.length == 0)
            return false;
        for (int i = 0; i < matrix.length; i++){
            int j = 0;
            if (hasNext(flag, i, matrix, rows, cols, str, j) == true)
                return true;
        }
        return false;
    }
    public boolean hasNext(boolean[] flag, int index, char[] matrix, int rows, int cols, char[] str, int j)
    {
        if (j == str.length)  //str 的长度和 matrix的长度是不一样的 需要两个不同的索引 写判断条件的时候注意区分
            return true;
        if (index < 0 || index >= matrix.length || matrix[index] != str[j] || flag[index] == true)
            return false;
        flag[index] = true;
        int r = index / cols;
        int c = index % cols;
        if (hasNext(flag, r*cols+(c+1), matrix, rows, cols, str, j+1) ||
            hasNext(flag, r*cols+(c-1), matrix, rows, cols, str, j+1) ||
            hasNext(flag, (r-1)*cols+c, matrix, rows, cols, str, j+1) ||
            hasNext(flag, (r+1)*cols+c, matrix, rows, cols, str, j+1) ) //递归可以一下写四个判断
            return true;
        flag[index] = false;
        return false;
    }
}
