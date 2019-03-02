import java.util.Stack;

public class Solution {
		
		Stack<Integer> data = new Stack<>();
		Stack<Integer> min = new Stack<>();
		
    public void push(int node) {   //��һ������ĸ���ջ�����浱ǰ״̬�µ���Сֵ
        data.push(node);
        if (min.isEmpty()){
        		min.push(node);
        }else {
        		if (min.peek() > node) {
        		 		min.push(node);
        		}else{
        				min.push(min.peek());
        		}
        }
    }
    
    public void pop() {
    		min.pop();
    		data.pop();    
    }
    
    public int top() {
        return data.peek();
    }
    
    public int min() {
    		return min.peek();   
    }
}