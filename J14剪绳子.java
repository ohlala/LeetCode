public class Main { //�������ļ���Ҫһ��
    public static void main(String[] args) {
        Main result = new Main();  //Ҫ���������ʵ���ſ��Ե�����ķ���
        for (int i = 0; i < 10; i++) {
            System.out.println(result.dynamicProgramming(i));
        }
    }
    public int greedy(int length) {
        // ������  �Ҳ���
    }

    public int dynamicProgramming(int length) {
        if (length < 2)
            return 0;
        if (length == 2)
            return 2;
        if (length == 3)
            return 3;
        int[] result = new int[length + 1];
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;
        int max = 0;
        for (int i = 4; i <= length; i++) { //������߽�����
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                if (result[j] * result[i - j] > max) //������߽�����
                    max = result[j] * result[i - j];
            }
            result[i] = max;
        }
        return result[length];
    }
}
