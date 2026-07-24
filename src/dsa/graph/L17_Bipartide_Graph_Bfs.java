package dsa.graph;

import java.util.*;

public class L17_Bipartide_Graph_Bfs {
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++) {
            int first = edges[i][0];
            int second = edges[i][1];
            adj.get(first).add(second);
            adj.get(second).add(first);
        }

        int[] col = new int[V];
        Arrays.fill(col, -1);


        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        col[0] = 0;

        while(!q.isEmpty()) {
            int ind  = q.poll();

            for(Integer it : adj.get(ind)) {
                if(col[it] == -1) {
                    col[it] = 1 - col[ind];
                    q.add(it);
                }
                else if(col[it] == col[ind]) {
                    return false;
                }

            }
        }

        return true;
    }
}


//TC : O(V+ E)
//SC : O(V+E)