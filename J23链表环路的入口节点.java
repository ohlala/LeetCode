/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode meetingNode = MeetingNode(pHead);
        if (meetingNode == null)
        		return null;
        ListNode temp = meetingNode.next; //计算环路的长度
        int loopLength = 1;
        while (temp != meetingNode){
        		temp = temp.next;
        		loopLength += 1;
        }
        
        ListNode before = pHead;
        ListNode entry = pHead;		//一个快的引用领先慢的引用环路的长度，相遇的点就是入口
       	for (int i = 0; i < loopLength; i++){
       			before = before.next;
       	}
       	while(entry != before){
       			before = before.next;
       			entry = entry.next;
       	}
       	return entry;
    }
    
    //首先使用一快一慢两个引用判断两个是否存在环路,返回他们相遇的点
    public ListNode MeetingNode(ListNode pHead){
    		if (pHead == null)
    				return null;
     		ListNode slow = pHead.next;
    		if (slow == null)
    				return null;
    		ListNode fast = slow.next;
    		while(fast != null && slow != null){
    				if (fast == slow)
    						return fast;
    				slow = slow.next;
    				fast = fast.next;
    				if (fast != null)
    						fast = fast.next;
    		}
    		return null;
    }
}