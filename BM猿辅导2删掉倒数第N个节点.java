public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
    public static Node deleteLastN(Node head, int n){
        Node fast = head;
        for (int i = 0; i < n-1; i++){
            if (fast == null){
                return null;
            }
            fast = fast.next;
        }
        if(fast.next == null){
            head = head.next;
            return head;
        }
        Node slow = head;
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}