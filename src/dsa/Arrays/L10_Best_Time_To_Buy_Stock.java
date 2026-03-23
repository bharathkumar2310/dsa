package dsa.Arrays;

public class L10_Best_Time_To_Buy_Stock {

    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        for(int i=1; i<prices.length; i++) {
            profit = Math.max(profit, prices[i] - buy);
            buy = Math.min(buy, prices[i]);
        }
        return profit;
    }
}

//TC : O(n)
//SC : O(1)