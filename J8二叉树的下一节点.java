public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode == null)	//空
            return null;
        if (pNode.right != null){ //右子树的最左节点
             pNode = pNode.right;
             while (pNode.left != null)
                pNode = pNode.left;
            return pNode;
        }
        while (pNode.next != null && pNode.next.right == pNode){ //第一个右上方的父节点 或者 空
            pNode = pNode.next;
        }
        if (pNode.next == null)
            return null;
        return pNode.next;
    }
}