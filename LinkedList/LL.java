import java.lang.classfile.components.ClassPrinter.ListNode;
import java.util.LinkedList;

public class LL {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
 
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {  // O(1)
        // create new node
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        // newNode next = head
        newNode.next = head;
        // head = newNode
        head = newNode;
    }

    public void addLast(int data) {  // O(1)
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void add(int idx, int data) { // O(n)
        if(idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }

        // i = idx-1; temp -> prev node
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst() { //O(1)
        if(size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() { //O(n)
         if(size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        // prev: i = size - 2
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int itrSearch(int key) {  // O(n)
        Node temp = head;
        int i = 0;

        while (temp != null) {
            if(temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }

        return -1;
    }

    public int helper(Node head, int key) { // O(n)
        if(head == null) {
            return -1;
        }

        if(head.data == key) {
            return 0;
        }

        int idx = helper(head.next, key);
        if(idx == -1) {
            return -1;
        }
        return idx+1;
    }

    public int recSearch(int key){ 
        return helper(head, key);
    }

    public void reverse() { // O(n)
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void deleteKthNode(int k){
        if (head == null) {
            return;
        }
        if (k==1) {
            Node temp = head;
            head  = head.next;
            return;
        }
        int cnt = 0;
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            cnt++;
            if (cnt == k) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return;
    }

    public void deleteNthfromEnd(int n) {
        // calculate size
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }

        if (n == sz) {
            head = head.next; // removeFirst
            return;
        }

        // sz - n
        int i = 1;
        int iToFind = sz - n;
        Node prev = head;
        while (i < iToFind) {
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;
    }

    // Slow-Fast Approch
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next; // +1
            fast = fast.next.next; // +2
        }
        return slow; // slow is mid node
    }

    public boolean isPalindrome() {
        if (head == null || head.next == null) {
             return true;
        }
        // 1. find mid
        Node midNode = findMid(head);

        // 2. reverse second half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;

        // 3. check left half & right half 
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    // public static Node convertArr2LL(int[] arr){
    //     Node head = new Node(arr[0]);
    //     Node mover = head;
    //     for (int i = 1; i < arr.length; i++) {
    //         Node temp = new Node(arr[i]);
    //         mover.next = temp;
    //         mover = temp;
    //     }
    //     return head;
    // }

    public void printll() { // O(n)
        if(head == null) {
            System.out.println("Linked List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LL ll = new LL();

        // int[] arr = {1,2,3,4,5};
        // Node head = ll.convertArr2LL(arr);
        // System.out.println("LL from array: " + head.data);

        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(2);
        // ll.addLast(1);
        ll.add(3, 1);
        ll.printll();
        System.out.println("size of LL: " + ll.size);
        ll.removeFirst();
        ll.printll();
        ll.deleteKthNode(3);
        ll.printll();
        System.out.println("size of LL after removing first element: " + ll.size);
        ll.removeLast();
        ll.printll();
        System.out.println("size of LL after removing last element: " + ll.size);
        System.out.println(ll.itrSearch(1));
        System.out.println(ll.recSearch(2));
        ll.reverse();
        ll.printll();
        ll.deleteNthfromEnd(3);
        ll.printll();
        System.out.println("Is palindrom: " + ll.isPalindrome());
    }
}
