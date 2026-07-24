package dsa.graph;

import java.util.LinkedList;
import java.util.Queue;

public class L10_Rotten_Oranges {
    class Pair {
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int orangesRot(int[][] mat) {
        // code here
        Queue<Pair> q = new LinkedList<>();
        int totalNonRotten = 0;
        int ans = 0;
        int[][] vis = new int[mat.length][mat[0].length];
        for(int i=0;i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                if(mat[i][j] == 1) {
                    totalNonRotten++;
                }
                else if(mat[i][j] == 2) {
                    q.add(new Pair(i, j));
                }
            }
        }
        int[] rowInd = {-1,1,0,0};
        int[] colInd = {0,0,-1, 1};

        while(!q.isEmpty()) {
            int size = q.size();
            boolean rotten = false;
            for(int i=0; i<size; i++) {
                Pair pair = q.poll();
                int row = pair.row;
                int col = pair.col;

                for(int k=0; k<rowInd.length; k++) {
                    int nRow = row + rowInd[k];
                    int nCol = col + colInd[k];

                    if(nRow >=0 && nRow < mat.length && nCol >= 0 && nCol <mat[0].length && mat[nRow][nCol] == 1 && vis[nRow][nCol] == 0) {
                        mat[nRow][nCol] = 2;
                        vis[nRow][nCol] = 1;
                        q.add(new Pair(nRow, nCol));
                        totalNonRotten--;
                        rotten = true;
                    }
                }
            }

            if(rotten) {
                ans++;
            }
        }
        if(totalNonRotten == 0) {
            return ans;
        }

        return -1;
    }
}


//TC : O(R*C)
//SC : O(R*C)

// no need vis here as we only check for non rootten right and it will become rotten