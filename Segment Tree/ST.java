public class ST {
    static int tree[];

    public static void init(int n) {
        tree = new int[4*n];
    }

    public static int buildST(int[] arr, int i, int start, int end) { //O(n)
        if(start == end){
            tree[i] = arr[start];
            return arr[start];
        }

        int mid = (start + end)/2;
        buildST(arr, 2*i+1, start, mid); // left subtree - 2*i+1
        buildST(arr, 2*i+2, mid+1, end); // right subtree - 2*i+2
        tree[i] = tree[2*i+1] + tree[2*i+2];
        return tree[i];
    }

    // Query in range to get sum - O(log n)
    public static int getSum(int[] arr, int qi, int qj){
        int n = arr.length;
        return getSumUtil(0, 0, n-1, qi, qj);
    }
    public static int getSumUtil(int i, int si, int sj, int qi, int qj) {
        if(qj <= si || qi >= sj) { // non overlapping
            return 0; 
        } else if (si >= qi && sj <= qj) { // complete overlap
            return tree[i];
        } else { // partial overlap
            int mid = (si + sj) / 2;
            int left = getSumUtil(2*i+1, si, mid, qi, qj);
            int right = getSumUtil(2*i+2, mid+1, sj, qi, qj);
            return left + right;
        }
    }

    // update value on ST - O(log n)
    public static void updateST(int[] arr, int idx, int val){
        int n = arr.length;
        int diff = val - arr[idx];
        arr[idx] = val;
        updateSTUtil(0, 0, n-1, idx, diff); // O(log n) segment tree update
    }
    public static void updateSTUtil(int i, int si, int sj, int idx, int diff) { // O(log n)
        if(idx < si || idx > sj) {
            return;
        }
        tree[i] += diff;
        if(si != sj) {
            int mid = (si + sj)/2;
            updateSTUtil(2*i+1, si, mid, idx, diff); // left
            updateSTUtil(2*i+2, mid+1, sj, idx, diff); // right
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = arr.length;
        init(n);
        buildST(arr, 0, 0, n-1);
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();

        System.out.println(getSum(arr, 2, 5));

        updateST(arr, 2, 2);

        System.out.println(getSum(arr, 2, 5));
    }
}
