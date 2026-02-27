package dsa.recursion;

import java.util.ArrayList;
import java.util.List;

class L8_Combinational_Sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ans1 = new ArrayList<>();
        rec(0,0,target,ans,ans1, candidates);
        return ans;
    }

    void rec(int i, int sum, int target, List<List<Integer>> ans, List<Integer> ans1, int[] candidates) {
        if(i==candidates.length) {
            if(sum == target) {
                ans.add(new ArrayList<>(ans1));
            }
            return;
        }

        if(sum + candidates[i] <= target) {
            sum += candidates[i];
            ans1.add(candidates[i]);
            rec(i, sum, target, ans, ans1, candidates);
            sum -= candidates[i];
            ans1.remove(ans1.size() - 1);

        }

        rec(i+1, sum, target, ans, ans1, candidates);

    }
}