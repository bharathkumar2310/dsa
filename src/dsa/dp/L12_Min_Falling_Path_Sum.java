package dsa.dp;

public class L12_Min_Falling_Path_Sum {
    public int minFallingPathSum(int[][] mat) {
        // code here
        int ans  = Integer.MAX_VALUE;
        int[] next = new int[mat[0].length];

        for(int j=0; j<mat[0].length; j++) {

            next[j] =mat[mat.length -1][j];
        }

        for(int i=mat.length -2; i>=0; i--) {
            int[] curr = new int[mat[0].length];
            for(int j=mat[0].length -1; j>=0; j--) {
                int down = mat[i][j] + next[j];
                int diagLeft = Integer.MAX_VALUE;
                if(j - 1 >= 0) {
                    diagLeft = mat[i][j] + next[j-1];
                }
                int diagRight = Integer.MAX_VALUE;
                if(j+1 <mat[0].length) {
                    diagRight = mat[i][j] + next[j+1];
                }

                curr[j] = Math.min(down, Math.min(diagLeft, diagRight));
            }
            next = curr;
        }




        for(int j=0; j<mat[0].length; j++) {

            ans = Math.min(ans, next[j]);
        }

        return ans;
    }
}


//TC : O(n^2)
//SC : O(n)


//public int minFallingPathSum(int[][] mat) {
//    // code here
//    int ans  = Integer.MAX_VALUE;
//    int[][] dp = new int[mat.length][mat[0].length];
//
//    for(int j=0; j<mat[0].length; j++) {
//
//        dp[mat.length -1][j] =mat[mat.length -1][j];
//    }
//
//    for(int i=mat.length -2; i>=0; i--) {
//        for(int j=mat[0].length -1; j>=0; j--) {
//            int down = mat[i][j] + dp[i+1][j];
//            int diagLeft = Integer.MAX_VALUE;
//            if(j - 1 >= 0) {
//                diagLeft = mat[i][j] + dp[i+1][j-1];
//            }
//            int diagRight = Integer.MAX_VALUE;
//            if(j+1 <mat[0].length) {
//                diagRight = mat[i][j] + dp[i+1][j+1];
//            }
//
//            dp[i][j] = Math.min(down, Math.min(diagLeft, diagRight));
//        }
//    }
//
//
//
//
//    for(int j=0; j<mat[0].length; j++) {
//
//        ans = Math.min(ans, dp[0][j]);
//    }
//
//    return ans;
//}



//TC : O(n^2)
//SC : O(n^2 + n)




//public int minFallingPathSum(int[][] mat) {
//    // code here
//    int ans  = Integer.MAX_VALUE;
//    int[][] dp = new int[mat.length][mat[0].length];
//    for(int[] rows : dp) {
//        Arrays.fill(rows, -1);
//    }
//    for(int j=0; j<mat[0].length; j++) {
//
//        ans = Math.min(ans, rec(0, j, mat, dp));
//    }
//
//    return ans;
//}
//
//int rec(int i, int j, int[][] mat, int[][] dp) {
//    if(i== mat.length - 1) {
//        return mat[i][j];
//    }
//
//    if(dp[i][j] != -1) {
//        return dp[i][j];
//    }
//
//    int down = mat[i][j] + rec(i+1, j, mat, dp);
//    int diagLeft = Integer.MAX_VALUE;
//    if(j - 1 >= 0) {
//        diagLeft = mat[i][j] + rec(i+1, j-1, mat, dp);
//    }
//    int diagRight = Integer.MAX_VALUE;
//    if(j+1 <mat[0].length) {
//        diagRight = mat[i][j] + rec(i+1, j+1, mat, dp);
//    }
//
//    return dp[i][j] = Math.min(down, Math.min(diagLeft, diagRight));
//}

//TC : O(n^2)
//SC : O(n^2 + n)



//public int minFallingPathSum(int[][] mat) {
//    // code here
//    int ans  = Integer.MAX_VALUE;
//    for(int j=0; j<mat[0].length; j++) {
//        ans = Math.min(ans, rec(0, j, mat));
//    }
//
//    return ans;
//}
//
//int rec(int i, int j, int[][] mat) {
//    if(i== mat.length - 1) {
//        return mat[i][j];
//    }
//
//
//    int down = mat[i][j] + rec(i+1, j, mat);
//    int diagLeft = Integer.MAX_VALUE;
//    if(j - 1 >= 0) {
//        diagLeft = mat[i][j] + rec(i+1, j-1, mat);
//    }
//    int diagRight = Integer.MAX_VALUE;
//    if(j+1 <mat[0].length) {
//        diagRight = mat[i][j] + rec(i+1, j+1, mat);
//    }
//
//    return Math.min(down, Math.min(diagLeft, diagRight));
//}

//TC : O(n* 3^n)
//SC : O(n)