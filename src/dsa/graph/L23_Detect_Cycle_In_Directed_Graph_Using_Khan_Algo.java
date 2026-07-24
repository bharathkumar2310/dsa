package dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//same as L22_Khans_Algorithm
public class L23_Detect_Cycle_In_Directed_Graph_Using_Khan_Algo {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        int[] inDegree = new int[V];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++) {
            adj.add(new ArrayList<>());
        }
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

            for(Integer it : adj.get(ind)) {
                inDegree[it]--;
                if(inDegree[it] == 0) {
                    q.add(it);
                }
            }

        }

        for(int i=0; i<V; i++) {
            if(inDegree[i] != 0) {
                return true;
            }
        }

        return false;
    }
}

//TC : O(V + E)
//SC : O(V + E)