package dsa.Arrays;

import java.util.HashSet;
import java.util.Set;

public class L13_Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }
        int count = 0;

        for(Integer val : set) {
            if(!set.contains(val - 1)) {
                int count1 = 1;
                int val1 = val;
                while(set.contains(val1 + 1)) {
                    count1++;
                    val1++;
                }
                count = Math.max(count, count1);
            }
        }
        return count;
    }
}
//TC : O(n + n) => O(n)  can be O(n^2) or O(nlogn) if we consider the worst case of hashset
//SC : O(n)




//public int longestConsecutive(int[] nums) {
//    Arrays.sort(nums);
//    int count = 0;
//    int count1 = 1;
//    if(nums.length == 0) {
//        return 0;
//    }
//
//    for(int i=1; i<nums.length ; i++) {
//        if(nums[i] - 1 == nums[i - 1]) {
//            count1++;
//        }
//        else if(nums[i] == nums[i-1]) {
//            continue;
//        }
//        else{
//            count = Math.max(count, count1);
//            count1 = 1;
//        }
//    }
//    count = Math.max(count, count1);
//    return count;
//}

//TC : O(nlogn + n) => O(nlogn)
//SC : O(1)
