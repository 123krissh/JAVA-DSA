import java.util.PriorityQueue;

public class questions {

    // Connect n ropes with minimum cost 
    public static int minCost(int ropes[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<ropes.length; i++) {
            pq.add(ropes[i]);
        }

        int cost = 0;
        while(pq.size() > 1) {
            int min1 = pq.remove();
            int min2 = pq.remove();
            cost += min1 + min2;
            pq.add(min1 + min2);
        }
        return cost;
    }

    // Weakest Soldiers row of matrix
    static class Row implements Comparable<Row> {
        int soldiers;
        int idx;

        public Row(int soldiers, int idx) {
            this.soldiers = soldiers;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row r2) {
            if(this.soldiers == r2.soldiers) {
                return this.idx - r2.idx;
            } else {
                return this.soldiers - r2.soldiers;
            }
        }
    }
    public static int[] kWeakestRows(int[][] army, int k) {
        PriorityQueue<Row> pq = new PriorityQueue<>();
        // or
        // PQ storing int[] = {soldierCount, rowIndex}
        // PriorityQueue<int[]> pq = new PriorityQueue<>(
        //     (a, b) -> {
        //         if (a[0] == b[0]) {
        //             return a[1] - b[1]; // if equal soldiers, smaller index first
        //         }
        //         return a[0] - b[0]; // fewer soldiers -> weaker
        //     }
        // );
        
        for(int i=0; i<army.length; i++) {
            int count = 0;
            for(int j=0; j<army[0].length; j++) {
                count += army[i][j] == 1 ? 1 : 0;
            }
            pq.add(new Row(count, i));
        }

        int result[] = new int[k];
        for(int i=0; i<k; i++) {
            result[i] = pq.remove().idx;
        }
        return result;
    }

    // Sliding Window Maximum Subarray of k
    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]); // maxHeap
        int n = nums.length;
        int res[] = new int[n - k + 1];

        // 1st window
        for(int i=0; i<k; i++) {
            pq.add(new int[]{nums[i], i});
        }

        res[0] = pq.peek()[0];

        for(int i=k; i<n; i++) {
            // remove elements out of window
            while (pq.size() > 0 && pq.peek()[1] <= (i-k)) {
                pq.remove();
            }
            pq.add(new int[]{nums[i], i});
            res[i - k + 1] = pq.peek()[0];
        }
        return res;
    }

    public static void main(String[] args) {
        int ropes[] = {2, 3, 3, 4, 6};
        System.out.println("Minimum cost to connect ropes: " + minCost(ropes));

        int army[][] = {{1,0,0,0},
                        {1,1,1,1},
                        {1,0,0,0},
                        {1,1,0,0}};
        int k = 3;    
        int result[] = kWeakestRows(army, k);  
        for(int i : result){
            System.out.print("R"+i + " ");
        }
        System.out.println();

        int nums[] = {1,3,-1,-3,5,3,6,7};
        int res[] = maxSlidingWindow(nums, k);
        for(int i : res){
            System.out.print(i + " ");
        }
        System.out.println();   
    }
}
