//��Ŀ����
//����һ���ַ������ַ����������֡���Сд��ĸ�Լ����ţ����������ţ������ţ�С���ţ������ſ���Ƕ�ף�������������Գ������ֺ����š�
//�������¹�����ַ�������չ��������Ҫ�������Ų��ɶԵ����⣬���������ֺ���û�����ŵ�������� 2a2(b)�����ǡ�
//���ֱ�ʾ��������ַ����ظ��Ĵ�����չ������ַ�������������
//���ַ�����������չ��
//����abc2{de3[fg]}
//���gfgfgfedgfgfgfedcba
//�ⷨ
//����ջ���м��㣬ÿ���жϴ�ʱ�Ƿ��������ţ�����ǵĻ����õ���Ӧ��������֮ǰ�������ַ������õ���Ӧ�����ŵ����֣����ַ������ظ��Ժ�ȫ����ջ��
//
//������������ţ���ôֱ����ջ��
import java.util.LinkedList;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int len = line.length();
        LinkedList<String> stack1 = new LinkedList<>();
 
        //����abc2{de3[fg]}
        //���gfgfgfedgfgfgfedcba
        for (int i = 0; i < len; i++) {
            String temp = line.charAt(i) + "";
            if (")]}".contains(temp)) {
 
                //�õ���һ��������֮ǰ����ĸ
                StringBuilder dup = new StringBuilder();
                while (!"({[".contains(stack1.getFirst())) {
                    dup.insert(0,stack1.removeFirst());
                }
                stack1.removeFirst();
 
                //ע���ʱ�Ŀӣ���Ϊ���ֿ����Ƕ�λ���������Ҫ�õ����е�����
                StringBuilder numStr = new StringBuilder();
                while (!stack1.isEmpty() && stack1.getFirst().matches("[0-9]")) {
                    numStr.insert(0, stack1.removeFirst());
                }
                int num = Integer.parseInt(numStr.toString());
 
                //����(ǰ�����ֽ����ظ��������ٴ�ѹ��ջ
                StringBuilder str = new StringBuilder();
                while (num > 0) {
                    str.append(dup);
                    --num;
                }
                for (int k = 0; k < str.length(); k++) {
                    stack1.addFirst(str.charAt(k) + "");
                }
            } else {
                stack1.addFirst(temp);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack1.isEmpty()) {
            result.append(stack1.removeFirst());
        }
        System.out.println(result.toString());
    }
}