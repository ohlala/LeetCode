import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0){
            return 0;
        }
        return find(array, 0, array.length - 1); 
    }
    
         public int find(int [] array, int begin, int end){
    			//��ָofferд�� ѭ�� �м�������������ж�
    			while (begin < end){
    			    if (end - begin == 1)
    			    		return array[end];
    			    int mid = (begin + end) / 2;
    			    //Ҫ���ǣ�1��0��1��1��1�� �� ��1��1�� 1��0��1�������������
    			    if (array[mid] == array[begin] && array[mid] == array[end]){
    			    		int min = array[begin];
    			    		for (int i = begin; i <= end; i++) {
    			    		 	 if (array[i] < min)
    			    		 	 		return array[i];
    			    		}
    			    }
    			    if (array[mid] > array[end])
    			    	  begin = mid;
    			    else if (array[mid] < array[begin])
    			    		end = mid;
    			}
             return array[begin];
         }
					//�Լ���д�� �ݹ� Ӧ���Ǵ�� û�а취�����1��1�� 1��0��1�� ��������û��
//        int mid = (begin + end) / 2;
//        if (begin >= end)
//            return end;
//        if (array[begin] < array[end]){
//            return begin;
//        }else if (array[mid] > array[end]){
//            return find(array, mid+1, end);
//        }else {
//            //(array[mid] < array[begin]
//            return find(array, begin+1, mid);
//        }
}