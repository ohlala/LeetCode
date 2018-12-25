import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0){
            return 0;
        }
        return array[find(array, 0, array.length - 1)]; 
    }
    
    public int find(int [] array, int begin, int end){
        int mid = (begin + end) / 2;
        if (begin >= end)
            return end;
        if (array[begin] < array[end]){
            return begin;
        }else if (array[mid] > array[end]){
            return find(array, mid+1, end);
        }else {
//            (array[mid] < array[begin]
            return find(array, begin+1, mid);
        }
        
    }
}