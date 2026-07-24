package dsa.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L21_Topological_Sort {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++) {
            adj.add(new ArrayList<>());
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<edges.length; i++) {
            int first = edges[i][0];
            int second = edges[i][1];
            adj.get(first).add(second);
        }
        Stack<Integer> st = new Stack<>();
        int[] vis = new int[V];
        for(int i=0; i<V; i++) {
            if(vis[i] == 0) {
                vis[i] = 1;
                dfs(i,st, adj, vis);
            }
        }

        while(!st.isEmpty()) {
            ans.add(st.pop());
        }

        return ans;

    }

    void dfs(int i, Stack<Integer> st, List<List<Integer>> adj, int[] vis) {


        for(Integer it : adj.get(i)) {
            if(vis[it] == 0) {
                vis[it] = 1;
                dfs(it,st, adj, vis);
            }
        }

        st.add(i);
    }
}

//TC : O(V + E)
//SC : O(V + E)