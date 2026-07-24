package dsa.dp;

//same as L17_Count_SubSets_With_Sum_k

public class L18_Count_Partitions_With_Given_Difference {
    public int countPartitions(int[] arr, int diff) {
        int xPlusY = 0;
        for(int i=0; i<arr.length; i++) {
            xPlusY += arr[i];
        }
        int xMinusY = diff;

        int twoX = (xPlusY + xMinusY);
        if(twoX % 2 != 0) {
            return 0;
        }

        int x = twoX/2;
        return perfectSum(arr, x);

    }


    int perfectSum(int[] nums, int target) {
        // code here
        int[] next = new int[target + 1];
        next[target] = 1;

        for(int i=nums.length -1; i>=0; i--) {
            int[] curr = new int[target + 1];
            for(int j = target; j>=0; j--) {
                int pick =0;
                if(j + nums[i] <= target) {
                    pick = next[j + nums[i]];
                }

                int notPick = next[j];

                curr[j] = pick + notPick;
            }

            next = curr;
        }

        return next[0];
    }
}

//TC : O(n * x)
//SC : O(n)
