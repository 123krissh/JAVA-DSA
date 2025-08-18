import java.lang.classfile.components.ClassPrinter.ListNode;

import LinkedList.LL;

public class Question {

    public static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
 
    public static Node head;
    public static Node tail;
    public static int size;

    // Optimized Approch
    public Node removeElementsRec(Node head, int val) {
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
    
    public void duplicate() {
        if(head == null || head.next == null){
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
                size--;
            } else {
                temp = temp.next;
            }
        }
        // tail = temp;
        // tail.next  = null;
    }

    public static LL merge(LL list1, LL list2) {
        Node f = list1.head;
        NOde s = list2.head;

        LL mergeLL = new LL();
        while (f != null && s != null) {
            if(f.val < s.val){
                mergeLL.addLast(f.val);
                f = f.next;
            } else {
                mergeLL.addLast(s.val);
                s = s.next;
            }
        }

        while (f != null) {
            mergeLL.addLast(f.val);
            f = f.next;
        }
        while (s != null) {
            mergeLL.addLast(s.val);
            s = s.next;
        }
        return mergeLL;
    }
    // OR
    public static LL mergeTwoLists(LL list1, LL list2) {
    Node dummy = new Node();  // dummy node
    Node tail = dummy;

    while (list1 != null && list2 != null) {
        if (list1.val < list2.val) {
            tail.next = list1;
            list1 = list1.next;
        } else {
            tail.next = list2;
            list2 = list2.next;
        }
        tail = tail.next;  // move tail forward
    }

    tail.next = (list1 != null) ? list1 : list2;

    return dummy.next;  // skip dummy, return real head
}

public Node addTwoNumbers(Node l1, Node l2) {
        Node dummy = new Node();
        Node curr = dummy;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int sum = carry;
            if(l1!=null) {
                sum += l1.val;
                l1 = l1.next;
            }    
            if(l2!=null){
                sum += l2.val;
                l2 = l2.next;
            }
            Node newNode = new Node(sum%10);
            carry = sum/10;
            curr.next = newNode;
            curr = curr.next;
        }
        if(carry != 0){
            Node LastCarry = new Node(carry);
            curr.next = LastCarry;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Question list = new Question();  
    }
}
