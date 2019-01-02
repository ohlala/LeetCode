/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {   //给的数组形式 就直接用数组形式
    		//如何将一个array转换为ArrayList？
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    public TreeNode reConstructBinaryTree(int[] pre, int preBegin, int preEnd, int[] in, int inBegin, int inEnd) {
        if (preBegin > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preBegin]);
        int index = 0;
        for ( ; in[inBegin + index] != pre[preBegin]; index++) ;
        root.left = reConstructBinaryTree(pre, preBegin + 1, preBegin + index, in, inBegin, index - 1);
        root.right = reConstructBinaryTree(pre, preBegin + index + 1, preEnd, in, inBegin + index + 1, inEnd);
        return root;
    }
}