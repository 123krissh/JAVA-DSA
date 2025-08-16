import java.lang.classfile.components.ClassPrinter.ListNode;

public class Question {

    // Optimized Approch
    public Node removeElements(Node head, int val) {
        if(head==null) { return null; }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    // Iterative approch
    public Node removeElements(Node head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }

        Node temp = head;
        Node prev = null;
        while(temp != null) {
            if(temp.val == val){
                prev.next = temp.next;
            } else {
                prev = temp;
            }
            temp = temp.next;
        }
        return head;
    }
}
