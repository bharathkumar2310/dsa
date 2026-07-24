package dsa.graph;

import java.util.*;

public class L22_Khans_Algorithm {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        int[] inDegree = new int[V];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++) {
            adj.add(new ArrayList<>());
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<edges.length; i++) {
            int first = edges[i][0];
            int second = edges[i][1];
            inDegree[second]++;
            adj.get(first).add(second);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i =0; i<V; i++) {
            if(inDegree[i] == 0) {
                q.add(i);
            }
        }
        while(!q.isEmpty()) {
            Integer ind = q.poll();
            ans.add(ind);

            for(Integer it : adj.get(ind)) {
                inDegree[it]--;
                if(inDegree[it] == 0) {
                    q.add(it);
                }
            }

        }

        return ans;


    }
}

//TC : O(V + E)
//SC : O(V + E)