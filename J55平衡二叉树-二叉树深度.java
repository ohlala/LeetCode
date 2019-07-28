public class Solution {
  public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null || Math.abs(Deepth(root.right, 1)  - Deepth(root.left, 1)) <= 1)
            return true;
        return false;
    }

    public int Deepth(TreeNode root, int n) {
        if (root == null ){
            return n;
        }
        int ri = Deepth(root.right, n);
        int le = Deepth(root.left, n);
        return Math.max(ri,le)+1;
    }
}