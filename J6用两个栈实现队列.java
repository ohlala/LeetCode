import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
        //���ӣ��ж�ջB�Ƿ�Ϊ�գ����Ϊ�գ���ջA������Ԫ��pop����push��ջB��ջB��ջ�� �����Ϊ�գ�ջBֱ�ӳ�ջ��
        if (stack2.isEmpty()){
            while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
        //while(!stack1.isEmpty()){
        //    stack2.push(stack1.pop());
        //}
        //int result = stack2.pop();
        //while(!stack2.isEmpty()){
        //    stack1.push(stack2.pop());
        //}
        //return result;
    }
}