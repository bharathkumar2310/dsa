package dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L11_Detect_Cycle_In_Undirected_Graph_BFS {
    class Pair {
        int index;
        int parent;

        Pair(int index, int parent) {
            this.index = index;
            this.parent = parent;
        }
    }


    public boolean isCycle(int V, int[][] edges) {
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

        int[] vis = new int[V];

        for(int i=0; i<V; i++) {
            if(vis[i] == 0) {
                Queue<Pair> q = new LinkedList<>();
                q.add(new Pair(i, -1));
                vis[i] = 1;

                while(!q.isEmpty()) {
                    Pair pair = q.poll();
                    int ind = pair.index;
                    int parent = pair.parent;

                    for(Integer it : adj.get(ind)) {
                        if(vis[it] != 0 && it != parent) {
                            return true;
                        }
                        else if(vis[it] == 0) {
                            vis[it] = 1;
                            q.add(new Pair(it, ind));
                        }
                    }

                }
            }
        }



        return false;

    }
}


//TC : O(V+ 2E)
//SC : O(V+E)