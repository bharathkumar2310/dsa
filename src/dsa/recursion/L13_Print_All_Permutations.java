package dsa.recursion;

import java.util.ArrayList;
import java.util.List;

class L13_Print_All_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>ans = new ArrayList<>();

        rec(0, nums, ans);
        return ans;
    }

    void rec(int i, int[] nums, List<List<Integer>> ans) {

        if(i == nums.length - 1) {
            List<Integer> ans1 = new ArrayList<>();
            for(int k=0; k<nums.length; k++) {
                ans1.add(nums[k]);
            }
            ans.add(ans1);
            return;
        }


        for(int j=i; j<nums.length; j++) {
            swap(i,j,nums);
            rec(i+1,nums, ans);
            swap(i,j,nums);
        }
    }

    void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}