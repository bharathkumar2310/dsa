package dsa.dp;

public class L23_Unbounded_Knapsack {
    public int knapSack(int val[], int wt[], int capacity) {
        // code here
        int[] next = new int[capacity + 1];

        for(int i= val.length - 1; i>=0; i--) {
            int[] curr = new int[capacity + 1];
            for(int j=0; j<= capacity; j++) {
                int take = 0;

                if(j - wt[i] >= 0) {
                    take = val[i] + curr[j - wt[i]];
                }

                int notTake = next[j];

                curr[j] = Math.max(take, notTake);
            }
            next = curr;
        }
        return next[capacity];
    }
}



//TC : O(n * capacity)
//SC : O(capacity)



//public int knapSack(int val[], int wt[], int capacity) {
//    // code here
//    int[][] dp = new int[val.length + 1][capacity + 1];
//
//    for(int i= val.length - 1; i>=0; i--) {
//        for(int j=0; j<= capacity; j++) {
//            int take = 0;
//
//            if(j - wt[i] >= 0) {
//                take = val[i] + dp[i][j - wt[i]];
//            }
//
//            int notTake = dp[i+1][j];
//
//            dp[i][j] = Math.max(take, notTake);
//        }
//    }
//    return dp[0][capacity];
//}



//TC : O(n * capacity)
//SC : O(n * capacity)




//public int knapSack(int val[], int wt[], int capacity) {
//    // code here
//    int[][] dp = new int[val.length + 1][capacity + 1];
//    for(int[] rows : dp) {
//        Arrays.fill(rows , -1);
//    }
//    return rec(0,val, wt, capacity, dp);
//}
//
//int rec(int i , int[] val , int[] wt, int capacity, int[][] dp) {
//    if(i==val.length) {
//        return 0;
//    }
//
//    if(dp[i][capacity] != -1) {
//        return dp[i][capacity];
//    }
//
//    int take = 0;
//
//    if(capacity - wt[i] >= 0) {
//        take = val[i] + rec(i, val, wt, capacity - wt[i], dp);
//    }
//
//    int notTake = rec(i+1, val, wt, capacity, dp);
//
//    return dp[i][capacity] = Math.max(take, notTake);
//}


//TC : O(n * capacity)
//SC : O(n * capacity + n+ capacity)

//public int knapSack(int val[], int wt[], int capacity) {
//    // code here
//    return rec(0,val, wt, capacity);
//}
//
//int rec(int i , int[] val , int[] wt, int capacity) {
//    if(i==val.length) {
//        return 0;
//    }
//
//    int take = 0;
//
//    if(capacity - wt[i] >= 0) {
//        take = val[i] + rec(i, val, wt, capacity - wt[i]);
//    }
//
//    int notTake = rec(i+1, val, wt, capacity);
//
//    return Math.max(take, notTake);
//}

//TC : O(2^n)
//SC : O(n+capacity)