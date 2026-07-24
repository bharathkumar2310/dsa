package dsa.dp;

public class L40_Best_Time_To_Buy_And_Sell_With_Transaction_Fee {

    public int maxProfit(int[] prices, int fee) {
        int[] next = new int[2];
        for(int i=prices.length - 1; i>=0; i--) {
            int[] curr = new int[2];
            for(int isBought=1; isBought>=0; isBought--) {
                if(isBought == 0) {
                    curr[isBought] = Math.max(-prices[i] + next[1] , next[0]);
                }
                else {
                    curr[isBought] = Math.max(prices[i] + next[0] - fee , next[1]);

                }
            }

            next = curr;
        }
        return next[0];
    }
}

//TC : O(n *2)
//SC : O(6)



//public int maxProfit(int[] prices, int fee) {
//    return rec(0, prices, false, fee);
//}
//
//int rec(int i, int[] prices, boolean isBought, int fee) {
//    if(i >= prices.length) {
//        return 0;
//    }
//
//    if(isBought == false) {
//        return  Math.max(-prices[i] + rec(i+1, prices, true, fee) , rec(i+1, prices, false, fee));
//    }
//
//    return Math.max(prices[i] + rec(i+1, prices, false, fee) - fee , rec(i+1, prices, true, fee));
//
//
//}

//TC : O(2^n)
//SC : O(n)