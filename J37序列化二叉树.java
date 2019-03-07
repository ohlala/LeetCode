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
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
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
       String[] strr = str.split(",");
       if (strr[0] == "#")
       		return null;
       return Deserialize(strr, 0);
   	}
   	
   	TreeNode Deserialize(String[] str, int index) {
				if (index >= str.length)
						return null;
				TreeNode root = null;			
				if (str[index] != "#"){
						root = new TreeNode(Integer.valueOf(str[index]));
						root.left = Deserialize(str, index++);
						root.right = Deserialize(str, index++);
				}
				return root;   
   	}
}