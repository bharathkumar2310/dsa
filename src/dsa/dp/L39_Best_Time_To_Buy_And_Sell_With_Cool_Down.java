package dsa.dp;

// similar to L38_Best_Time_To_Buy_And_Sell_2 with cooldown
public class L39_Best_Time_To_Buy_And_Sell_With_Cool_Down {
    public int maxProfit(int[] prices) {
        int[] next1 = new int[2];
        int[] next2 = new int[2];
        for(int i=prices.length - 1; i>=0; i--) {
            int[] curr = new int[2];
            for(int isBought=1; isBought>=0; isBought--) {
                if(isBought == 0) {
                    curr[isBought] = Math.max(-prices[i] + next1[1] , next1[0]);
                }
                else {
                    curr[isBought] = Math.max(prices[i] + next2[0] , next1[1]);

                }
            }

            next2 = next1;
            next1 = curr;
        }
        return next1[0];
    }

}

//TC : O(n *2)
//SC : O(6)

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
//    return Math.max(prices[i] + rec(i+2, prices, false) , rec(i+1, prices, true));
//
//
//}

//TC : O(2^n)
//SC : O(n)