package dsa.graph;

import java.util.LinkedList;
import java.util.Queue;

public class L14_Sorrounded_Regions_Replace_O_With_X {
    class Pair {
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public void fill(char[][] grid) {
        // Code here
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[grid.length][grid[0].length];

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(i==0 || i== grid.length - 1 || j==0 || j==grid[0].length -1) {
                    if(grid[i][j] == 'O') {
                        q.add(new Pair(i, j));
                        grid[i][j] = '-';
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
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol));
                    grid[nrow][ncol] = '-';
                }
            }
        }

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '-') {
                    grid[i][j] = 'O';
                }
                else if(grid[i][j] == 'O') {
                    grid[i][j] = 'X';
                }
            }
        }
    }

    boolean isValid(int row, int col, char[][] grid) {
        if(row >=0 && col >= 0 && row<grid.length && col < grid[0].length && grid[row][col] == 'O') {
            return true;
        }
        return false;
    }
}


//TC : O(R*C)
//SC : O(R*C)