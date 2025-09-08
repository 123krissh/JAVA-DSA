import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class queueQ {
    // Queue implementation using circular array
    static class Queue1 {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        Queue1(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public static boolean isEmpty(){
            return rear == -1 && front == -1;
        }

        public static boolean isFull(){
            return (rear + 1) % size == front;
        }

        // Enqueue / Add
        public static void add(int data) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            // add 1st element
            if(front == -1){
                front = 0;
            }

            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        // Dequeue / Remove
        public static int remove() {
            if(isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int result = arr[0];

            // last el delete
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            return result;
        }

        // peek
        public static int peek(){
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];  
        }
    }

    // Queue implementation using linked list----->
    static class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static class LLQueue {
        static Node head = null;
        static Node tail = null;

        public static boolean isEmpty(){
            return head == null && tail == null;
        }

        // Enqueue / Add
        public static void add(int data) {
            Node newNode = new Node(data);
            if (head  == null) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        // Dequeue / Remove
        public static int remove() {
            if(isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int front = head.data;
            // single element
            if (tail == head) {
                tail = head = null;
            } else {
                head = head.next;
            }
            return front;
        }

        // peek
        public static int peek(){
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return head.data;  
        }
    }

    public static  void reverse(Queue<Integer> q){
        if(q.isEmpty()){
            return;
        }
        int front = q.remove();
        reverse(q);
        q.add(front);
    }
    // OR
    public static  void reverse(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    public static void main(String[] args) {
        // Queue1 q = new Queue1(3);
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // System.out.println(q.remove());
        // q.add(4);
        // System.out.println(q.remove());
        // q.add(5);


        // java built in method in java collection framework 
        // queue is interface not a class so it does not create object so we use linkedlist or ArrayDeque class object is created.
        Queue<Integer> q = new LinkedList<>();
        // OR
        Queue<Integer> q = new ArrayDeque<>();
        q.add(6);
        q.add(7);
        q.add(8);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        } 

        LLQueue q1 = new LLQueue();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        System.out.println(q1.remove());
        q1.add(4);
        System.out.println(q1.remove());
        q1.add(5);

        while (!q1.isEmpty()) {
            System.out.println(q1.peek());
            q1.remove();
        }
    }
}
