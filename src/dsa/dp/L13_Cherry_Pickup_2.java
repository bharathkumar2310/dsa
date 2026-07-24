package dsa.dp;

public class L13_Cherry_Pickup_2 {
    public int cherryPickup(int[][] grid) {
        int[][] next = new int[grid[0].length][grid[0].length];

        for(int j=0; j<grid[0].length; j++) {
            for(int j1=0;j1<grid[0].length; j1++) {
                if(j==j1) {
                    next[j][j1] = grid[grid.length -1][j];
                } else {
                    next[j][j1] = grid[grid.length -1][j] + grid[grid.length -1][j1];
                }
            }
        }


        for(int i=grid.length -2; i>=0; i--) {
            int[][] curr = new int[grid[0].length][grid[0].length];
            for(int j=grid[0].length -1; j>=0; j--) {
                for(int j1=grid[0].length -1; j1 >= 0; j1--) {

                    int ans = 0;
                    for(int ind = -1; ind <= 1; ind++) {
                        for(int ind1 =-1; ind1<=1; ind1++) {
                            int ncol = j+ind;
                            int ncol1 = j1+ind1;

                            if(ncol >= 0 && ncol < grid[0].length && ncol1>=0 && ncol1<grid[0].length) {
                                if(j== j1) {
                                    ans = Math.max(ans, grid[i][j] + next[ncol][ncol1]);
                                } else {
                                    ans = Math.max(ans, grid[i][j] + grid[i][j1]+ next[ncol][ncol1]);
                                }
                            }

                        }
                    }
                    curr[j][j1] = ans;
                }
            }
            next =curr;
        }
        return next[0][grid[0].length -1];
    }
}


//TC : O(n*m^2)
//SC : O(m^2)

//public int cherryPickup(int[][] grid) {
//    int[][][] dp = new int[grid.length + 1][grid[0].length][grid[0].length];
//
//    for(int j=0; j<dp[0].length; j++) {
//        for(int j1=0;j1<dp[0].length; j1++) {
//            if(j==j1) {
//                dp[grid.length -1][j][j1] = grid[grid.length -1][j];
//            } else {
//                dp[grid.length -1][j][j1] = grid[grid.length -1][j] + grid[grid.length -1][j1];
//            }
//        }
//    }
//
//
//    for(int i=dp.length -2; i>=0; i--) {
//        for(int j=dp[0].length -1; j>=0; j--) {
//            for(int j1=dp[0].length -1; j1 >= 0; j1--) {
//
//                int ans = 0;
//                for(int ind = -1; ind <= 1; ind++) {
//                    for(int ind1 =-1; ind1<=1; ind1++) {
//                        int ncol = j+ind;
//                        int ncol1 = j1+ind1;
//
//                        if(ncol >= 0 && ncol < grid[0].length && ncol1>=0 && ncol1<grid[0].length) {
//                            if(j== j1) {
//                                ans = Math.max(ans, grid[i][j] + dp[i+1][ncol][ncol1]);
//                            } else {
//                                ans = Math.max(ans, grid[i][j] + grid[i][j1]+ dp[i+1][ncol][ncol1]);
//                            }
//                        }
//
//                    }
//                }
//                dp[i][j][j1] = ans;
//            }
//        }
//    }
//    return dp[0][0][grid[0].length -1];
//}


//TC : O(n*m^2)
//SC : O(n*m^2)



//public int cherryPickup(int[][] grid) {
//    int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];
//    for(int i=0; i<dp.length; i++) {
//        for(int j=0; j<dp[0].length; j++) {
//            for(int k=0; k<dp[0].length; k++) {
//                dp[i][j][k] = -1;
//            }
//        }
//    }
//    return rec(0,0,grid, 0, grid[0].length - 1, dp);
//}
//
//int rec(int i, int j, int[][] grid, int i1, int j1, int[][][] dp) {
//
//    if(i==grid.length -1 && i1 == grid.length - 1) {
//        if(j==j1) {
//            return grid[i][j];
//        }
//        return grid[i][j] + grid[i1][j1];
//    }
//
//    if(dp[i][j][j1] != -1) {
//        return dp[i][j][j1];
//    }
//
//    int ans = 0;
//    for(int ind = -1; ind <= 1; ind++) {
//        for(int ind1 =-1; ind1<=1; ind1++) {
//            int ncol = j+ind;
//            int ncol1 = j1+ind1;
//
//            if(ncol >= 0 && ncol < grid[0].length && ncol1>=0 && ncol1<grid[0].length) {
//                if(j== j1) {
//                    ans = Math.max(ans, grid[i][j] + rec(i+1, ncol, grid, i1+1, ncol1, dp));
//                } else {
//                    ans = Math.max(ans, grid[i][j] + grid[i1][j1]+ rec(i+1, ncol, grid, i1+1, ncol1, dp));
//                }
//            }
//
//        }
//    }
//
//    return dp[i][j][j1] = ans;
//
//}

//TC : O(n*m^2)
//SC : O(n*m^2)


//public int cherryPickup(int[][] grid) {
//
//    return rec(0,0,grid, 0, grid[0].length - 1);
//}
//
//int rec(int i, int j, int[][] grid, int i1, int j1) {
//
//    if(i==grid.length -1 && i1 == grid.length - 1) {
//        if(j==j1) {
//            return grid[i][j];
//        }
//        return grid[i][j] + grid[i1][j1];
//    }
//
//    int ans = 0;
//    for(int ind = -1; ind <= 1; ind++) {
//        for(int ind1 =-1; ind1<=1; ind1++) {
//            int ncol = j+ind;
//            int ncol1 = j1+ind1;
//
//            if(ncol >= 0 && ncol < grid[0].length && ncol1>=0 && ncol1<grid[0].length) {
//                if(j== j1) {
//                    ans = Math.max(ans, grid[i][j] + rec(i+1, ncol, grid, i1+1, ncol1));
//                } else {
//                    ans = Math.max(ans, grid[i][j] + grid[i1][j1]+ rec(i+1, ncol, grid, i1+1, ncol1));
//                }
//            }
//
//        }
//    }
//
//    return ans;
//
//}

//TC : O(9^n)
//SC : O(n)