public class Main { //�������ļ���Ҫһ��
    public static void main(String[] args) {
        Main result = new Main();  //Ҫ���������ʵ���ſ��Ե�����ķ���
        char[] str = {'a', 'a', 'a'};
        char[] pat = {'a', 'b', '*', 'a', 'c', '*', 'a'};
        System.out.println(result.match(str, pat));
    }

    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        int strIndex = 0;
        int pattrenIndex = 0;
        return matchCore(str, strIndex, pattern, pattrenIndex);
    }

    public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        if (strIndex == str.length && patternIndex == pattern.length) { //����������ͷ
            return true;
        }
        if (strIndex != str.length && patternIndex == pattern.length) { //ģʽ�ȵ���ͷ���ַ���û��ƥ����
            return false;
        }
        if (strIndex == str.length && patternIndex != pattern.length) { //�ַ����ȵ���ͷ��ģʽ���Լ���ƥ��0������
            if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*')
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            return false;
        }
        //��û����ͷ��һ������£������һλ��ͨ���
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            //ǰһλ����ƥ�������������ƥ�� 0 1 ���߶��
            if (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.')
                return (matchCore(str, strIndex, pattern, patternIndex + 2) || 				//0��
                        matchCore(str, strIndex + 1, pattern, patternIndex + 2) ||		//1��(������0���Ͷ�����)
                        matchCore(str, strIndex + 1, pattern, patternIndex));					//���
            //ǰһλ������ƥ��������ֻ����ƥ�� 0 ��
            else
                return matchCore(str, strIndex, pattern, patternIndex + 2);					
        }
        //��û����ͷ��һ������£������һλ�ǲ�ͨ������ж�ƥ��ƥ�䣬��ƥ���򷵻�false
        if (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.') {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }
}
