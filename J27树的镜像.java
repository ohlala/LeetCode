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
    public void Mirror(TreeNode root) {
    		if (root == null)
    				return;
    		Queue<TreeNode> que = new LinkedList<>();
    		que.add(root);
    		while (!que.isEmpty()){
    				TreeNode node = que.poll();
    				TreeNode temp;
    				temp = node.left;
    				node.left = node.right;
    				node.right = temp;
    				if (node.left != null) que.add(node.left);
    				if (node.right != null) que.add(node.right);
    		}    		
    }
}
