package dsa.slidingWindow2pointer;

import java.util.HashMap;
import java.util.Map;

class L11_SubArray_With_K_Diff_Integers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithLessThanOrEqualToKDistinct(nums, k) - subarraysWithLessThanOrEqualToKDistinct(nums, k-1);
    }


    public int subarraysWithLessThanOrEqualToKDistinct(int[] nums, int k) {
        if(k<=0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int ans = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();

        while(right < nums.length) {
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right] , 0) + 1);
            while(freqMap.size() > k) {
                freqMap.put(nums[left], freqMap.getOrDefault(nums[left] , 0) - 1);
                if(freqMap.get(nums[left]) <= 0) {
                    freqMap.remove(nums[left]);
                }
                left++;
            }

            ans += right - left + 1;
            right++;
        }
        return ans;
    }

}


//TC : O( 2* 2 n)
//SC : O(n)
