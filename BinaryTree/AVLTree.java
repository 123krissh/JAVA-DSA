public class AVLTree {
    static class Node {
        int data, height;
        Node left, right;

        Node(int data){
            this.data = data;
            height = 1;
        }
    }

    public static Node root;

    public static int height(Node root){
        if(root == null) return 0;
        return root.height;
    } 

    // static int max(int a, int b){
    //     return (a > b) ? a : b;
    // }

    // Balance Factor
    public static int getBalanceFactor(Node root){
        if (root == null) {
            return 0;
        }
        return height(root.left) - height(root.right);
    }

    // Left Rotate subtree rooted with x
    public static Node leftRotate(Node x){
        Node y = x.right;
        Node T2 = y.left;
        // perform rotation
        y.left = x;
        x.right = T2;
        // update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y; // new root;
    }

    // Right Rotate subtree rooted with x
    public static Node rightRotate(Node x){
        Node y = x.left;
        Node T2 = y.right;
        // perform rotation
        y.right = x;
        x.left = T2;
        // update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y; // new root;
    }

    public static Node insert(Node root, int val){
        if (root == null) {
            return new Node(val);
        }
        if(val < root.data){
            root.left = insert(root.left, val);
        } else if(val > root.data) {
            root.right = insert(root.right, val);
        } else {
            return root; // duplicate values not allowed
        }
        // update root height
        root.height = 1 + Math.max(height(root.left), height(root.right));
        // get root's balance factor
        int bf = getBalanceFactor(root);
        // left left case
        if(bf > 1 && val < root.left.data) {
            return rightRotate(root);
        }
        // right right case
        if (bf < -1 && val > root.right.data) {
            return leftRotate(root);
        }
        // left right case
        if (bf > 1 && val > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        // right left case
        if (bf < -1 && val < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root; // returned if AVL balanced
    }

    public static void preorder(Node root){
        if(root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);
        // AVL Tree is balanced
        preorder(root);
        System.out.println();
        System.out.println(root.height);
    }
}
