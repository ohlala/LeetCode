public class Main { //�������ļ���Ҫһ��
    public static void main(String[] args) {
        Main result = new Main();  //Ҫ���������ʵ���ſ��Ե�����ķ���
        char[] pat = {'3', '.', '4', 'e', '+', '6', '7'};
        char[] pa = {'1', '0', '0'};
        System.out.println(result.isNumeric(pa));
    }

    private int index = 0;

    public boolean isNumeric(char[] str) {
        if (str.length < 1)
            return false;
        boolean flag = scanInt(str);
        if (index < str.length && str[index] == '.'){ //�ڷ���index��ʱ��Ҫ��������Խ����ж�
            index++;
            flag = scanUnsignedInt(str) || flag;       //��'.'�Ĵ��ڲ���Ҫ�жϺ�����û���޷�������
        }
        //�ڷ���index��ʱ��Ҫ��������Խ����жϣ�������ж�����Ҫ��������
        if (index < str.length && (str[index] == 'e' || str[index] == 'E')){
            index++;
            flag = scanInt(str) && flag;                //��'e����E'�Ĵ��ڲ���Ҫ�жϺ�����û������
        }
        return flag && index == str.length;            //��ɲ��ֹ�����&& ��û�е�ͷ����û��ͣ����ֵĵط���
    }

    public boolean scanInt(char[] str) {
        if (index < str.length && (str[index] == '-' || str[index] == '+'))  //�ڷ���index��ʱ��Ҫ��������Խ����ж�
            index++;
        return scanUnsignedInt(str);
    }

    public boolean scanUnsignedInt(char[] str) {
        int start = index;
        while (index < str.length && (str[index] <= '9' && str[index] >= '0'))  //�ڷ���index��ʱ��Ҫ��������Խ����ж�
            index++;
        return start < index;
    }
}
