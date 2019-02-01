public class Main { //类名和文件名要一致
    public static void main(String[] args) {
        Main result = new Main();  //要先生成类的实例才可以调用类的方法
        int[] arr = {1, 1, 1, 1, 1};
        ListNode head = new ListNode(1);
        ListNode before = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode temp = new ListNode(arr[i]);
            before.next = temp;
            before = before.next;
        }

        head = result.deleteDuplication(head);
        for (ListNode i = head; i != null; i = i.next)
            System.out.println(i.val);
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;
        while (pHead.next != null && pHead.next.val == pHead.val) {
            ListNode before = pHead;
            while (before.next != null && before.next.val == before.val) {
                before = before.next;
            }
            pHead = before.next;
            if (pHead == null || pHead.next == null)
                return pHead;
        }
        ListNode before = pHead;
        ListNode next = before.next;
        while (next != null) {
            int flag = 0;
            while (next.next != null && next.next.val == next.val) {
                next = next.next;
                flag = 1;
            }
            if (flag == 1) {
                before.next = next.next;
                next = before.next;
            } else {
                before = before.next;
                next = before.next;
            }
        }
        return pHead;
    }
}
