package dsa.graph;

import java.util.ArrayList;
import java.util.List;

public class L20_Eventual_Safe_State {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        int V = graph.length;
        int[] vis = new int[V];
        int[] path = new int[V];
        int[] check = new int[V];

        for(int i=0; i<V; i++) {
            if(vis[i] == 0) {
                vis[i] = 1;
                path[i] = 1;

                dfs(i, vis, graph, path, check);
            }
        }

        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<V; i++) {
            if(check[i] == 1) {
                ans.add(i);
            }
        }

        return ans;

    }

    boolean dfs(int i, int[] vis, int[][] graph, int[] path, int[] check) {

        vis[i] = 1;
        path[i] = 1;
        check[i] = 0;

        for(int j = 0; j<graph[i].length; j++) {
            int it = graph[i][j];
            if(vis[it] == 0) {
                if(dfs(it, vis, graph, path, check) == true) {
                    check[it] = 0;
                    return true;
                }
            }
            else {
                if(path[it] == 1) {
                    check[it] = 0;
                    return true;
                }
            }
        }

        path[i] = 0;
        check[i] = 1;

        return false;
    }
}


//TC : O(V+ E)
//SC : O(V+E)