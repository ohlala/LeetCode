/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null) 
        		return null;
        if (k == 0)    //k为0时没有意义
        		return null;
        		
        ListNode before = head;
        ListNode result = head;
        
        int count = 0;
        for (int i = 0; i < k - 1; i++){   //k 小于链表长度时没有意义
        		if (before.next != null)
        				before = before.next;
        		else 
        				return null;
        }
        while (before.next != null){
        		before = before.next;
        		result = result.next;
        }
        return result;
    }
}