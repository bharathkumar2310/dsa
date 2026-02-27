package dsa.bitManipulation;

import java.util.ArrayList;
import java.util.List;

class L4_Find_All_Subset_Power_Set {
    public List<List<Integer>> subsets(int[] nums) {
        int total = 1<<nums.length;
        List<List<Integer>>ans = new ArrayList<>();

        for(int i=0; i<total; i++) {
            List<Integer> ans1 = new ArrayList<>();
            for(int j=0; j<nums.length; j++) {
                int pow = 1<<j;
                if((i & pow) != 0) {
                    ans1.add(nums[j]);
                }
            }

            ans.add(ans1);
        }
        return ans;
    }
}
