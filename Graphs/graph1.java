import java.util.*;

    // Graph Representations:-
    // 1. Adjacency list representation of graph in list of vertices and edges (Array of arrayList <edge>) optimized & efficient AND no extra info stored 
    // 2. Adjacency matrix representation of graph in matrix of vertices and edges
    // 3. Edge List representation of graph in list of edges only (Array of edges) optimized & efficient AND no extra info stored
    // 4. Implicit Graph 2D matrix assume as a graph with moves in 4 directions up down left right


public class graph1 {
    
    // 1. Adjacency List Representation
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
  
    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 vertex = 0 -> 1
        graph[0].add(new Edge(0, 1, 5));

        // 1 vertex = 1 -> 0
        graph[1].add(new Edge(1, 0, 5));
        // 1 -> 2 
        graph[1].add(new Edge(1, 2, 1));
        // 1 -> 3
        graph[1].add(new Edge(1, 3, 3));

        // 2 vertex = 2 ->1
        graph[2].add(new Edge(2, 1, 1));
        // 2 -> 3
        graph[2].add(new Edge(2, 3, 1));  
        // 2 -> 4
        graph[2].add(new Edge(2, 4, 2));

        // 3 vertex = 3 -> 1
        graph[3].add(new Edge(3, 1, 3));
        // 3 -> 2
        graph[3].add(new Edge(3, 2, 1));
        
        // 4 vertex = 4 -> 2
        graph[4].add(new Edge(4, 2, 2));
    }

    // BFS Traversal -- O(V+E)
    public static void bfs(ArrayList<Edge> graph[]) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[graph.length];
        q.add(0); // source = 0

        while(!q.isEmpty()) {
            int curr = q.remove();
            if(!vis[curr]) {
                System.out.print(curr + " ");
                vis[curr] = true;
                for(int i=0; i<graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    // bfs on connected components
    public static void bfsCC(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                // similar to normal bfs
                Queue<Integer> q = new LinkedList<>();
                q.add(i); // source = i
                while(!q.isEmpty()) {
                    int curr = q.remove();
                    if(!vis[curr]) {
                        System.out.print(curr + " ");
                        vis[curr] = true;
                        for(int j=0; j<graph[curr].size(); j++) {
                            Edge e = graph[curr].get(j);
                            q.add(e.dest);
                        }
                    }
                }
            }
        }
    }

    // DFS traversal -- O(V+E)
    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        // visit
        System.out.print(curr + " ");
        vis[curr] = true;
   
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }
    // dfs on connected components
    public static void dfsCC(ArrayList<Edge> graph[]) {
        boolean[] vis = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                dfs(graph, i, vis);
            }
        }
    }

    // check path b/w src - dest exist -- O(V+E)
    public static boolean hasPath(ArrayList<Edge> graph[], int src, int dest, boolean vis[]) {
        if(src == dest) {
            return true;
        }
        vis[src] = true;
        for(int i=0; i<graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if(!vis[e.dest] && hasPath(graph, e.dest, dest, vis)) {
               return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int V = 5; // no. of vertices
        ArrayList<Edge>[] graph = new ArrayList[V]; // null -> empty arraylist
        createGraph(graph);

        // 2's neighbors
        for(int i=0; i<graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.println(e.dest);
        }

        bfs(graph);
        System.out.println();
        dfs(graph, 0, new boolean[V]);
        System.out.println();
        System.out.println(hasPath(graph, 0, 4, new boolean[V]));

        cloneGraph(graph);
    }

    // clone graph 
    public static void cloneGraph(ArrayList<Edge> graph[]) {
        int V = graph.length;
        ArrayList<Edge>[] newGraph = new ArrayList[V];
        for(int i=0; i<V; i++) {
            newGraph[i] = new ArrayList<>();
        }

        for(int i=0; i<V; i++) {
            for(int j=0; j<graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                newGraph[e.src].add(new Edge(e.src, e.dest, e.wt));
            }
        }

        for (ArrayList<Edge> arrayList : newGraph) {
            for (Edge e : arrayList) {
                System.out.println(e.src + "->" + e.dest + " " + "wt:" + e.wt);
            }
        }
    }

    // leetcode style clone graph 
    static class Node {
        int val;
        ArrayList<Node> neighbors;

        public Node(int v) {
            this.val = v;
            this.neighbors = new ArrayList<>();
        }
    }
    
    public static Node createClone(Node node, HashMap<Node, Node> map) {
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        for(Node neighbor : node.neighbors) {
            if(!map.containsKey(neighbor)) {
                // not cloned
                newNode.neighbors.add(createClone(neighbor, map));
            } else {
                // already cloned
                newNode.neighbors.add(map.get(neighbor));
            }
        }
        return newNode;
    }
    public static Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        return createClone(node, map);
    }
}
