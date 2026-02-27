package dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class L9_Combination_Sum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ans1 = new ArrayList<>();
        Arrays.sort(candidates);
        rec(0,0, target, candidates, ans, ans1);
        return ans;
    }

    void rec (int i, int sum , int target, int[] candidates, List<List<Integer>> ans, List<Integer> ans1) {

        if(sum == target) {
            ans.add(new ArrayList<>(ans1));
            return;
        }



        for(int ind =i; ind < candidates.length; ind++) {
            if(i!= ind && candidates[ind] == candidates[ind - 1] ) {
                continue;
            }
            if(sum> target) {
                break;
            }
            sum += candidates[ind];
            ans1.add(candidates[ind]);
            rec(ind+1, sum, target, candidates, ans, ans1);
            sum -= candidates[ind];
            ans1.remove(ans1.size() - 1);

        }
    }
}
