package dsa.BinarySearchProg;

public class L9_Find_Peak_Element {
    public int findPeakElement(int[] nums) {
        int start = 1;
        int end = nums.length - 2;

        if(nums.length == 1 || nums[0] > nums[1]) {
            return 0;
        }
        if(nums[nums.length -1] > nums[nums.length - 2] ) {
            return nums.length -1;
        }

        while(start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] > nums[mid -1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if(nums[mid] > nums[mid - 1]) {
                start = mid + 1;
            }
            else {
                end = mid -1;
            }
        }

        return -1;
    }
}

//TC : O(logn)
//SC : O(1)