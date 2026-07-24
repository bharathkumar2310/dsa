package dsa.graph;

import java.util.*;

public class L25_Eventual_Safe_Nodes_Using_Khan_Algo {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int[] inDegree = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<graph.length; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<graph.length; i++) {
            inDegree[i] = graph[i].length;

            for(int j=0; j<graph[i].length; j++) {
                adj.get(graph[i][j]).add(i);
            }
        }

        for(int i=0; i<graph.length; i++) {
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
        Collections.sort(ans);
        return ans;
    }
}

//TC : O(V + E + VlogV)
//SC : O(V + E)