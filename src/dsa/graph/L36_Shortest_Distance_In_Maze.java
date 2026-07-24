package dsa.graph;

import java.util.*;

public class L36_Shortest_Distance_In_Maze {
    class Pair {
        int row;
        int col;
        int wt;

        Pair(int row, int col, int wt) {
            this.row = row;
            this.col = col;
            this.wt = wt;
        }
    }

    public int shortestPath(int[][] mat, int[] src, int[] dest) {
        // code here
        int srcRow = src[0];
        int srcCol = src[1];
        int destRow = dest[0];
        int destCol = dest[1];

        if(mat[srcRow][srcCol] == 0 || mat[destRow][destCol] == 0) {
            return -1;
        }

        int[][] dist = new int[mat.length][mat[0].length];
        for(int[] row : dist) {
            Arrays.fill(row, (int) 1e9);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.wt - y.wt);
        pq.add(new Pair(srcRow, srcCol, 0));
        dist[srcRow][srcCol] = 0;

        int[] rowIndex = {-1,1,0,0};
        int[] colIndex = {0,0,-1,1};

        while(!pq.isEmpty()) {
            Pair pair = pq.poll();
            int row = pair.row;
            int col = pair.col;
            int wt = pair.wt;

            if(wt > dist[row][col]) {
                continue;
            }

            for(int k=0;k<4; k++) {
                int nRow = rowIndex[k] + row;
                int nCol = colIndex[k] + col;
                if(nRow >= 0 && nRow<mat.length && nCol>=0 && nCol <mat[0].length && mat[nRow][nCol] == 1 && dist[nRow][nCol] > 1 + dist[row][col]) {
                    dist[nRow][nCol] = 1 + dist[row][col];
                    pq.add(new Pair(nRow, nCol, dist[nRow][nCol]));
                }
            }
        }

        return dist[destRow][destCol];
    }
}

//TC : O(n^2logn)
//SC : O(N^2)

//N^2 = R*C

// here we dont need prioirty queue itself we can use queue directly(simple bfs)
// because the distance is 1