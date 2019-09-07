import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*������������������ʵ����ĿҪ��Ĺ���
     ******************************��ʼд����******************************/
    static ListNode partition(ListNode head, int m) {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        ListNode temp = head;
        while (head != null){
            if(head.val < m){
                list1.add(head.val);
            }else {
                list2.add(head.val);
            }
            head= head.next;
        }
        head = temp;
        for(int i = 0; i < list1.size();i++){
            head.val = list1.get(i);
            head = head.next;
        }
        for(int i = 0; i < list2.size();i++){
            head.val = list2.get(i);
            head = head.next;
        }
        return temp;
    }

    /******************************����д����******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ListNode head = null;
        ListNode node = null;
        int m = in.nextInt();
        while (in.hasNextInt()) {
            int v = in.nextInt();
            if (head == null) {
                node = new ListNode(v);
                head = node;
            } else {
                node.next = new ListNode(v);
                node = node.next;
            }
        }
        
        head = partition(head, m);
        if (head != null) {
            System.out.print(head.val);
            head = head.next;
            while (head != null) {
                System.out.print(",");
                System.out.print(head.val);
                head = head.next;
            }
        }
        System.out.println();
    }
}
