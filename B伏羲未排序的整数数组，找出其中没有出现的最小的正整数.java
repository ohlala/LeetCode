//未排序的整数数组，找出其中没有出现的最小的正整数
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int[] arr1 =  {1, 2 ,0};  // 3
        System.out.println(lowest(arr1));
        int[] arr2 =  {3, 4 ,-1, 1};  // 2
        System.out.println(lowest(arr2));
        int[] arr3 =  {7, 8 ,9, 11, 12}; // 1
        System.out.println(lowest(arr3));
        int[] arr4 =  {-1, 0 ,1,4, 11, 12}; // 2
        System.out.println(lowest(arr4));
    }
    public static int lowest(int[] arr){
        HashSet<Integer> hashSet = new HashSet<>();
        for(int number : arr){
            if (number > 0)
                hashSet.add(number);
        }
        for (int i = 1; i <= arr.length + 1; i++){
            if(!hashSet.contains(i))
                return i;
        }
        return -1;
    }
    public static int lowest1(int[] arr){
        Arrays.sort(arr);
        int result = -1;
        if (arr[0] > 1){
            result = 1;
        }else{
            for (int i = 1; i < arr.length; i++){
                if (arr[i - 1] >= 0 && arr[i - 1] != arr[i] - 1){
                    result = arr[i - 1] + 1;
                    break;
                }
            }
            if (result == -1)
                result = arr[arr.length -1 ] + 1;
        }
        return result;
    }
}