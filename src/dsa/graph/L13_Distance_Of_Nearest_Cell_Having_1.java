package dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class L13_Distance_Of_Nearest_Cell_Having_1 {
    class Pair {
        int row;
        int col;
        int cnt;

        Pair(int row, int col, int cnt) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
        }
    }


    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for(int j=0; j<grid[0].length; j++) {
                row.add(0);
                if(grid[i][j] == 1) {
                    q.add(new Pair(i,j, 0));
                    vis[i][j] = 1;
                }

            }
            ans.add(row);
        }

        int[] rowInd = {-1, 1, 0, 0};
        int[] colInd = {0, 0, -1, 1};


        while(!q.isEmpty()) {

            Pair pair = q.poll();
            int row = pair.row;
            int col = pair.col;
            int cnt = pair.cnt;

            ans.get(row).set(col, cnt);

            for(int k=0; k<4; k++) {
                int nRow = row + rowInd[k];
                int nCol = col + colInd[k];

                if(nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length && vis[nRow][nCol] == 0) {
                    q.add(new Pair(nRow, nCol, cnt+1));
                    vis[nRow][nCol] = 1;
                }

            }
        }

        return ans;
    }
}

//TC : O(R*C)
//SC : O(R*C)