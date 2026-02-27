package dsa.BinarySearchProg;

public class L3_FirstAndLast_Occurance_Of_x {

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


// using upper bound and lower bound

//ArrayList<Integer> find(int nums[], int x) {
//    ArrayList<Integer> ans = new ArrayList<>();
//
//    int lb = lowerBound(nums, x);
//    int ub = upperBound(nums, x) - 1;
//
//    // First occurrence
//    ans.add(lb < nums.length && nums[lb] == x ? lb : -1);
//    // Last occurrence
//    ans.add(ub >= 0 && ub < nums.length && nums[ub] == x ? ub : -1);
//
//    return ans;
//}
//
//// First index where nums[i] >= target
//int lowerBound(int[] nums, int target) {
//    int start = 0, end = nums.length - 1;
//    int ans = nums.length;
//
//    while (start <= end) {
//        int mid = start + (end - start)/2;
//        if (nums[mid] >= target) {
//            ans = mid;
//            end = mid - 1;
//        } else {
//            start = mid + 1;
//        }
//    }
//    return ans;
//}
//
//// First index where nums[i] > target
//int upperBound(int[] nums, int target) {
//    int start = 0, end = nums.length - 1;
//    int ans = nums.length;
//
//    while (start <= end) {
//        int mid = start + (end - start)/2;
//        if (nums[mid] > target) {
//            ans = mid;
//            end = mid - 1;
//        } else {
//            start = mid + 1;
//        }
//    }
//    return ans;
//}