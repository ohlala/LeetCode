public class Main { //�������ļ���Ҫһ��
    public static void main(String[] args) {
        Main result = new Main();  //Ҫ���������ʵ���ſ��Ե�����ķ���
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
        if (j == str.length)  //str �ĳ��Ⱥ� matrix�ĳ����ǲ�һ���� ��Ҫ������ͬ������ д�ж�������ʱ��ע������
            return true;
        if (index < 0 || index >= matrix.length || matrix[index] != str[j] || flag[index] == true)
            return false;
        flag[index] = true;
        int r = index / cols;
        int c = index % cols;
        if (hasNext(flag, r*cols+(c+1), matrix, rows, cols, str, j+1) ||
            hasNext(flag, r*cols+(c-1), matrix, rows, cols, str, j+1) ||
            hasNext(flag, (r-1)*cols+c, matrix, rows, cols, str, j+1) ||
            hasNext(flag, (r+1)*cols+c, matrix, rows, cols, str, j+1) ) //�ݹ����һ��д�ĸ��ж�
            return true;
        flag[index] = false;
        return false;
    }
}
