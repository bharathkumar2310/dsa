package dsa.graph;

import java.util.LinkedList;
import java.util.Queue;

public class L8_Number_Of_Islands {
    class Pair {
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int numIslands(char[][] grid) {
        int[][] vis = new int[grid.length][grid[0].length];
        Queue<Pair> q = new LinkedList<>();
        int ans = 0;
        for(int i=0; i< grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(vis[i][j] == 0 && grid[i][j] == '1') {
                    ans++;
                    q.add(new Pair(i,j));
                    vis[i][j] = 1;
                    int[] rowInd = {-1,1,0,0};
                    int[] colInd = {0,0,-1, 1};
                    while(!q.isEmpty()) {
                        Pair pair = q.poll();
                        int row = pair.row;
                        int col = pair.col;

                        for(int k=0; k<rowInd.length; k++) {
                            int nRow = row+rowInd[k];
                            int nCol= col+colInd[k];
                            if(nRow >= 0 && nRow < grid.length && nCol >=0 && nCol <grid[0].length && grid[nRow][nCol] == '1' && vis[nRow][nCol] == 0) {
                                q.add(new Pair(nRow, nCol));
                                vis[nRow][nCol] = 1;
                            }
                        }
                    }
                }
            }
        }

        return ans;
    }
}

//TC : O(R*C)
//SC : O(R*C)

