package dsa.graph;

import java.util.ArrayList;
import java.util.List;

public class L12_Detect_Cycle_In_UnDirected_Grafh_Dfs {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        boolean ans = false;
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

        int[] vis = new int[V];

        for(int i=0;i<V; i++) {
            if(vis[i] == 0) {
                ans = ans || dfs(i, adj, vis, -1);
                if(ans == true) {
                    return ans;
                }
            }
        }

        return false;

    }


    boolean dfs(int i, List<List<Integer>> adj, int[] vis, int parent) {


        vis[i] = 1;
        for(Integer it : adj.get(i)) {
            if(vis[it] == 1 && it!= parent ) {
                return true;
            }

            else if(vis[it] == 0) {
                if(dfs(it, adj, vis, i)) {
                    return true;
                }
            }
        }

        return false;
    }
}

//TC : O(V+ 2E)
//SC : O(V+E)