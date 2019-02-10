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
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
    		if (root1 == null || root2 == null)
    				return false;
				return isSubtree(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }
        
    public boolean isSubtree(TreeNode root1, TreeNode root2){
    		if (root2 == null)  //root2可以为空 因为2是1的一部分 空了说明之前的都对
    				return true;
    		if (root1 == null)	//1空了说明 2没空 对不上
    				return false;
    	  return (root2.val == root1.val) && (isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right));
    }
}