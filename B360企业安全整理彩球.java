/*
整理彩球
        时间限制：C/C++语言 1000MS；其他语言 3000MS
        内存限制：C/C++语言 65536KB；其他语言 589824KB
        题目描述：
        小明家有一些彩球，一段时间后小明玩耍时将它们无序的散落在家中，一天，小明想对其进行整理，规则为一个篮子中只放一种颜色彩球，可有多个篮子放同一颜色的球，每个篮子里的球不少于2个。假设小明整理好后，能使各篮子中彩球数量是相同的，则认为小明整理好了。用一个数字表示一种颜色彩球，一组数表示小明已经找到了的彩球，问小明用找到的全部彩球能按规则整理好么？
        输入
        第一行彩球总数: n,  2<n<10000
        第二行一段整数ai,  1<ai<10000  (排除ai全部相等的情况)
        输出
        若能整理好，最小篮子数；否则0
        样例输入
        6
        1 1 2 2 2 2
        样例输出
        3

        提示
        样例输入:
        6
        1 1 2 2 2 2
        样例输出:
        3      	tip: [1, 1] [2, 2] [2, 2]
        样例输入:
        5
        1 1 1 2 2
        样例输出:
        0     		tip: [1 1 1] [2 2]

        样例输入:
        6
        1 1 1 2 2 2
        样例输出:
        2      	tip: [1 1 1] [2 2 2]
*/

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0 ; i < n; i ++){
            int temp = in.nextInt();
            map.putIfAbsent(temp, 0);
            map.put(temp, map.get(temp)+1);
        }
        ArrayList<Integer> arrval = new ArrayList<>(map.values());
        int count = mgcd(arrval);
        if (count > 1){
            for(int i : arrval){
                res += i / count;
            }
        }
        System.out.println(String.valueOf(res));

    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static int mgcd(ArrayList<Integer> a) {

        int count = 0;
        if (a.size() == 2)
            return gcd(a.get(0), a.get(1));
        for (int i = 2; i < a.size(); i++) {
            count = gcd(gcd(a.get(i - 2), a.get(i-1)), a.get(i));
        }
        return count;
    }
}
