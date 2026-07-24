package dsa.dp;

public class L22_Coin_Change_2 {

    public int change(int amount, int[] coins) {
        int [] next = new int[amount + 1];
        next[0] = 1;
        for(int i=coins.length - 1; i>=0; i--) {
            int [] curr = new int[amount + 1];
            for(int j=0; j<= amount; j++) {
                int pick = 0;
                if(j - coins[i] >= 0) {
                    pick = curr[j - coins[i]];
                }
                int notPick = next[j];
                curr[j] = pick + notPick;
            }

            next = curr;
        }
        return next[amount];
    }
}


//TC : O(n * amount)
//SC : O(amount)

//public int change(int amount, int[] coins) {
//    int [][] dp = new int[coins.length + 1][amount + 1];
//    dp[coins.length][0] = 1;
//    for(int i=coins.length - 1; i>=0; i--) {
//        for(int j=0; j<= amount; j++) {
//            int pick = 0;
//            if(j - coins[i] >= 0) {
//                pick = dp[i][j - coins[i]];
//            }
//            int notPick = dp[i+1][j];
//            dp[i][j] = pick + notPick;
//        }
//    }
//    return dp[0][amount];
//}

//TC : O(n * amount)
//SC : O(n * amount )

//public int change(int amount, int[] coins) {
//    int [][] dp = new int[coins.length + 1][amount + 1];
//    for(int[] rows : dp) {
//        Arrays.fill(rows, -1);
//    }
//    return rec(0, amount, coins, dp);
//}
//
//
//int rec(int i, int amount, int[] coins, int[][] dp) {
//    if(i== coins.length) {
//        if(amount == 0) {
//            return 1;
//        }
//        return 0;
//    }
//
//    if(dp[i][amount] != -1) {
//        return dp[i][amount];
//    }
//
//    int pick = 0;
//
//
//    if(amount - coins[i] >= 0) {
//        pick = rec(i, amount - coins[i] , coins, dp);
//    }
//
//    int notPick = rec(i+1, amount, coins, dp);
//
//    return dp[i][amount] = pick + notPick;
//}

//TC : O(n * amount)
//SC : O(n * amount + n + amount)


//public int change(int amount, int[] coins) {
//
//    return rec(0, amount, coins);
//}
//
//
//int rec(int i, int amount, int[] coins) {
//    if(i== coins.length) {
//        if(amount == 0) {
//            return 1;
//        }
//        return 0;
//    }
//
//    int pick = 0;
//
//
//    if(amount - coins[i] >= 0) {
//        pick = rec(i, amount - coins[i] , coins);
//    }
//
//    int notPick = rec(i+1, amount, coins);
//
//    return pick + notPick;
//}

//TC : O(2^n)
//SC : O(m + amount + )