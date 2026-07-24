package dsa.dp;

//similar to L37_Best_Time_To_Buy_And_Sell_3 but instead of 2 , k
public class L38_Best_Time_To_Buy_And_Sell_4 {
    public int maxProfit(int k, int[] prices) {
        int[][]  next = new int[2][k + 1];
        for(int i=prices.length - 1; i>= 0; i--) {
            int[][] curr = new int[2][k + 1];
            for(int isBought=1; isBought>=0; isBought--) {
                for(int cnt=k - 1; cnt>=0; cnt--) {
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

//TC : O(2*n*k)
//SC : O(2*k