package dsa.graph;

import java.util.ArrayList;
import java.util.List;

public class L19_Detect_Cycle_In_Directed_Graph {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++) {
            int first = edges[i][0];
            int second = edges[i][1];
            adj.get(first).add(second);
        }

        boolean ans = false;

        int[] vis = new int[V];
        int[] path = new int[V];

        for(int i=0; i<V; i++) {
            if(vis[i] == 0) {
                vis[i] = 1;
                path[i] = 1;

                ans = ans || dfs(i, vis, adj, path);
            }
        }

        return ans;

    }

    boolean dfs(int i, int[] vis, List<List<Integer>> adj, int[] path) {

        vis[i] = 1;
        path[i] = 1;

        for(Integer it : adj.get(i)) {
            if(vis[it] == 0) {
                if(dfs(it, vis, adj, path) == true) {
                    return true;
                }
            }
            else {
                if(path[it] == 1) {
                    return true;
                }
            }
        }

        path[i] = 0;

        return false;
    }
}


//TC : O(V+ E)
//SC : O(V+E)