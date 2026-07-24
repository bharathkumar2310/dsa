package dsa.dp;

public class L37_Best_Time_To_Buy_And_Sell_3 {
    public int maxProfit(int[] prices) {
        int[][]  next = new int[2][3];
        for(int i=prices.length - 1; i>= 0; i--) {
            int[][] curr = new int[2][3];
            for(int isBought=1; isBought>=0; isBought--) {
                for(int cnt=1; cnt>=0; cnt--) {
                    if(isBought == 0) {
                        curr[isBought][cnt] = Math.max(-prices[i] + next[1][cnt] , next[0][cnt]);

                    } else {

                        curr[isBought][cnt] =  Math.max(prices[i] + next[0][cnt+1] , next[1][cnt]);

                    }
                }
            }
            next = curr;

        }
        return next[0][0];
    }
}

//TC : O(4n)
//SC : O(6)


//public int maxProfit(int[] prices) {
//    int[][][] dp = new int[prices.length + 1][2][3];
//    for(int i=prices.length - 1; i>= 0; i--) {
//        for(int isBought=1; isBought>=0; isBought--) {
//            for(int cnt=1; cnt>=0; cnt--) {
//                if(isBought == 0) {
//                    dp[i][isBought][cnt] = Math.max(-prices[i] + dp[i+1][1][cnt] , dp[i+1][0][cnt]);
//
//                } else {
//
//                    dp[i][isBought][cnt] =  Math.max(prices[i] + dp[i+1][0][cnt+1] ,dp[i+1][1][cnt]);
//
//
//                }
//            }
//        }
//    }
//    return dp[0][0][0];
//}

//TC : O(6n)
//SC : O(6n)


//public int maxProfit(int[] prices) {
//    int[][][] dp = new int[prices.length][2][3];
//    for(int i=0; i<dp.length; i++) {
//        for(int j=0; j<2; j++) {
//            for(int k=0; k<3; k++) {
//                dp[i][j][k] = -1;
//            }
//        }
//    }
//    return rec(0, prices, 0, 0, dp);
//}
//
//int rec(int i, int[] prices, int isBought, int cnt, int[][][] dp) {
//    if(i >= prices.length) {
//        return 0;
//    }
//
//    if(dp[i][isBought][cnt] != -1) {
//        return dp[i][isBought][cnt];
//    }
//
//    if(isBought == 0) {
//        if(cnt < 2) {
//            return dp[i][isBought][cnt] = Math.max(-prices[i] + rec(i+1, prices, 1, cnt, dp) , rec(i+1, prices, 0, cnt, dp));
//        }
//        return dp[i][isBought][cnt] = 0;
//    }
//
//    return dp[i][isBought][cnt] =  Math.max(prices[i] + rec(i+1, prices, 0, cnt + 1, dp) , rec(i+1, prices, 1, cnt, dp));
//
//
//}

//TC : O(6n)
//SC : O(6n + n)

//public int maxProfit(int[] prices) {
//    return rec(0, prices, false, 0);
//}
//
//int rec(int i, int[] prices, boolean isBought, int cnt) {
//    if(i >= prices.length) {
//        return 0;
//    }
//
//    if(isBought == false) {
//        if(cnt < 2) {
//            return  Math.max(-prices[i] + rec(i+1, prices, true, cnt) , rec(i+1, prices, false, cnt));
//        }
//        return 0;
//    }
//
//    return Math.max(prices[i] + rec(i+1, prices, false, cnt + 1) , rec(i+1, prices, true, cnt));
//
//
//}

//TC : O(2^n)
//SC :O(n)