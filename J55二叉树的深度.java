/**
 * public class TreeNode {
 * 	int val = 0;
 * 	TreeNode left = null;
 * 	TreeNode right = null;
 * 
 * 	public TreeNode(int val) {
 * 		this.val = val;
 * 	}
 * }
 */
public class Solution {
    public int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }

    public int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        LinkedList<TreeNode> que = new LinkedList<TreeNode>();
        que.add(root);
        int depth = 0;
        int layercount = 0;
        int nextlayer = 1;
        while (que.size() > 0) {
            TreeNode temp = que.peekFirst();
            que.removeFirst();
            layercount++;
            if (temp.left != null) {
                que.offerLast(temp.left);
            }
            if (temp.right != null) {
                que.offerLast(temp.right);
            }
            if (layercount == nextlayer) {
                layercount = 0;
                nextlayer = que.size();
                depth++;
            }
        }
        return depth;
    }
}

