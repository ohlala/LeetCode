import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
    		ArrayList<Integer> result = new ArrayList<>();
    		if (root == null)
    				return result;
    		Queue<TreeNode> que = new LinkedList<>();
    		que.add(root);
    		while(!que.isEmpty()){
    				TreeNode temp = que.peek();
    				que.remove();
    				result.add(temp.val);
    				if (temp.left != null) que.add(temp.left);
    				if (temp.right != null) que.add(temp.right);
    		}
    		return result; 		
    }
}