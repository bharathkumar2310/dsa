package dsa.dp;

public class L6_House_Robber_2 {
    public int maxValue(int[] arr) {
        // code here

        if (arr.length == 1) {
            return arr[0];
        }

        return Math.max(rob(arr, arr.length -1, 1), rob(arr, arr.length -2, 0));

    }

    public int rob(int[] nums, int n , int st) {

        int next = 0;
        int next1 = 0;

        for(int i=n ; i>=st; i--) {
            int pick =  nums[i] + next1;
            int notPick = next;

            int curr = Math.max(pick,notPick);
            next1 = next;
            next = curr;
        }

        return next;
    }
}

//TC : O(2n)
//SC : O(1)