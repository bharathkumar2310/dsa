package dsa.dp;

public class L9_Grid_Unique_Path_2 {
    public int uniquePaths(int[][] grid) {
        // code here
        int[] next= new int[grid[0].length];



        next [grid[0].length -1] = 1;

        for(int i=grid.length -1; i>=0; i--) {
            int[] curr= new int[grid[0].length];
            for(int j= grid[0].length -1; j>=0; j--) {

                if(grid[i][j] == 1) {
                    curr [j] = 0;
                    continue;
                }

                if (i == grid.length - 1 && j == grid[0].length - 1) {
                    curr[j] = 1;
                    continue;
                }

                int right = 0;
                if(j+1<grid[0].length) {
                    right= curr[j+1];

                }
                int down = 0;

                if(i+1< grid.length) {
                    down = next[j];
                }

                curr[j] = right + down;
            }
            next =curr;
        }

        return next[0];
    }
}


//TC : O(m *n)
//SC : O(n)

//public int uniquePaths(int[][] grid) {
//    // code here
//    int[][] dp = new int[grid.length][grid[0].length];
//
//
//    dp[grid.length -1][grid[0].length -1] = 1;
//
//    for(int i=grid.length -1; i>=0; i--) {
//        for(int j= grid[0].length -1; j>=0; j--) {
//
//            if(grid[i][j] == 1) {
//                dp[i][j] = 0;
//                continue;
//            }
//
//            if (i == grid.length - 1 && j == grid[0].length - 1) {
//                continue;
//            }
//
//            int right = 0;
//            if(j+1<grid[0].length) {
//                right= dp[i][j+1];
//
//            }
//            int down = 0;
//
//            if(i+1< grid.length) {
//                down = dp[i+1][j];
//            }
//
//            dp[i][j] = right + down;
//        }
//    }
//
//    return dp[0][0];
//}


//TC : O(m *n)
//SC : O(m*n)

//public int uniquePaths(int[][] grid) {
//    // code here
//    int[][] dp = new int[grid.length][grid[0].length];
//    for(int[] rows : dp) {
//        Arrays.fill(rows, -1);
//    }
//    return rec(0,0, grid, dp);
//}
//
//int rec(int i, int j , int[][] grid, int[][] dp) {
//
//
//    if(grid[i][j] == 1) {
//        return 0;
//    }
//
//    if(i==grid.length - 1 && j==grid[0].length - 1) {
//        return 1;
//    }
//
//    if(dp[i][j] != -1) {
//        return dp[i][j];
//    }
//
//    int right = 0;
//    if(j+1<grid[0].length) {
//        right= rec(i, j+1, grid, dp);
//
//    }
//    int down = 0;
//
//    if(i+1< grid.length) {
//        down = rec(i+1, j, grid, dp);
//    }
//
//    return dp[i][j] = right + down;
//}


//TC : O(m *n)
//SC : O(m*n) + O(m+n)

//public int uniquePaths(int[][] grid) {
//    // code here
//    return rec(0,0, grid);
//}
//
//int rec(int i, int j , int[][] grid) {
//
//
//    if(grid[i][j] == 1) {
//        return 0;
//    }
//
//    if(i==grid.length - 1 && j==grid[0].length - 1) {
//        return 1;
//    }
//
//
//    int right = 0;
//    if(j+1<grid[0].length) {
//        right= rec(i, j+1, grid);
//
//    }
//    int down = 0;
//
//    if(i+1< grid.length) {
//        down = rec(i+1, j, grid);
//    }
//
//    return right + down;
//}


//TC : O(2^(m+n))
//SC : O(m+n)
