import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

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

// Merge K Sorted lists [time complexity ~ O(kn)]
public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
        return null;
    }
        ListNode head = lists[0];
    for(int i=1; i<lists.length; i++) {
        head = mergeTwoLists(head, lists[i]);
    }
    return head;
}
// More Optimized Solution using Min-heap priorityQueue
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(!pq.isEmpty()) {
            // Extract smallest node
            ListNode minNode = pq.poll();
            curr.next = minNode;
            curr = curr.next;

            // If next node exists, push it into PQ
            if (minNode.next != null) {
                pq.add(minNode.next);
            }
        }
        return dummy.next;
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

    // sort a linked list brutefore LL -> array -> sort array -> LL
    public Node sortList(Node head) {
        int size = 0;
        Node temp = head;
        while(temp != null) {
            size++;
            temp = temp.next;
        }
        int[] arr = new int[size];
        int i = 0;
        temp = head;
        while(temp != null) {
            arr[i] = temp.val;
            i++;
            temp = temp.next;
        }

        Arrays.sort(arr);

        i = 0;
        temp = head;
        while(temp != null) {
            temp.val = arr[i];
            i++;
            temp = temp.next;
        }
        return head;
    }
    // optimized sort using merge sort
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null){
            slow = slow.next; // +1
            fast = fast.next.next; // +2
        }
        return slow;
    }
    public Node sortLL(Node head){
        if (head == null || head.next == null) {
            return head;
        }
        Node mid = findMid(head);
        Node left = head;
        Node right = mid.next;
        mid.next = null; // split the list into two halves

        left = sortLL(left);
        right = sortLL(right);
        return mergeTwoLists(left, right);
    } 

    public static boolean cycle(){
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null){
            slow = slow.next; // +1
            fast = fast.next.next; // +2
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static boolean cycleLength(){
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return findCycleLength(slow, fast);
            }
        }
        return 0;
    }
    public static int findCycleLength(Node slow, Node fast){
        int lenght = 1;
        while (fast != slow) {
            fast = fast.next;
            lenght++;
        }
        return length;
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = dummy;
        while(temp.next != null && temp.next.next != null){
            ListNode f = temp.next;
            ListNode s = temp.next.next;

            // int t = f.val;
            // f.val = s.val;
            // s.val = t;
            // temp = temp.next.next;

            f.next = s.next;
            s.next = f;
            temp.next = s;
            temp = f;
        }
        return dummy.next;
    }

    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp1 = head;
        for(int i=1;i<k;i++){
            temp1 = temp1.next;
        }
        ListNode curr = temp1;
        ListNode temp2 = head;
        while(curr.next!=null){
            curr = curr.next;
            temp2 = temp2.next;
        }
        int tt = temp1.val;
        temp1.val = temp2.val;
        temp2.val = tt;
        return head;
        
        // OR---->
        // ListNode temp = head;
        // int size = 0;
        // while(temp != null) {
        //     size++;
        //     temp = temp.next;
        // }
        // int[] arr = new int[size+1];
        // temp = head;
        // int i = 0;
        // while(temp != null){
        //     arr[i] = temp.val;
        //     i++;
        //     temp = temp.next;
        // }

        // int idxfromSt = k-1;
        // int idxfromEnd = size-k;

        // int tp = arr[idxfromSt];
        // arr[idxfromSt] = arr[idxfromEnd];
        // arr[idxfromEnd] = tp;

        // temp = head;
        // i=0;
        // while(temp != null){
        //     temp.val = arr[i];
        //     i++;
        //     temp = temp.next;
        // }
        // return head;
    }

    // reverse kth node 
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        ListNode nxt = head.next;
        nxt.next = head;
        head.next = null;
        return newHead;
    }
    public ListNode getKthNode(ListNode temp, int k){
        k -= 1;
        while(temp != null && k > 0){
            k--;
            temp = temp.next;
        }
        return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null) {
            ListNode kthNode = getKthNode(temp, k);
            if(kthNode == null){
                if(prev != null) prev.next = temp;
                break;
            }
            ListNode NxtNode = kthNode.next;
            kthNode.next = null;
            reverseList(temp);
            if(temp == head){
                head = kthNode;
            } else {
                prev.next = kthNode;
            }
            prev = temp;
            temp = NxtNode;
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addLast(3);
        ll.addLast(4);

        System.out.println(ll);
    }
}
