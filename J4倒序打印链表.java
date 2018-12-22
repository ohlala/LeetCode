/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
import java.util.Stack;
import java.util.Collections;  //Ҫ�õİ��Լ�����
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<Integer>();   //���캯�������ñ�����Ҫ��������
        if (listNode == null)					//ע���շ�������
            return result;								//���Է��ؿյļ��ϵ��ǲ��ܷ���null  ���ǲ�һ����
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(listNode.val);
        while(listNode.next != null){
            listNode = listNode.next;
            stack.push(listNode.val);
        }
        result = new ArrayList<Integer>(stack);		//���ת�������Ǵ�ջ�͵�ջ���� 
        Collections.reverse(result);    // ��Collections�ķ�ת����
        return result;
    }
}