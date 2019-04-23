import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        ArrayList<Integer> zhong = new ArrayList<>();
        ArrayList<Integer> bian = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i + j) % 2 == 0)
                    zhong.add(in.nextInt());
                else
                    bian.add(in.nextInt());
            }
        }

        zhong.add(Integer.MAX_VALUE);
        bian.add(Integer.MAX_VALUE);
        TreeMap<Integer, Integer> zhongtree = count(zhong);
        TreeMap<Integer, Integer> biantree = count(bian);
        Collection<Integer> count = zhongtree.values();
        ArrayList<Integer> lista = new ArrayList<>();
        lista.addAll(count);
        Collection<Integer> countb = biantree.values();
        ArrayList<Integer> listb = new ArrayList<>();
        listb.addAll(countb);

        Collections.sort(lista);
        Collections.sort(listb);
        Collections.reverse(lista);
        Collections.reverse(listb);

        int av = lista.get(0);
        int bv = listb.get(0);
        int a = 0;
        int b = 0;
        for(Map.Entry<Integer, Integer> entry : zhongtree.entrySet())
        {
            if(entry.getValue() == av)
            {
                a = entry.getKey();
                break;
            }
        }
        for(Map.Entry<Integer, Integer> entry : biantree.entrySet())
        {
            if(entry.getValue() == bv)
            {
                b = entry.getKey();
                break;
            }
        }

        if (a != b) {
            System.out.print(zhong.size() + bian.size() - av - bv - 2);
        } else {
            if ((zhong.size() - av) >= (bian.size() - bv)) {
                av = lista.get(1);
                for(Map.Entry<Integer, Integer> entry : zhongtree.entrySet())
                {
                    if(entry.getValue() == av)
                    {
                        a = entry.getKey();
                        break;
                    }
                }
                if (a == Integer.MAX_VALUE){
                    System.out.print(zhong.size() + bian.size() - bv -2);
                }else{
                    System.out.print(zhong.size() + bian.size() - av - bv -2);
                }

            }else{
                bv = listb.get(1);
                for(Map.Entry<Integer, Integer> entry : biantree.entrySet())
                {
                    if(entry.getValue() == bv)
                    {
                        b = entry.getKey();
                        break;
                    }
                }
                if (b == Integer.MAX_VALUE){
                    System.out.print(zhong.size() + bian.size() -2 - av);
                }else{
                    System.out.print(zhong.size() + bian.size() - av - bv -2);
                }
            }
        }
    }

    public static TreeMap<Integer, Integer> count(ArrayList<Integer> array) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

        for (int i = 0; i < array.size(); i++) {
            if (map.containsKey(array.get(i))) {
                int oldValue = map.get(array.get(i));
                map.put(array.get(i), oldValue + 1);
            } else {
                map.put(array.get(i), 1);
            }
        }
        return map;
    }

}

