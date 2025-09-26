import java.util.*;

public class BT {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        // Preorder printer (prints -1 for null to verify input)
        public static void preorder(Node root) {
            if (root == null) {
                System.out.print("-1 ");
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        // postorder traversal
        public static void postorder(Node root){
            if (root == null) {
                // System.out.print("-1 ");
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        // inorder travarsal
        public static void inorder(Node root){
            if (root == null) {
                // System.out.print("-1 ");
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        // Levelorder travarsal
        public static void Levelorder(Node root){
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            
            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }

        // Tree Height
        public static int height(Node root){
            if (root == null) {
                return 0;
            }

            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh, rh) + 1;
        }

        // count Nodes
        public static int count(Node root) {
            if (root == null) {
                return 0;
            }
            int leftCount = count(root.left);
            int rightCount = count(root.right);
            return leftCount + rightCount + 1;
        }

        // sum of nodes 
        public static int sum(Node root){
            if (root == null) {
                return 0;
            }
            int leftSum = sum(root.left);
            int rightSum = sum(root.right);
            return leftSum + rightSum + root.data;
        }

        // Diameter of tree = no. of nodes in the longest path b/w 2 leaves
        public static int diameter(Node root){ // O(N^2)
            if (root == null) {
                return 0;
            }

            int leftDiam = diameter(root.left);
            int leftHt = height(root.left);
            int rightDiam = diameter(root.right);
            int rightHt = height(root.right);

            int selfDiam = leftHt + rightHt + 1;
            return Math.max(selfDiam, Math.max(rightDiam, leftDiam));
        }
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);
        tree.preorder(root);
        tree.postorder(root);
        tree.inorder(root);
        tree.Levelorder(root);

        // Node root = new Node(1);
        // root.left = new Node(2);
        // root.right = new Node(3);
        // root.left.left = new Node(4);
        // root.left.right = new Node(5);
        // root.right.left = new Node(6);
        // root.right.right = new Node(7);

        System.out.println(tree.height(root));
        System.out.println(tree.count(root));
        System.out.println(tree.sum(root));
        System.out.println(tree.diameter(root));
    }
}
 