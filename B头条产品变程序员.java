import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer[]> arr = new ArrayList<>();

        while (in.hasNextLine()) {
            String input = in.nextLine();
            if (input.equals(""))
                break;
            String temp[] = input.split(" ");
            Integer[] line = new Integer[temp.length];
            for (int i = 0; i < temp.length; i++) {
                line[i] = Integer.valueOf(temp[i]);
            }
            arr.add(line);
        }

        int res = 0;
        int row = arr.size();
        int col = arr.get(0).length;
        LinkedList<Integer> que = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr.get(i)[j] == 1) {
                    if ((j - 1) >= 0 && arr.get(i)[j - 1] != 0)
                        continue;
                    if ((j + 1) < col && arr.get(i)[j + 1] != 0)
                        continue;
                    if ((i + 1) < row && arr.get(i + 1)[j] != 0)
                        continue;
                    if ((i - 1) >= 0 && arr.get(i - 1)[j] != 0)
                        continue;
                    System.out.println(-1);
                    return;
                }
                if (arr.get(i)[j] == 2) {
                    que.add(i * col + j);
                }
            }
        }
        que.add(-1);
//        for (Integer[] i : arr) {
//            for (Integer j : i) {
//                System.out.print(j + " ");
//            }
//            System.out.println();
//        }

        while (que.size() > 1) {
            int index = que.removeFirst();
            int i, j;
            if (index == -1) {
                res += 1;
                que.add(-1);
                continue;
            } else {
                i = index / col;
                j = index % col;
            }
            if ((j - 1) >= 0 && arr.get(i)[j - 1] == 1) {
                arr.get(i)[j - 1] = 2;
                que.add((i) * col + j - 1);
            }
            if ((j + 1) < col && arr.get(i)[j + 1] == 1) {
                arr.get(i)[j + 1] = 2;
                que.add((i) * col + j + 1);
            }
            if ((i + 1) < row && arr.get(i + 1)[j] == 1) {
                arr.get(i + 1)[j] = 2;
                que.add((i + 1) * col + j);
            }
            if ((i - 1) >= 0 && arr.get(i - 1)[j] == 1) {
                arr.get(i - 1)[j] = 2;
                que.add((i - 1) * col + j);
            }
        }
        System.out.println(res);


    }
}
