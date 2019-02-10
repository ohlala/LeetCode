/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode ReverseList(ListNode head) {
				if (head == null)
						return null;
				if (head.next == null)
						return head;
						
				ListNode preNode = head;		
				ListNode node = head.next;						
				head.next = null;											//头结点指向空
				
				while (node != null){
						ListNode nextNode = node.next;		//用变量的时候要声明啊
						node.next = preNode;
						
						preNode = node;
						node = nextNode;
				}
				return preNode;
    }
}