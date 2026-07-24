package dsa.graph;

import java.util.*;

public class L32_Dijkstra_Algorithm {
    class Pair {
        int index;
        int wt;

        Pair(int index, int wt) {
            this.index = index;
            this.wt = wt;
        }
    }

    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here

        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<V; i++) {
            adj.add(new ArrayList<>());
        }
        int[] dis = new int[V];
        Arrays.fill(dis, (int)1e9);

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
                }
            }

        }

        return dis;


    }
}

//TC : O((E+V)logV)
//SC : O(E+V)