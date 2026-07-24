package dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L18_Bipartide_dfs {
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
        col[0] = 0;
        return dfs(0, adj, col);

    }

    boolean dfs(int i, List<List<Integer>> adj, int[] col) {


        for(Integer it : adj.get(i)) {
            if(col[it] == -1) {
                col[it] = 1-col[i];
                if(dfs(it, adj, col) == false) {
                    return false;
                }
            }
            else if(col[it] == col[i]) {
                return false;
            }
        }

        return true;


    }
}

//TC : O(V+ E)
//SC : O(V+E)