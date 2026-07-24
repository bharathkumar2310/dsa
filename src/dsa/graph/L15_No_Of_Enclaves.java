package dsa.graph;

import java.util.LinkedList;
import java.util.Queue;

public class L15_No_Of_Enclaves {
    class Pair {
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int numEnclaves(int[][] grid) {
        return fill(grid);
    }
    public int fill(int[][] grid) {
        // Code here
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(i==0 || i== grid.length - 1 || j==0 || j==grid[0].length -1) {
                    if(grid[i][j] == 1) {
                        q.add(new Pair(i, j));
                        grid[i][j] = -1;
                    }
                }
            }
        }

        int[] rowIndex = {-1,1,0,0};
        int[] colIndex = {0,0,-1,1};

        while(!q.isEmpty()) {
            Pair pair = q.poll();
            int row = pair.row;
            int col = pair.col;

            for(int k=0;k<4;k++) {
                int nrow = row + rowIndex[k];
                int ncol = col + colIndex[k];

                if(isValid(nrow, ncol, grid)) {
                    q.add(new Pair(nrow, ncol));
                    grid[nrow][ncol] = -1;
                }
            }
        }

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == -1) {
                    grid[i][j] = 1;
                }
                else if(grid[i][j] == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    boolean isValid(int row, int col, int[][] grid) {
        if(row >=0 && col >= 0 && row<grid.length && col < grid[0].length && grid[row][col] == 1) {
            return true;
        }
        return false;
    }
}


//TC : O(R*C)
//SC : O(R*C)