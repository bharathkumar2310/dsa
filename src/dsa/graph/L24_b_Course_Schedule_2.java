package dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L24_b_Course_Schedule_2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        return isCyclic(numCourses, prerequisites);
    }

    public int[] isCyclic(int V, int[][] edges) {
        // code here
        int[] inDegree = new int[V];
        int[] ans = new int[V];
        int ansIndex = 0;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++) {
            int first = edges[i][0];
            int second = edges[i][1];
            inDegree[first]++;
            adj.get(second).add(first);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i =0; i<V; i++) {
            if(inDegree[i] == 0) {
                q.add(i);
                ans[ansIndex++] = i;
            }
        }
        while(!q.isEmpty()) {
            Integer ind = q.poll();

            for(Integer it : adj.get(ind)) {
                inDegree[it]--;
                if(inDegree[it] == 0) {
                    q.add(it);
                    ans[ansIndex++] = it;
                }
            }

        }

        for(int i=0; i<V; i++) {
            if(inDegree[i] != 0) {
                return new int[0];
            }
        }

        return ans;
    }
}


//TC : O(V + E)
//SC : O(V + E)