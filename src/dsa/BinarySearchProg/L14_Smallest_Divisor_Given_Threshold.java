package dsa.BinarySearchProg;

public class L14_Smallest_Divisor_Given_Threshold {
    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = 0;
        for(int num : nums) {
            end = Math.max(end, num);
        }
        int ans = Integer.MAX_VALUE;
        while(start <= end) {
            int mid = (start + end)/ 2;
            int ans1 = func(nums, mid);
            if(ans1 <= threshold) {
                ans = Math.min(ans, mid);
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }

        }
        return ans;
    }

    int func(int[] nums, int mid) {
        int ans =0;
        for(int i=0; i<nums.length; i++) {
            ans += Math.ceil((double)nums[i]/mid);
        }
        return ans;
    }
}

//TC : O(nlogn)
//SC : O(1)