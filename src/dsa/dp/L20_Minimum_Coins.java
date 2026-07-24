package dsa.dp;

public class L20_Minimum_Coins {
    public int coinChange(int[] coins, int amount) {

        int[] next = new int[amount + 1];

        for(int i=0; i<=amount; i++) {
            next[i] = (int) 1e9;
        }

        next[0] = 0;

        for(int i=coins.length - 1; i>=0; i--) {
            int[] curr = new int[amount + 1];
            curr[0] = 0;
            for(int j=0; j<= amount; j++) {
                int pick = (int) 1e9;
                if(j - coins[i] >= 0) {
                    pick = 1 + curr[j - coins[i]];
                }
                int notPick = next[j];


                curr[j] = Math.min(pick, notPick);

            }
            next = curr;
        }
        int ans =  next[amount];
        return ans == (int) 1e9 ? -1 : ans;
    }
}

//TC : O(n * amount)
//SC : O(amount)



//public int coinChange(int[] coins, int amount) {
//
//    int[][] dp = new int[coins.length + 1][amount + 1];
//
//    for(int i=0; i<=amount; i++) {
//        dp[coins.length][i] = (int) 1e9;
//    }
//
//    for(int i=0; i<=coins.length; i++) {
//        dp[i][0] = 0;
//    }
//
//    for(int i=coins.length - 1; i>=0; i--) {
//        for(int j=0; j<= amount; j++) {
//            int pick = (int) 1e9;
//            if(j - coins[i] >= 0) {
//                pick = 1 + dp[i][j - coins[i]];
//            }
//            int notPick = dp[i+1][j];
//
//
//            dp[i][j] = Math.min(pick, notPick);
//
//        }
//    }
//    int ans =  dp[0][amount];
//    return ans == (int) 1e9 ? -1 : ans;
//}

//TC : O(n * amount)
//SC : O(n * amount )

//public int coinChange(int[] coins, int amount) {
//
//    int[][] dp = new int[coins.length + 1][amount + 1];
//    for(int[] rows : dp) {
//        Arrays.fill(rows, -1);
//    }
//    int ans =  rec(0, coins, amount, dp);
//    return ans == (int) 1e9 ? -1 : ans;
//}
//
//int rec(int i, int[] coins, int amount, int[][] dp) {
//
//    if(i>=coins.length) {
//        return (int)1e9;
//    }
//
//    if(amount == 0) {
//        return 0;
//    }
//
//    if(dp[i][amount] != -1) {
//        return dp[i][amount];
//    }
//
//    int pick = (int) 1e9;
//    if(amount - coins[i] >= 0) {
//        pick = 1 + rec(i,coins, amount - coins[i], dp);
//    }
//    int notPick = rec(i+1, coins, amount, dp);
//
//
//    return dp[i][amount] = Math.min(pick, notPick);
//}

//TC : O(n * amount)
//SC : O(n * amount + n)

//public int coinChange(int[] coins, int amount) {
//    int ans =  rec(0, coins, amount);
//    return ans == (int) 1e9 ? -1 : ans;
//}
//
//int rec(int i, int[] coins, int amount) {
//
//    if(i>=coins.length) {
//        return (int)1e9;
//    }
//
//    if(amount == 0) {
//        return 0;
//    }
//
//    int pick = (int) 1e9;
//    if(amount - coins[i] >= 0) {
//        pick = 1 + rec(i,coins, amount - coins[i]);
//    }
//    int notPick = rec(i+1, coins, amount);
//
//
//    return Math.min(pick, notPick);
//}

//TC : O(2^ (n+amount))
//SC : O(n)