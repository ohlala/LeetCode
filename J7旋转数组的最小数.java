import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0){
            return 0;
        }
        return find(array, 0, array.length - 1); 
    }
    
         public int find(int [] array, int begin, int end){
    			//剑指offer写法 循环 中间有特殊情况的判断
    			while (begin < end){
    			    if (end - begin == 1)
    			    		return array[end];
    			    int mid = (begin + end) / 2;
    			    //要考虑｛1，0，1，1，1｝ 和 ｛1，1， 1，0，1｝这种特殊情况
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
					//自己的写法 递归 应该是错的 没有办法解决｛1，1， 1，0，1｝ 测试用例没有
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