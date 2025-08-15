import java.util.LinkedList;

public class DLL {

    public static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    public static Node head;

    public void insertFirst( int data) {
        Node node = new Node(data);
        if(head == null) {
            head = node;
            return;
        }
        node.next = head;
        head.prev = node;
        node.prev = null;
        head = node;
    }

    public void insertLast(int data) {
        Node node = new Node(data);
        if(head == null) {
            node.prev = null;
            head = node;
            return;
        }
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.prev = temp;
        node.next = null;
    }

    public void insert(int idx, int data){
        if(idx == 0) {
            insertFirst(data);
            return;
        }
        Node node = new Node(data);
        Node temp = head;
        int i = 0;

        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }

        node.next = temp.next;
        temp.next = node;
        node.prev = temp;
        if(node.next != null) {
            node.next.prev = node;
        } else {
            node.next = null;
        }
    }

    public void display() {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void displayRev() {
        Node temp = head;
        Node last = null;
        System.out.println("Reverse Display: ");
        while (temp != null) {
            last = temp;
            temp = temp.next;
        }
        while(last != null) {
            System.out.print(last.data + " -> ");
            last = last.prev;
        }
        System.out.println("start");
    }

    public static void main(String[] args) {
        DLL dll = new DLL();
        dll.insertFirst(3);
        dll.insertFirst(2);
        dll.insertFirst(8);
        dll.insertFirst(17);
        dll.insertLast(99);
        dll.insert(4, 4);

        dll.display(); 
        dll.displayRev();
    }    
}
