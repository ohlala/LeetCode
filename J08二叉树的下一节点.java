public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode == null)	//��
            return null;
        if (pNode.right != null){ //������������ڵ�
             pNode = pNode.right;
             while (pNode.left != null)
                pNode = pNode.left;
            return pNode;
        }
        while (pNode.next != null && pNode.next.right == pNode){ //��һ�����Ϸ��ĸ��ڵ� ���� ��
            pNode = pNode.next;
        }
        if (pNode.next == null)
            return null;
        return pNode.next;
    }
}