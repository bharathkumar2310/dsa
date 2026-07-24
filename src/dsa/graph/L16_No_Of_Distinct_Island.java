package dsa.graph;

import java.util.*;

public class L16_No_Of_Distinct_Island {
    class Pair {
        int row;
        int col;
        int parRow;
        int parCol;

        Pair(int row, int col, int parRow, int parCol) {
            this.row = row;
            this.col = col;
            this.parRow = parRow;
            this.parCol = parCol;
        }
    }

    public int countDistinctIslands(char[][] grid) {
        // code here
        Set<List<String>> ans = new HashSet<>();
        int[][] vis = new int[grid.length][grid[0].length];
        Queue<Pair> q = new LinkedList<>();
        int[] rowIndex = {-1,1,0,0};
        int[] colIndex = {0,0,-1,1};
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j< grid[0].length; j++) {
                if(grid[i][j] == 'L'  && vis[i][j] == 0) {
                    vis[i][j] = 1;
                    List<String> ans1 = new ArrayList<>();
                    q.add(new Pair(i, j, i, j));

                    while(!q.isEmpty()) {
                        Pair pair = q.poll();
                        int row = pair.row;
                        int col = pair.col;
                        int parRow = pair.parRow;
                        int parCol = pair.parCol;
                        int rowDiff = parRow - row;
                        int colDiff = parCol - col;

                        ans1.add(rowDiff +" "+colDiff);

                        for(int k=0; k<4; k++) {
                            int nrow = row + rowIndex[k];
                            int ncol = col + colIndex[k];

                            if(isValid(nrow, ncol, grid, vis)) {
                                vis[nrow][ncol] = 1;
                                q.add(new Pair(nrow, ncol, parRow, parCol));
                            }
                        }

                    }

                    ans.add(ans1);

                }

            }
        }

        return ans.size();
    }

    boolean isValid(int row, int col, char[][] grid, int[][] vis) {
        if(row >=0 && col >= 0 && row<grid.length && col < grid[0].length && grid[row][col] == 'L' && vis[row][col] == 0) {
            return true;
        }
        return false;
    }
}

//TC : O(R*C)
//SC : O(R*C)