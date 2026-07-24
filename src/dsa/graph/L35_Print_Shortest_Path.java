package dsa.graph;

import java.util.*;

public class L35_Print_Shortest_Path {
    class Pair {
        int index;
        int wt;

        Pair(int index, int wt) {
            this.index = index;
            this.wt = wt;
        }
    }
    public ArrayList<Integer> shortestPath(int V, int[][] edges, int src, int dest) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<V + 1; i++) {
            adj.add(new ArrayList<>());
        }
        int[] dis = new int[V + 1];
        int[] parent = new int[V + 1];
        Arrays.fill(dis, (int)1e9);
        for(int i=0; i<V + 1; i++) {
            parent[i] = i;
        }

        for(int[] row : edges) {
            int first = row[0];
            int second = row[1];
            int wt = row[2];

            adj.get(first).add(new Pair(second, wt));
            adj.get(second).add(new Pair(first, wt));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.wt - y.wt);
        pq.add(new Pair(src, 0));
        dis[src] = 0;


        while(!pq.isEmpty()) {
            Pair pair = pq.poll();
            int index = pair.index;
            int wt = pair.wt;

            for(Pair it : adj.get(index)) {
                int itIndex = it.index;
                int itWt = it.wt;

                if(dis[index] + itWt < dis[itIndex] ) {
                    dis[itIndex] =  dis[index] + itWt;
                    pq.add(new Pair(itIndex, dis[itIndex]));
                    parent[itIndex] = index;
                }
            }

        }

        ArrayList<Integer> ans = new ArrayList<>();
        int j = dest;
        if(dis[j] == (int) 1e9) {
            ans.add(-1);
            return ans;
        }
        while(parent[j]!= j) {
            ans.add(j);
            j = parent[j];
        }
        ans.add(j);


        Collections.reverse(ans);
        return ans;


    }
}


//TC : O((E+V)logV)
//SC : O(E+V)