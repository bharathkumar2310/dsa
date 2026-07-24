package dsa.dp;

//Simialr to L9_Grid_Unique_Path_2 without obstacle
public class L10_Min_Path_Sum {
    public int minPathSum(int[][] grid) {
        int[] next= new int[grid[0].length];



        next [grid[0].length -1] = grid[grid.length -1][grid[0].length -1];

        for(int i=grid.length -1; i>=0; i--) {
            int[] curr= new int[grid[0].length];
            for(int j= grid[0].length -1; j>=0; j--) {


                if (i == grid.length - 1 && j == grid[0].length - 1) {
                    curr[j] = grid[grid.length -1][grid[0].length -1];
                    continue;
                }

                int right = Integer.MAX_VALUE;
                if(j+1<grid[0].length) {
                    right= grid[i][j] + curr[j+1];

                }
                int down = Integer.MAX_VALUE;

                if(i+1< grid.length) {
                    down = grid[i][j] + next[j];
                }

                curr[j] = Math.min(right, down);
            }
            next =curr;
        }

        return next[0];

    }
}
