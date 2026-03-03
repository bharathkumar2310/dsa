package dsa.Arrays;

public class L9_ReArrange_Array_Elements_By_Sign {

    public int[] rearrangeArray(int[] nums) {
        int a = 0;
        int b= 1;
        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0) {
                ans[a] = nums[i];
                a = a+2;
            }
            else{
                ans[b] = nums[i];
                b = b+2;
            }
        }
        return ans;
    }
}

//TC : O(n)
//SC : O(n)

//When positive and negative numbers are unequal in count, we can use additional space to separate them into two lists, merge them alternately, and then add the leftover elements from the larger list.
// similar to worst case with slight modification


// worstcase
//public int[] rearrangeArray(int[] nums) {
//    int[] pos = new int[nums.length / 2];
//    int[] neg = new int[nums.length / 2];
//
//    int i = 0;
//    int j = 0;
//
//    for (int k = 0; k < nums.length; k++) {
//        if (nums[k] > 0) {
//            pos[i++] = nums[k];
//        } else {
//            neg[j++] = nums[k];
//        }
//    }
//
//    int[] ans = new int[nums.length];
//    for (int a = 0; a < pos.length; a++) {
//        ans[a * 2] = pos[a];
//
//    }
//    for (int a = 0; a < neg.length; a++) {
//        ans[a * 2 + 1] = neg[a];
//
//    }
//    return ans;
//}

//TC : O(n + n) => O(2n)
//SC : O(2n)