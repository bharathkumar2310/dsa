package dsa.graph;

import java.util.*;

public class L27_Shortest_Dist_In_DAG {
    class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here

        Stack<Integer> st = new Stack<>();
        int[] dist = new int[V];
        int[] vis = new int[V];
        Arrays.fill(dist, (int) 1e9);

        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<V; i++) {
            adj.add(new ArrayList<>());
        }



        for(int i=0; i<edges.length; i++) {
            int first = edges[i][0];
            int second = edges[i][1];
            int third = edges[i][2];
            adj.get(first).add(new Pair(second, third));
        }

        vis[0] = 1;
        topoSort(0,st,adj, vis);


        dist[0] = 0;

        while(!st.isEmpty()) {
            Integer node = st.pop();
            for(Pair pair  : adj.get(node)) {
                int node1 = pair.node;
                int dist1 = pair.dist;

                if(dist[node] + dist1 < dist[node1]) {
                    dist[node1] = dist[node] + dist1;
                }
            }

        }

        for(int i=0; i<V;i++) {
            if(dist[i] == (int) 1e9) {
                dist[i] = -1;
            }
        }

        return dist;

    }

    void topoSort(int i, Stack<Integer> st, List<List<Pair>> adj, int[] vis) {


        for(Pair pair : adj.get(i)) {
            if(vis[pair.node] == 0) {
                vis[pair.node] = 1;
                topoSort(pair.node,st, adj, vis);
            }
        }

        st.add(i);
    }
}


//Compute the topological order of the DAG using DFS (or Kahn's algorithm).
//        Initialize dist[0] = 0 and all other distances as INF.
//        Process nodes in topological order and relax all outgoing edges once.

// we can also use djikstars but it is more tc than this
//TC : O(V+E)
//SC : O(V+E)