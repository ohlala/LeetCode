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
				head.next = null;											//ͷ���ָ���
				
				while (node != null){
						ListNode nextNode = node.next;		//�ñ�����ʱ��Ҫ������
						node.next = preNode;
						
						preNode = node;
						node = nextNode;
				}
				return preNode;
    }
}