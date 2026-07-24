package dsa.graph;

import java.util.*;

public class L37_Path_With_Minimum_Effort {
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
    public int minCostPath(int[][] mat) {
        // code here
        int[][] dis = new int[mat.length][mat[0].length];
        for(int[] row : dis) {
            Arrays.fill(row, (int)1e9);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.wt - y.wt);
        pq.add(new Pair(0,0,0));
        dis[0][0] = 0;

        int[] rowIndex = {-1,1,0,0};
        int[] colIndex = {0,0,-1,1};

        while(!pq.isEmpty()) {
            Pair pair = pq.poll();
            int row = pair.row;
            int col = pair.col;
            int wt = pair.wt;


            if(row == mat.length -1 && col == mat[0].length - 1) {
                return dis[row][col];
            }

            if (wt > dis[row][col]) {
                continue;
            }


            for(int k=0;k<4;k++) {
                int nRow = rowIndex[k] + row;
                int nCol = colIndex[k] + col;
                if(nRow >= 0 && nRow<mat.length && nCol>=0 && nCol <mat[0].length) {
                    int newDist = Math.max(dis[row][col], Math.abs(mat[nRow][nCol] - mat[row][col]));
                    if(dis[nRow][nCol] > newDist ) {
                        dis[nRow][nCol] = newDist;
                        pq.add(new Pair(nRow, nCol, newDist));
                    }
                }
            }
        }

        return dis[mat.length -1][mat[0].length -1];
    }
}


//TC : O( R*Clog(R*C))
//SC : O(R*C)