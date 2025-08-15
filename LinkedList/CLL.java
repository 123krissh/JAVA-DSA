public class CLL {
    
    public class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node head;
    public static Node tail;

    public CLL() {
        this.head = null;
        this.tail = null;
    }

    public void insert(int data) {
        Node node = new Node(data);
        if(head == null) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void delete(int data) {
        Node temp = head;
        if(temp == null) {
            return;
        }

        if(temp.data == data){
            head = head.next;
            tail.next = head;
            return;
        }

        do {
            Node nxtN = temp.next;
            if (nxtN.data == data) {
                temp.next = nxtN.next;
                break;
            }
            temp = temp.next;
        } while (temp != head);
    }

    public void display(){
        Node temp = head;
        if (head != null) {
            do{
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            } while(temp != head);
        }
        System.out.println("HEAD");
    }

    public static void main(String[] args) {
        CLL cll = new CLL();

        cll.insert(1);
        cll.insert(23);
        cll.insert(19);
        cll.insert(17);
        cll.insert(3);

        cll.display();
        cll.delete(19);
        cll.display();
    }
}
