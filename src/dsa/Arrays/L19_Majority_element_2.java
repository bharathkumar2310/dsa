package dsa.Arrays;

import java.util.ArrayList;
import java.util.List;

public class L19_Majority_element_2 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int count1 =0;
        int count2 = 0;
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++) {
            if((count1 == 0 && second != nums[i]) || first == nums[i]) {
                count1++;
                first = nums[i];
            }

            else if((count2 == 0 && first != nums[i]) || second == nums[i]) {
                count2++;
                second = nums[i];
            }
            else{
                count1--;
                count2--;
            }
        }

        count1= 0;
        count2 = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == first) {
                count1++;
            }
            if(nums[i] == second) {
                count2++;
            }
        }
        if(count1 > nums.length/3 && first != Integer.MAX_VALUE) {
            ans.add(first);
        }
        if(count2 > nums.length/3 && second != Integer.MAX_VALUE) {
            ans.add(second);
        }
        return ans;
    }
}

//TC : O(2n)
//SC : O(1)