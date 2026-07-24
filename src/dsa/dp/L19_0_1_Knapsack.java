package dsa.dp;

public class L19_0_1_Knapsack {
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int[] next = new int[W + 1];
        for(int i=val.length - 1; i>=0; i--) {
            int[] curr = new int[W + 1];
            for(int j=W; j>=0; j--) {
                int pick = 0;

                if(j-wt[i] >= 0 ) {
                    pick = val[i] + next[j-wt[i]];
                }

                int notPick = next[j];

                curr[j] = Math.max(pick, notPick);
            }
            next = curr;
        }
        return next[W];
    }
}

//TC : O(n * W)
//SC : O(n)

//public int knapsack(int W, int val[], int wt[]) {
//    // code here
//    int[][] dp = new int[val.length + 1][W + 1];
//    for(int i=val.length - 1; i>=0; i--) {
//        for(int j=W; j>=0; j--) {
//            int pick = 0;
//
//            if(j-wt[i] >= 0 ) {
//                pick = val[i] + dp[i + 1][j-wt[i]];
//            }
//
//            int notPick = dp[i+1][j];
//
//            dp[i][j] = Math.max(pick, notPick);
//        }
//    }
//    return dp[0][W];
//}

//TC : O(n * W)
//SC : O(n * W)


//public int knapsack(int W, int val[], int wt[]) {
//    // code here
//    int[][] dp = new int[val.length + 1][W + 1];
//    for(int[] rows : dp) {
//        Arrays.fill(rows, -1);
//    }
//    return rec(0, W, val, wt, dp);
//}
//
//int rec(int i, int W, int[] val, int[] wt, int[][] dp) {
//    if(i>=wt.length) {
//        return 0;
//    }
//
//    if(dp[i][W] != -1) {
//        return dp[i][W];
//    }
//
//    int pick = 0;
//
//
//    if(W-wt[i] >= 0 ) {
//        pick = val[i] + rec(i + 1, W-wt[i],val, wt, dp);
//    }
//
//    int notPick = rec(i + 1, W,val, wt, dp);
//
//    return dp[i][W] = Math.max(pick, notPick);
//}


//TC : O(n * W) + O(n)
//SC : O(n * W)


//public int knapsack(int W, int val[], int wt[]) {
//    // code here
//    return rec(0, W, val, wt);
//}
//
//int rec(int i, int W, int[] val, int[] wt) {
//    if(i>=wt.length) {
//        return 0;
//    }
//
//    int pick = 0;
//
//    if(W-wt[i] >= 0 ) {
//        pick = val[i] + rec(i + 1, W-wt[i],val, wt);
//    }
//
//    int notPick = rec(i + 1, W,val, wt);
//
//    return Math.max(pick, notPick);
//}

//TC : O(2^n)
//SC : O(n)