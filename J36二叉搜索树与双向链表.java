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
    
    TreeNode pre = null;
    TreeNode head = null;
    
    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertNode(pRootOfTree);
        return head;
    }
    
    public void ConvertNode(TreeNode root) {
        if (root == null)
        		return;       
        ConvertNode(root.left);    
        if (pre == null){
        		pre = root;
        		head = root;
        }else{    //第一次不能做下列操作
		        pre.right = root;
		        root.left = pre;
		        pre = root;
        
        }    
        ConvertNode(root.right);
    }
}