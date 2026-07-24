package dsa.graph;

import java.util.*;


//Kosaraju's Algorithm – Intuition :
//
//Perform a DFS and store nodes in order of finishing time (using a stack) on one graph (original or transpose).
//Reverse the graph (or use the original if the first DFS was on the transpose).
//Pop nodes from the stack and perform DFS; each new DFS visits exactly one SCC, so the number of DFS calls equals the number of SCCs.


public class L54_Strongly_Connected_Components_Kosaraju {
    public int kosaraju(int V, int[][] edges) {
        // code here

        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> adj1 = new ArrayList<>();

        for(int i=0; i<V; i++) {
            adj.add(new ArrayList<>());
            adj1.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++) {
            int first = edges[i][0];
            int second = edges[i][1];
            adj.get(first).add(second);
            adj1.get(second).add(first);

        }

        for(int i=0; i<V; i++) {
            if(vis[i] == 0) {
                dfs(i, vis, adj1, st);
            }
        }

        Arrays.fill(vis, 0);
        int cnt = 0;
        while(!st.isEmpty()) {
            int ind = st.pop();
            if(vis[ind] == 0) {
                cnt++;
                dfs1(ind, vis, adj);
            }
        }

        return cnt;

    }


    public void dfs(int i, int[] vis, List<List<Integer>> adj, Stack<Integer> stack) {

        vis[i] = 1;

        for(Integer it : adj.get(i)) {
            if(vis[it] == 0) {
                dfs(it, vis,adj, stack);
            }
        }

        stack.add(i);
    }

    public void dfs1(int i, int[] vis, List<List<Integer>> adj){

        vis[i] = 1;

        for(Integer it : adj.get(i)) {
            if(vis[it] == 0) {
                dfs1(it, vis,adj);
            }
        }

    }
}

//TC : O(E + V)
//SC : O(E + V)