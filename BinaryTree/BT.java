import java.lang.ProcessHandle.Info;
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
                // System.out.print("");
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
        // Optimized Diameter of tree
        static class Info {
            int diam;
            int ht;

            public Info(int diam, int ht){
                this.diam = diam;
                this.ht = ht;
            }
        }
        public static Info diameter2(Node root) {  // O(N)
            if(root == null) {
                return new Info(0, 0);
            }
            Info leftInfo = diameter2(root.left);
            Info rightInfo = diameter2(root.right);

            int diam = Math.max(leftInfo.ht + rightInfo.ht + 1, Math.max(leftInfo.diam, rightInfo.diam));
            int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;
            return new Info(diam, ht);
        }
    }

    // Check if a tree is subtree of another tree
    public static boolean isSubtree(Node root1, Node subroot){
        if(root1 == null){
            return false;
        }
        if(root1.data == subroot.data){
            if(isIdentical(root1, subroot)){
                return true;
            }
        }
        return isSubtree(root1.left, subroot) || isSubtree(root1.right, subroot);
    }
    public static boolean isIdentical(Node node, Node subroot) {
        if(node == null && subroot == null){
            return true;
        } else if(node == null || subroot == null || node.data != subroot.data){
            return false;
        }
        if (!isIdentical(node.left, subroot.left)) {
            return false;
        }
        if (!isIdentical(node.right, subroot.right)) {
            return false;
        }
        return true;
    }

    // Top view of binary tree
    static class Info2 {
        Node node;
        int hd; // horizontal distance

        public Info2(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    public static void topView(Node root){
        // Level order
        Queue<Info2> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;
        q.add(new Info2(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            Info2 curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }
                if(curr.node.left != null){
                    q.add(new Info2(curr.node.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }
                if(curr.node.right != null){
                    q.add(new Info2(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                }
            }
        }

        for(int i=min; i<=max; i++){
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();
    } 

    // Kth level nodes
    public static void KLevel (Node root, int level, int k){
        if(root == null){
            return;
        }
        if(level == k) {
            System.out.print(root.data + " ");
            return;
        }
        KLevel(root.left, level+1, k);
        KLevel(root.right, level+1, k);
    }

    // Lowest Common Ancestor 
    public static Node LCA(Node root, int n1, int n2){ // O(n)
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        // last common ancestor
        int i = 0;
        for(; i<path1.size() && i<path2.size(); i++){
            if(path1.get(i) != path2.get(i)) break;
        }
        Node lca = path1.get(i-1);
        return lca;
    }
    public static boolean getPath(Node root, int n, ArrayList<Node> path){
        if(root == null) return false;
        path.add(root);
        if(root.data == n) return true;
        if(getPath(root.left, n, path) || getPath(root.right, n, path)) return true;
        path.remove(path.size()-1);
        return false;
    }
    // other approch for LCA with contant space O(1)
    public static Node LCA2(Node root, int n1, int n2){
        if (root == null || root.data == n1 || root.data == n2){
            return root;
        }
        Node leftLca = LCA2(root.left, n1, n2);
        Node rightLca = LCA2(root.right, n1, n2);
        if(leftLca == null) return rightLca;
        if(rightLca == null) return leftLca;
        return root;
    }
    // Kth ancestor
    public static int KAncestor(Node root, int n, int k){
        if(root == null) return -1;
        if (root.data == n) return 0;
        int leftDist = KAncestor(root.left, n, k);
        int rightDist = KAncestor(root.right, n, k);
        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }
        int max = Math.max(leftDist, rightDist);
        if (max+1 == k) {
            System.out.println(root.data);
        }
        return max + 1;
    }

    // Min distance b/w 2 nodes
    public static int minDist(Node root, int n1, int n2){
        Node lca = LCA2(root, n1, n2);
        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);
        return dist1 + dist2;
    }
    public static int lcaDist(Node root, int n){
        if (root == null) return -1;
        if (root.data == n) return 0;
        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);
        if (leftDist == -1 && rightDist ==-1) {
            return -1;
        } else if (leftDist == -1) {
            return rightDist + 1;
        } else return leftDist + 1;
    }

    // transform to sum tree
    public static int transform(Node root){
        if(root == null) return 0;
        int leftChild = transform(root.left);
        int rightChild = transform(root.right);
        int data = root.data;
        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;
        root.data = newLeft + leftChild + newRight + rightChild;
        return data;
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);
        tree.preorder(root);
        System.out.println();
        tree.postorder(root);
        System.out.println();
        tree.inorder(root);
        System.out.println();
        tree.Levelorder(root);

        System.out.println(tree.height(root));
        System.out.println(tree.count(root));
        System.out.println(tree.sum(root));
        System.out.println(tree.diameter(root));
        System.out.println(tree.diameter2(root).ht);
        System.out.println(tree.diameter2(root).diam);

        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);
        
        Node subroot = new Node(2);
        subroot.left = new Node(4);
        subroot.right = new Node(5);

        System.out.println(isSubtree(root1, subroot));
        topView(root1);
        KLevel(root1, 1, 2);
        System.out.println();
        System.out.println("lowest common ancestor: "+LCA(root1, 4, 5).data);
        System.out.println(minDist(root1, 4, 7));
        KAncestor(root1, 4, 2);
        transform(root1);
        tree.preorder(root1);
    }
}
 