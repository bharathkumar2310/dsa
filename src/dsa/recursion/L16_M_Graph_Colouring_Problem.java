package dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class L16_M_Graph_Colouring_Problem {
    boolean graphColoring(int v, int[][] edges, int m) {
        // code here
        List<List<Integer>> adj  = new ArrayList<>();
        for(int i=0; i<v; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] colour = new int[v];
        Arrays.fill(colour, -1);

        return dfs(0, v, adj, m, colour);


    }


    boolean dfs(int i, int n , List<List<Integer>> adj, int m, int[] colour) {

        if(i==n) {
            return true;
        }

        for(int k=0; k<m; k++) {
            if (isPossible(i,adj, colour, k)) {
                colour[i] = k;
                if (dfs(i+1, n, adj, m, colour)) {
                    return true;
                }
                colour[i] = -1;
            }

        }
        return false;
    }


    boolean isPossible(int i, List<List<Integer>> adj, int[] colour, int k) {
        for(Integer it : adj.get(i)) {
            if(colour[it] == k) {
                return false;
            }
        }
        return true;
    }

}


//TC : O(m^V) ---> m : noOfColours , V ---> no of nodes
//SC : O(V + E) ---> creating adjGraph


