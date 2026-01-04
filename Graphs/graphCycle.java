import java.util.*;

public class graphCycle {

    static class Edge {  
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }
  
    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 vertex 
        graph[0].add(new Edge(0, 1));
        // graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        // 1 vertex 
        // graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        // 2 vertex 
        graph[2].add(new Edge(2, 0));
        // graph[2].add(new Edge(2, 1));  

        // 3 vertex 
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        
        // 4 vertex 
        // graph[4].add(new Edge(4, 3));
    }

    // Cycle Detection in undirected graph - O(V+E)
    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(graph, vis, i, -1)) {
                    return true;
                    // cycle exist in one of the any parts
                }
            }
        }
        return false;
    }
    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr, int parant) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            // case 3
            if (!vis[e.dest]) {
                if (detectCycleUtil(graph, vis, e.dest, curr)) {
                    return true;   
                }
            }
            // case 1
            else if (vis[e.dest] && e.dest != parant) {
                return true;
            }
            // case 2 - it's parant & neighbor visited not naccessory to cycle exist  then - do nothing -> continue
        }
        return false;
    }

    // Cycle Detection in Directed graph - O(V+E)
    public static boolean isCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++)  {
            if(!vis[i]) {
                if(isCycleUtil(graph, vis, stack, i)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isCycleUtil(ArrayList<Edge>[] graph, boolean[] vis, boolean[] stack, int curr) {
        vis[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.dest]) { // cycle exist
                return true;
            }
            if (!vis[e.dest] && isCycleUtil(graph, vis, stack, e.dest)) {
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        System.out.println(detectCycle(graph));
        System.out.println(isCycle(graph));
    }
}

