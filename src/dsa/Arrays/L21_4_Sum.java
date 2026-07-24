package dsa.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L21_4_Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n-3; i++) {
            if(i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for(int j=i+1; j<n-2; j++) {
                if(j!=i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int k = j + 1;
                int l = n-1;
                while(k<l) {
                    long sum = (long)nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum == target) {
                        List<Integer> ans1 = new ArrayList<>();
                        ans1.add(nums[i]);
                        ans1.add(nums[j]);
                        ans1.add(nums[k]);
                        ans1.add(nums[l]);
                        ans.add(ans1);
                        k++;
                        l--;
                        while(k<l && nums[k] == nums[k-1]) {
                            k++;
                        }
                        while(l> k && nums[l] == nums[l+1]) {
                            l--;
                        }
                    }
                    else if(sum > target) {
                        l--;
                    }
                    else {
                        k++;
                    }
                }
            }
        }
        return ans;
    }
}

//TC : O(n^3 + nlogn)
//SC : O(1)







//public List<List<Integer>> fourSum(int[] nums, int target) {
//
//    int n = nums.length;
//    Arrays.sort(nums);
//    Set<List<Integer>> ans = new HashSet<>();
//    for (int i = 0; i < n - 3; i++) {
//        for (int j = i + 1; j < n - 2; j++) {
//            Set<Long> set = new HashSet<>();
//            for (int k = j + 1; k < n; k++) {
//                long sum = 0L + nums[i] + nums[j] + nums[k];
//                long fourth = target - sum;
//                if (set.contains(fourth)) {
//                    List<Integer> temp = Arrays.asList(
//                            nums[i],
//                            nums[j],
//                            nums[k],
//                            (int) fourth);
//                    Collections.sort(temp);
//                    ans.add(temp);
//                }
//                set.add((long) nums[k]);
//            }
//        }
//    }
//
//    return new ArrayList<>(ans);
//}


//TC : O(n^3* logn)
//SC : O(n)