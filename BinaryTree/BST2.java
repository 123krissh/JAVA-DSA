import java.util.*;

public class BST2 {
    
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    public static void preorder(Node root){
        if (root == null) {
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    // sorted array to balanced BST ----> if array is given the change arraylist to array parameter
    public static Node sortedArray2BST(ArrayList<Integer> inorder, int st, int end){
        if(st > end) return null;
        int mid = (st + end) / 2;
        Node root = new Node(inorder.get(mid));
        root.left = sortedArray2BST(inorder, st, mid - 1);
        root.right = sortedArray2BST(inorder, mid + 1, end);
        return root;
    }

    // BST to balanced BST ---> O(n)
    public static Node bst2balancedBST(Node root){
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);
        root = sortedArray2BST(inorder, 0, inorder.size()-1);
        return root;
    }
    public static void getInorder(Node root, ArrayList<Integer> inorder){
        if(root == null) return;
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    // Largest BST in Binary Tree ---->
    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST, int size, int min, int max){
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    public static int maxBST = 0;

    public static Info largestBST(Node root) {
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if(root.data <= leftInfo.max || root.data >= rightInfo.min){
            return new Info(false, size, min, max);
        }
        if (leftInfo.isBST && rightInfo.isBST) {
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }
        return new Info(false, size, min, max);
    }

    // merge 2 BSTs ----> O(n+m) linear time
    public static Node mergeBSTs(Node root1, Node root2){
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);

        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);

        int i = 0, j = 0;
        ArrayList<Integer> finalArr = new ArrayList<>();
        while(i < arr1.size() && j < arr2.size()){
            if (arr1.get(i) <= arr2.get(j)) {
                finalArr.add(arr1.get(i));
                i++;
            } else {
                finalArr.add(arr2.get(j));
                j++;
            }
        }
        while (i<arr1.size()) {
            finalArr.add(arr1.get(i));
            i++;
        }
        while (j<arr2.size()) {
            finalArr.add(arr2.get(j));
            j++;
        }

        // sorted array to balanced BST
        return sortedArray2BST(finalArr, 0, finalArr.size()-1); 
   }

    public static void main(String[] args) {
        // int[] arr = {3,5,6,8,10,11,12};
        // Node root1 = sortedArray2BST(arr, 0, arr.length-1);
        // preorder(root1);

        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);
        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        bst2balancedBST(root);
        preorder(root);
        System.out.println();
        Info info = largestBST(root);
        System.out.println("largest BST size = "+ maxBST);

        Node root1 = new Node(2);
        root1.left =new Node(1);
        root1.right = new Node(4);
        Node root2 = new Node(9);
        root2.left =new Node(3);
        root2.right = new Node(12);
        Node mergeBST = mergeBSTs(root1, root2);
        preorder(mergeBST);
    }
}