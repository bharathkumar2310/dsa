package dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class L5_BFS_Graph {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        Queue<Integer> q = new LinkedList<>();
        int[] vis = new int[adj.size()];

        q.add(0);
        vis[0] = 1;

        ArrayList<Integer> ans = new ArrayList<>();

        while(!q.isEmpty()) {

            Integer i = q.poll();
            ans.add(i);

            for(Integer it : adj.get(i)) {
                if(vis[it] == 0) {
                    q.add(it);
                    vis[it] = 1;
                }
            }

        }

        return ans;
    }
}

//TC : O(V + 2E)
//SC : O(V)