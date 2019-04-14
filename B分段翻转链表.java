import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static class Node {
        int val;
        Node next = null;

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int n = in.nextInt();

        str = str.substring(1, str.length() - 1);
        String[] val = str.split(",");

        Node head = null;
        for (int i = val.length - 1; i >= 0; i--) {
            head = new Node(Integer.valueOf(val[i]), head);
        }

        Node temp = head;
        int firstflag = 0;
        Node preend = null;

        ArrayList<Node> arr = new ArrayList<>(n);
        while (temp != null) {
            arr.add(temp);
            if (arr.size() == n) {
                temp = arr.get(n-1).next;
                arr.get(0).next = temp;
                if (firstflag == 0)
                    head = arr.get(n-1);
                if (firstflag != 0)
                    preend.next = arr.get(n-1);
                firstflag = 1;
                preend = arr.get(0);
                for (int i = n-1; i > 0; i--) {
                    arr.get(i).next = arr.get(i-1);
                }
                arr.clear();
                continue;
            }
            if (temp.next == null)
                break;
            temp=temp.next;
        }
        while (head.next != null) {
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println(head.val);
    }
}

