import java.util.*;

public class prtnrClusterProduct {
    
    public static int largestPartnerClusterProduct(
            int partnerCount,
            List<Integer> restaurantFrom,
            List<Integer> restaurantTo,
            List<Integer> restaurantIds) {

        // Group connections by restaurant hub
        Map<Integer, List<int[]>> hubConnections = new HashMap<>();

        for (int i = 0; i < restaurantIds.size(); i++) {
            int hub = restaurantIds.get(i);
            int from = restaurantFrom.get(i);
            int to = restaurantTo.get(i); 

            hubConnections.computeIfAbsent(hub, k -> new ArrayList<>()).add(new int[]{from, to});
        }

        int maxClusterSize = 0;
        int bestProduct = 0;

        // Process each restaurant hub separately
        for (int hub : hubConnections.keySet()) {
            UnionFind uf = new UnionFind(partnerCount + 1);

            // Union partners for this hub
            for (int[] edge : hubConnections.get(hub)) {
                uf.union(edge[0], edge[1]);
            }

            // Collect connected components
            Map<Integer, Set<Integer>> components = new HashMap<>();

            for (int[] edge : hubConnections.get(hub)) {
                int p1 = edge[0], p2 = edge[1];
                int root1 = uf.find(p1);
                int root2 = uf.find(p2);

                components.computeIfAbsent(root1, k -> new HashSet<>()).add(p1);
                components.computeIfAbsent(root1, k -> new HashSet<>()).add(p2);
                components.computeIfAbsent(root2, k -> new HashSet<>()).add(p1);
                components.computeIfAbsent(root2, k -> new HashSet<>()).add(p2);
            }

            // Evaluate clusters
            for (Set<Integer> cluster : components.values()) {
                if (cluster.isEmpty()) continue;
                int size = cluster.size();

                if (size > maxClusterSize) {
                    maxClusterSize = size;
                    bestProduct = getMaxProduct(cluster);
                } else if (size == maxClusterSize) {
                    bestProduct = Math.max(bestProduct, getMaxProduct(cluster));
                }
            }
        }

        return bestProduct;
    }

    // Compute product of two largest partner IDs
    private static int getMaxProduct(Set<Integer> ids) {
        int max1 = -1, max2 = -1;
        for (int id : ids) {
            if (id > max1) {
                max2 = max1;
                max1 = id;
            } else if (id > max2) {
                max2 = id;
            }
        }
        return max1 * max2;
    }

    // Union-Find implementation
    static class UnionFind {
        int[] parent, rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return;
            if (rank[pa] < rank[pb]) {
                parent[pa] = pb;
            } else if (rank[pb] < rank[pa]) {
                parent[pb] = pa;
            } else {
                parent[pb] = pa;
                rank[pa]++;
            }
        }
    }

    public static void main(String[] args) {
        int partnerCount = 6;
        List<Integer> restaurantFrom = Arrays.asList(1, 2, 4, 5);
        List<Integer> restaurantTo = Arrays.asList(2, 3, 5, 6);
        List<Integer> restaurantIds = Arrays.asList(10, 10, 20, 20);

        int result = largestPartnerClusterProduct(partnerCount, restaurantFrom, restaurantTo, restaurantIds);
        System.out.println(result); // Expected output: 30
    }
}
