package dsa.dp;

public class L35_Best_Time_To_Buy_And_Sell_1 {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int maxProfit = 0;

        for(int i=1; i<prices.length; i++) {
            int profit = prices[i] - buy;
            maxProfit = Math.max(maxProfit, profit);
            buy = Math.min(buy,prices[i]);
        }

        return maxProfit;
    }
}

//TC : O(n)
//SC : O(n)