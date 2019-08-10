Class Node{
    Node left;
    Node right;
    int val;
}
public class Main {
    public static void main(String[] args) {
        
    }
    public static void mirror(Node root){
        if (root == null){
            return ;
        }
        LinkedList<Node> que = new LinkedList<>;
        que.addLast(root);
        while(que.size > 0){
            Node root = que.peekFirst();
            que.pollFirst();
            if (root.left != null)
                que.addLast(root.left);
            if (root.right != null)
                que.addLast(root.right);
            Node temp = root.right;
            root.right = root.left;
            root.left = temp;
        }
    }
    
}