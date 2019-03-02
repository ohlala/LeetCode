import java.util.ArrayList;
import java.util.Stack;
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
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
    		ArrayList<ArrayList<Integer>> allPath = new ArrayList<ArrayList<Integer>>();
    		if (root == null)
    				return allPath;
    		ArrayList<Integer> stack = new ArrayList<>();
    		visitTree(root, target, allPath, stack);
    		return allPath;
    }
    
    public void visitTree(TreeNode root,int target, ArrayList<ArrayList<Integer>> allPath, ArrayList<Integer> stack){
    		stack.add(root.val);
    		target -= root.val;
    		if (target == 0 && root.left == null && root.right == null){
    				allPath.add(new ArrayList<Integer>(stack));
    		}
    		if (root.left != null) visitTree(root.left, target, allPath, stack);
    		if (root.right != null) visitTree(root.right, target, allPath, stack);
    		stack.remove(stack.size()-1);
    }
}

public class Solution {
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size()-1);
        return listAll;
    }
}