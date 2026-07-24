package dsa.dp;

public class L36_Best_Time_To_Buy_And_Sell_2 {


    public int maxProfit(int[] prices) {
        int[] next = new int[2];
        for(int i=prices.length - 1; i>=0; i--) {
            int[] curr = new int[2];
            for(int isBought=1; isBought>=0; isBought--) {
                if(isBought == 0) {
                    curr[isBought] = Math.max(-prices[i] + next[1] , next[0]);
                }
                else {
                    curr[isBought] = Math.max(prices[i] + next[0] , next[1]);

                }
            }

            next = curr;
        }
        return next[0];
    }
}

//TC : O(2n)
//SC : O(1)


//public int maxProfit(int[] prices) {
//    return rec(0, prices, false);
//}
//
//int rec(int i, int[] prices, boolean isBought) {
//    if(i >= prices.length) {
//        return 0;
//    }
//
//    if(isBought == false) {
//        return  Math.max(-prices[i] + rec(i+1, prices, true) , rec(i+1, prices, false));
//    }
//
//    return Math.max(prices[i] + rec(i+1, prices, false) , rec(i+1, prices, true));
//
//
//}


//TC : O(2n)
//SC : O(2n)

//public int maxProfit(int[] prices) {
//    int[][] dp =new int[prices.length][2];
//    for(int i=0; i<dp.length; i++) {
//        for(int j=0; j<2; j++) {
//            dp[i][j] = -1;
//        }
//    }
//    return rec(0, prices, 0, dp);
//}
//
//int rec(int i, int[] prices, int isBought, int[][] dp) {
//    if(i >= prices.length) {
//        return 0;
//    }
//
//    if( dp[i][isBought] != -1) {
//        return  dp[i][isBought];
//    }
//
//    if(isBought == 0) {
//        return  dp[i][isBought] = Math.max(-prices[i] + rec(i+1, prices, 1, dp) , rec(i+1, prices, 0, dp));
//    }
//
//    return  dp[i][isBought] = Math.max(prices[i] + rec(i+1, prices, 0, dp) , rec(i+1, prices, 1, dp));
//
//}

//TC : O(2n)
//SC : O(2n + n)



//public int maxProfit(int[] prices) {
//    return rec(0, prices, false);
//}
//
//int rec(int i, int[] prices, boolean isBought) {
//    if(i >= prices.length) {
//        return 0;
//    }
//
//    if(isBought == false) {
//        return  Math.max(-prices[i] + rec(i+1, prices, true) , rec(i+1, prices, false));
//    }
//
//    return Math.max(prices[i] + rec(i+1, prices, false) , rec(i+1, prices, true));
//
//
//}


//TC : O(2^n)
//SC : O(n)