import static java.lang.Math.pow;

public class Solution {
    //21345Ϊ��
    public int NumberOf1Between1AndN_Solution(int n) {
        String strn = String.valueOf(n);
        return core(strn);
    }

    public int core(String strn) {
    		//����ʹ��valueOf(strn.charAt()); ������ֵ���ascll��
        int charat0 = Integer.valueOf(strn.substring(0,1));
        if (strn.length() == 1)
            return charat0 == 0 ? 0 : 1;
        //��Ϊ�����ּ��� ��һλ 1346-21345  ���� 1356-11345 ��Ϊ������� ������10000���������������Ŀ���������ţ�
        int first = charat0 > 1 ? (int) pow(10, strn.length() - 1) : ((charat0 >= 1 ? 1 : 0) + Integer.valueOf(strn.substring(1)));
        //�ڶ�����Ϊ ��ȥ���λ���� ʣ�µļ�λ ѡһ��Ϊ1(Cn1)����10��n�η�
        int other = (charat0 - 0) * (strn.length() - 1) * (int) pow(10, strn.length() - 2);
        //��������Ϊ �ݹ鴦�� 0-1345����
        return first + other + core(strn.substring(1));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.NumberOf1Between1AndN_Solution(21345));
    }
}