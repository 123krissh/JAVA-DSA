import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class question {

    // Maximum Product of Splitted Binary Tree
    long max = Integer.MIN_VALUE;
    int mod = 1000000007;
    public static int maxProduct(TreeNode root) {
        long sum = totalSum(root);
        dfs(root, sum);
        return (int) (max % mod);
    }

    public static long dfs(TreeNode root, long sum) {
        if(root == null) {
            return 0;
        }
        long left = dfs(root.left, sum);
        long right = dfs(root.right, sum);
        long currSum = root.val + left + right;
        max = Math.max(max, (sum - currSum) * currSum);
        return currSum;
    }

    public static long totalSum(TreeNode root){
        if (root == null) {
            return 0;
        }
        long leftSum = totalSum(root.left);
        long rightSum = totalSum(root.right);
        return leftSum + rightSum + root.val;
    }

    // Maximum Level Sum of a Binary Tree
    public static int maxLevelSum(TreeNode root) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int ans = 0;
        int level = 1;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            sum = 0;
            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
            }
            if(max < sum) {
                max = sum;
                ans = level;
            }
            level++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] root = {1,null,2,3,4,null,null,5,6};
        System.out.println(maxLevelSum(root));
        System.out.println(maxProduct(root));
    }
}
