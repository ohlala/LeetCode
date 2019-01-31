import java.util.ArrayList;

public class Main { //�������ļ���Ҫһ��
    public static void main(String[] args) {
        Main result = new Main();  //Ҫ���������ʵ���ſ��Ե�����ķ���
        int[] arr = {1, 2, 3, 4, 5};
        result.reOrderArray(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }

    public void reOrderArray(int[] array) {  //ʹ�ò��뷨��˼��
        int line = -1;
        int temp;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                temp = array[i];
                line++;
                for (int j = i; j > line; j--)
                    array[j] = array[j - 1];
                array[line] = temp;
            }
        }
    }

    public void reOrderArray2(int[] array) {       //ʹ�ø�����ARRARLIST
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0)
                even.add(array[i]);
            else
                odd.add(array[i]);
        }
        int i = 0;
        for (int j = 0; j < odd.size(); j++) {
            array[i] = odd.get(j);          //arraylist��ʵ����list�ӿڵ� ��get���� ����ʹ�� []����
            i++;
        }
        for (int j = 0; j < even.size(); j++) {
            array[i] = even.get(j);
            i++;
        }
    }
}
