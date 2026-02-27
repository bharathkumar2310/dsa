package dsa.BinarySearchProg;
// similar to L3_FirstAndLast_Occurance_Of_x
class L3_No_Of_Ocuurances {
    int countFreq(int[] arr, int target) {
        // code here
        int[] ans = searchRange(arr, target);
        if(ans[0] == -1 || ans[1] == -1) {
            return 0;
        }
        return ans[1] - ans[0] + 1;
    }


    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        int one = first(nums, target);
        int two = last(nums, target);

        ans[0] = one;
        ans[1] = two;

        return ans;
    }

    int first(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == target) {
                ans = mid;

            }
            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    int last(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == target) {
                ans = mid;
            }
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}

//TC : O(2logn)
//SC : O(1)