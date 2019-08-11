import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for (int n = (int) Math.sqrt(2 * sum); n > 1; n--) {
            if ((sum % n) == 0 && (n & 1) == 1 || (sum % n) * 2 == n) {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int j = sum / n - (n - 1) / 2, k = 0; k < n; k++, j++) {
                    temp.add(j);
                }
                res.add(temp);
            }
        }
        return res;
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence1(int sum) {
        //��Ž��
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        //������㣬�൱�ڶ�̬���ڵ����ߣ������䴰���ڵ�ֵ�ĺ���ȷ�����ڵ�λ�úʹ�С
        int plow = 1, phigh = 2;
        while (phigh > plow) {
            //�����������ģ���Ϊ1��һ�����У���ô��͹�ʽ��(a0+an)*n/2
            int cur = (phigh + plow) * (phigh - plow + 1) / 2;
            //��ȣ���ô�ͽ����ڷ�Χ����������ӽ������
            if (cur == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = plow; i <= phigh; i++) {
                    list.add(i);
                }
                result.add(list);
                plow++;
                //�����ǰ�����ڵ�ֵ֮��С��sum����ô�ұߴ�������һ��
            } else if (cur < sum) {
                phigh++;
            } else {
                //�����ǰ�����ڵ�ֵ֮�ʹ���sum����ô��ߴ�������һ��
                plow++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print(FindContinuousSequence(100));
    }

}