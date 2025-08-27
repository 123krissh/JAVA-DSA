import java.util.*;

public class Stacks {

    // Stack using ArrayList ------>
    static class MyStack {
        static ArrayList<Integer> list = new ArrayList<>();
        public  static boolean isEmpty(){
            return list.size() == 0;
        }
        // push
        public static void push(int data){
            list.add(data);
        }
        // pop
        public static int pop(){
            if (isEmpty()) {
                return -1;
            }
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }
        // peek
        public static int peek(){
            if (isEmpty()) {
                return -1;
            }
            return list.get(list.size()-1);
        }
    }

    // Stack using Linked List ------->
    static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
            this.next = null;
        }
    }
    static class MyStackLL {
        static Node head = null;

        public static boolean isEmpty(){
            return head == null;
        }
        // push
        public static void push(int val) {
            Node newNode = new Node(val);
            if(isEmpty()){
                head = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
        }
        // pop
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = head.val;
            head = head.next;
            return top;
        }
        // peek
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.val;
        }
    }

    public static void main(String[] args) {
        // using ArrayList
        // MyStack s1 = new MyStack();

        // using LL
        MyStackLL s = new MyStackLL(); 
        s.push(1);
        s.push(2);
        s.push(3);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }

        // using java collection framework
        Stack<Integer> s2 = new Stack<>();
        s2.push(1);
        s2.push(2);
        s2.push(3);

        while(!s2.isEmpty()){
            System.out.println(s2.peek());
            s2.pop();
        }
    }
}
