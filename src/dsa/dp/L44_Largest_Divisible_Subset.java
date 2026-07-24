package dsa.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class L44_Largest_Divisible_Subset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        return getLIS(nums);
    }

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
                if(nums[i] % nums[j] == 0) {

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