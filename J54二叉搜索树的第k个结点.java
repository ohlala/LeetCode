import java.util.LinkedList;

public class Solution {
    static TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot == null || k < 0)
            return null;
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = pRoot;
        int count = 0;
        while (stack.size()>0 || cur != null){ //后面是为了根节点时能转移到右边
            if (cur !=  null ){
                stack.addFirst(cur);        //stack
                cur = cur.left;
            }else {
                cur = stack.peekFirst();
                stack.pollFirst();
                count += 1;
                if (count == k){
                    return cur;
                }
                cur = cur.right;
            }
        }
        return null;
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        System.out.println(KthNode(root,1).val);
        System.out.println(KthNode(root,6).val);//7
        System.out.println(KthNode(root,8));//null
    }
}