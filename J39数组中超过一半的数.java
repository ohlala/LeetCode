 public class Main {

    public static int MoreThanHalfNum(int[] array) { //partation
        int mid = array.length / 2;
        int res = findKth(array, 0, array.length - 1, mid);
        int len = array.length;
        int count = 0;      //还是要检查一遍是不是满足条件
        for (int i = 0; i < len; i++) {
            if (array[i] == res)
                count++;
        }
        if (count <= len / 2)
            res = 0;
        return res;
    }

    public static int findKth(int[] array, int begin, int end, int k) {
        if (begin >= end)
            return array[begin];
        int i = begin - 1;
        int p = begin;
        while (p != end) {
            if (array[p] < array[end]) {
                i++;
                int temp = array[p];
                array[p] = array[i];
                array[i] = temp;
            }
            p++;
        }
        int temp = array[end];
        array[end] = array[i + 1];
        array[i + 1] = temp;
        if (i + 1 - begin + 1 == k)
            return array[i + 1];
        else if (i + 1 - begin + 1 > k)
            return findKth(array, begin, i, k);
        else
            return findKth(array, i + 2, end, k - (i + 1 - begin + 1));
    }

    public static int MoreThanHalfNum_Solution(int[] array) {  //线性查找然后检查
        int len = array.length;
        int res = array[0];
        int count = 1;
        for (int i = 0; i < len; i++) {
            if (count <= 0)
                res = array[i];
            if (array[i] == res) {
                count += 1;
            } else {
                count -= 1;
            }
        }
        count = 0;      //还是要检查一遍是不是满足条件
        for (int i = 0; i < len; i++) {
            if (array[i] == res)
                count++;
        }
        if (count <= len / 2)
            res = 0;
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int res = MoreThanHalfNum(arr);
        System.out.print(res);
    }
}

