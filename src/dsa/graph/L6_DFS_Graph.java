package dsa.graph;

import java.util.ArrayList;

public class L6_DFS_Graph {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int[] vis = new int[adj.size()];
        rec(0, adj, ans, vis);
        return ans;
    }

    void rec(int i, ArrayList<ArrayList<Integer>> adj,  ArrayList<Integer> ans, int[] vis) {

        if(i >= adj.size()) {
            return;
        }

        vis[i] = 1;
        ans.add(i);

        for(Integer it : adj.get(i)) {
            if(vis[it] == 0) {
                rec(it, adj, ans, vis);
            }
        }
    }
}

//TC : O(V+ 2E)
//SC : O(V)+O(V)+O(V)=O(3V)