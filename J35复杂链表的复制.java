/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;
    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
				if (pHead == null)
					return null;
        CloneNext(pHead);  
        CloneRandom(pHead);
        return SplitNode(pHead);
    }
    
    public void CloneNext(RandomListNode pHead)
    {
    		while (pHead != null){
    				RandomListNode newNode = new RandomListNode(pHead.label);    
    				newNode.next = pHead.next;
    				pHead.next = newNode;
    				pHead = newNode.next;
    		}
    }
    
    public void CloneRandom(RandomListNode pHead)
    {
        while (pHead != null){
        		RandomListNode newNode = pHead.next;
        		if (pHead.random != null){
        				newNode.random = pHead.random.next;
        		}
        		pHead = newNode.next;
        }
    }
    public RandomListNode SplitNode(RandomListNode pHead)
    {
        RandomListNode newHead = pHead.next;
        while (pHead != null){
        		RandomListNode newNode = pHead.next;
        		pHead.next = newNode.next;
        		if (newNode.next != null){
        				newNode.next = newNode.next.next; // !!!!
        		}
        		pHead = pHead.next;
        }
        return newHead;
    }
}