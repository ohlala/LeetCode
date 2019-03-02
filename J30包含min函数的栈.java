import java.util.Stack;

public class Solution {
		
		Stack<Integer> data = new Stack<>();
		Stack<Integer> min = new Stack<>();
		
    public void push(int node) {   //用一个额外的辅助栈来保存当前状态下的最小值
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