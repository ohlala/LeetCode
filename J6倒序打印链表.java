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
import java.util.Collections;  //要用的包自己导入
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<Integer>();   //构造函数和引用变量都要声明类型
        if (listNode == null)					//注意驼峰命名法
            return result;								//可以返回空的集合但是不能返回null  这是不一样的
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(listNode.val);
        while(listNode.next != null){
            listNode = listNode.next;
            stack.push(listNode.val);
        }
        result = new ArrayList<Integer>(stack);		//这个转换好了是从栈低到栈顶的 
        Collections.reverse(result);    // 用Collections的翻转函数
        return result;
    }
}