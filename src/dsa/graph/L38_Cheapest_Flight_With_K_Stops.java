package dsa.graph;

import java.util.*;

public class L38_Cheapest_Flight_With_K_Stops {
    class Pair {
        int index;
        int wt;
        int stops;

        Pair(int index, int wt, int stops) {
            this.index = index;
            this.wt = wt;
            this.stops = stops;
        }
    }


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<Pair>> adj = new ArrayList<>();
        Queue<Pair> pq = new LinkedList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<flights.length; i++) {
            int index1 = flights[i][0];
            int index2 = flights[i][1];
            int wt = flights[i][2];

            adj.get(index1).add(new Pair(index2, wt,0));
        }

        pq.add(new Pair(src,0, 0));
        int[] dist = new int[n];
        Arrays.fill(dist, (int)1e9);
        dist[src] = 0;


        while(!pq.isEmpty()) {

            Pair pair = pq.poll();
            int index = pair.index;
            int wt = pair.wt;
            int stops = pair.stops;

            if(stops > k) {
                continue;
            }

            for(Pair pair1 : adj.get(index)) {
                int index1 = pair1.index;
                int wt1 = pair1.wt;
                if(dist[index1] > wt1 + wt ) {
                    dist[index1] = wt1 + wt;
                    pq.add(new Pair(index1, dist[index1], stops + 1));
                }
            }




        }

        return dist[dst] == (int)1e9 ? -1 : dist[dst];
    }
}

//TC : O(E * K)
//SC : O(E + V)