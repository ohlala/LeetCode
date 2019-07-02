public class Solution {
    public static class ListNode<T> {
        T val;
        ListNode next = null;

        ListNode(T val) {
            this.val = val;
        }
    }

    public static ListNode<Integer> findFirstCommonNode3(ListNode<Integer> pHead1, ListNode<Integer> pHead2) {
        int len1 = 0, len2 = 0;
        ListNode head1 = pHead1;
        ListNode head2 = pHead2;
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        while (head1.next != null) {
            head1 = head1.next;
            len1++;
        }
        while (head2.next != null) {
            head2 = head2.next;
            len2++;
        }
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                pHead1 = pHead1.next;
            }
        } else {
            for (int i = 0; i < len2 - len1; i++) {
                pHead2 = pHead2.next;
            }
        }
        while (pHead1 != null) {
            if (pHead1.val == pHead2.val) {
                return pHead1;
            }
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        // 1->2->3->6->7
        //    4->5¨J
        ListNode<Integer> node1 = new ListNode<>(1);
        ListNode<Integer> node2 = new ListNode<>(2);
        ListNode<Integer> node3 = new ListNode<>(3);
        ListNode<Integer> node4 = new ListNode<>(4);
        ListNode<Integer> node5 = new ListNode<>(5);
        ListNode<Integer> node6 = new ListNode<>(6);
        ListNode<Integer> node7 = new ListNode<>(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node6;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode<Integer> commonNode3 = findFirstCommonNode3(node1, node4);
        System.out.println(commonNode3.val);
    }
}
