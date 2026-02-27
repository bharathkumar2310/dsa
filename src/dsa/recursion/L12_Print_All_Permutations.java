package dsa.recursion;

import java.util.ArrayList;
import java.util.List;

class L12_Print_All_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] vis = new int[nums.length];
        List<Integer> ans1 = new ArrayList<>();
        rec(vis, ans, ans1, nums);

        return ans;
    }

    void rec(int[] vis, List<List<Integer>> ans, List<Integer> ans1, int[] nums) {

        if (ans1.size() == nums.length) {
            ans.add(new ArrayList<>(ans1));
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            if (vis[j] == 0) {
                vis[j] = 1;
                ans1.add(nums[j]);
                rec(vis, ans, ans1, nums);
                ans1.remove(ans1.size() - 1);
                vis[j] = 0;
            }
        }

    }
}
