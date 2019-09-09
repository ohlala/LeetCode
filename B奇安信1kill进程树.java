import java.util.*;

//3 1 5 21 10
//0 3 3 1 5
//5
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String te = in.nextLine();
        String[] child = te.split(" ");
        te = in.nextLine();
        String[] father = te.split(" ");
        String n = in.next();
        HashSet<String> set = new HashSet(Arrays.asList(child));
        if (!set.contains(n)){
            System.out.println(0);
            return;
        }
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        for (int i = 0; i < father.length; i++) {
            if (hashMap.containsKey(father[i])) {
                hashMap.get(father[i]).add(child[i]);
            } else {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(child[i]);
                hashMap.put(father[i], temp);
            }
        }
        int res = 0;
        LinkedList<String> que = new LinkedList<>();
        que.add(n);
        while (que.size() != 0) {
            String cur = que.pollFirst();
            res ++;
            if (hashMap.containsKey(cur)) {
                for(String str : hashMap.get(cur)){
                    que.add(str);
                }
            }
        }
        System.out.println(res);
    }

}