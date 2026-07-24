package dsa.dp;


// same as L14_SubSet_Sum_Equals_Target
public class L15_Partition_Equals_Subset_sum {
    static boolean equalPartition(int arr[]) {
        // code here

        int totalSum = 0;
        for(int i=0; i<arr.length;i++) {
            totalSum+=arr[i];
        }

        if(totalSum % 2!= 0) {
            return false;
        }

        return isSubsetSum(arr, totalSum/2);

    }


    static boolean isSubsetSum(int arr[], int sum) {
        // code here

        boolean[] next = new boolean[sum + 1];
        next[sum] = true;

        for(int i= arr.length - 1; i>=0; i--) {
            boolean[] curr = new boolean[sum + 1];
            curr[sum] = true;
            for(int j=sum; j>=0; j--) {
                boolean pick = false;
                if(j + arr[i] <= sum) {
                    pick = next[j + arr[i]];

                }
                boolean notPick = next[j];
                curr[j] = pick || notPick ;
            }
            next = curr;
        }

        return next[0];
    }
}


//TC : O(n* sum)
//SC : O(sum)