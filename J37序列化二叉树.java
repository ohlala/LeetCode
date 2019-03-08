/*
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
    
    StringBuilder sb = new StringBuilder();
    int index = -1;								 //用类变量记录堆栈相关信息
    String Serialize(TreeNode root) {
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        Serialize(root.left);
        Serialize(root.right);
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        String[] strr = str.split(",");   // 结果是字符串数组
        if (strr[0] == "#")
            return null;
        return Deserialize(strr);
    }

    TreeNode Deserialize(String[] str) {
        index ++;
        if (index >= str.length)
            return null;
        TreeNode root = null;
        if (!(str[index].equals("#"))){  //字符串的比较应该用equals 不能用==
            root = new TreeNode(Integer.valueOf(str[index]));
            root.left = Deserialize(str);
            root.right = Deserialize(str);
        }
        return root;
    }
}