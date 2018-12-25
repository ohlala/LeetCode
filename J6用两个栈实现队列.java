import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
        //出队：判断栈B是否为空，如果为空，则将栈A中所有元素pop，并push进栈B，栈B出栈； 如果不为空，栈B直接出栈。
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