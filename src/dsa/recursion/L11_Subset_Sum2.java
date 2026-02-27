package dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class L11_Subset_Sum2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> ans1 = new ArrayList<>();
        rec(0, nums, ans, ans1);
        return ans;
    }

    void rec(int i, int[] nums, List<List<Integer>> ans, List<Integer> ans1){
        ans.add(new ArrayList<>(ans1));
        for (int j = i; j < nums.length; j++) {
            if (j != i && nums[j] == nums[j - 1]) {
                continue;
            }

            ans1.add(nums[j]);
            rec(j + 1, nums, ans, ans1);
            ans1.remove(ans1.size() - 1);
        }
    }
}
