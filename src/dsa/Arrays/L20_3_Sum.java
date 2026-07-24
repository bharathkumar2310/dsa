package dsa.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L20_3_Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n-2; i++) {
            if(i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int k = i + 1;
            int l = n-1;
            while(k<l) {
                long sum = (long)nums[i] + nums[k] + nums[l];
                if(sum == 0) {
                    List<Integer> ans1 = new ArrayList<>();
                    ans1.add(nums[i]);
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
                else if(sum > 0) {
                    l--;
                }
                else {
                    k++;
                }
            }
        }
        return ans;
    }
}

//TC : O(nlogn + n^2)
//SC : O(1)




//public List<List<Integer>> threeSum(int[] nums) {
//    int n = nums.length;
//    int target = 0;
//    Arrays.sort(nums);
//    Set<List<Integer>> ans = new HashSet<>();
//    for (int i = 0; i < n - 1; i++) {
//        Set<Long> set = new HashSet<>();
//        for (int j = i + 1; j < n ; j++) {
//            long sum = 0L + nums[i] + nums[j];
//            long third = target - sum;
//            if (set.contains(third)) {
//                List<Integer> temp = Arrays.asList(
//                        nums[i],
//                        nums[j],
//                        (int) third);
//                Collections.sort(temp);
//                ans.add(temp);
//            }
//            set.add((long) nums[j]);
//        }
//    }
//
//    return new ArrayList<>(ans);
//}


//TC : O(n^2 * logn)
//SC : O(n)