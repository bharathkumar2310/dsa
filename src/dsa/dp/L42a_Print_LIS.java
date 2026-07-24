package dsa.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class L42a_Print_LIS {
    public ArrayList<Integer> getLIS(int nums[]) {
        int[] dp = new int[nums.length];
        int[] hash = new int[nums.length];

        for(int k=0; k<hash.length; k++) {
            hash[k]= k;
        }
        int maxIndex = 0;
        Arrays.fill(dp, 1);
        int ans = 1;
        for(int i=0; i< nums.length; i++) {
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j]) {

                    if(dp[i] < 1+ dp[j]) {
                        dp[i] = 1+ dp[j];
                        hash[i] = j;
                    }

                    if(ans < dp[i]) {
                        ans = dp[i];
                        maxIndex = i;
                    }
                }
            }
        }

        ArrayList<Integer> ans1 = new ArrayList<>();

        while(hash[maxIndex] != maxIndex) {
            ans1.add(nums[maxIndex]);
            maxIndex = hash[maxIndex];
        }
        ans1.add(nums[maxIndex]);
        Collections.reverse(ans1);
        return ans1;
    }
}

//TC : O(n^2)
//SC : O(3n)