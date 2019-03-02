import java.util.ArrayList;
import java.util.Stack;
 
public class Solution { 
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (popA.length == 0)
        		return false;
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < popA.length;){
        		stack.push(pushA[i++]);
        		while (!stack.isEmpty() && stack.peek() == popA[j]){
        				stack.pop();
        				j++;
        		}
        }
        return stack.isEmpty();
    }
    
    public boolean myIsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int indexpush = 0;
        int indexpop = 0;
        while(indexpop < popA.length){
            while(indexpush < pushA.length && popA[indexpop]!= pushA[indexpush]){ //有变量改变的循环一定要先判断
                stack.push(pushA[indexpush++]);
            }
            if (indexpush >= pushA.length){
                    break;
            }
            if (pushA[indexpush] == popA[indexpop]){
                    stack.push(pushA[indexpush++]);
            }
            while(indexpop< popA.length && popA[indexpop] == stack.peek()){ //有变量改变的循环一定要先判断
                indexpop++;
                stack.pop();
            }
        }
        if (indexpop == indexpush)
            return true;
        return false;
    }
    
 }