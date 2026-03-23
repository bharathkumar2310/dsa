package dsa.Arrays;

import java.util.Arrays;

public class L11_Next_Permutation {
    public void nextPermutation(int[] nums) {
        int decIndex = -1;
        for(int i = nums.length - 2; i>=0; i--) {
            if(nums[i] < nums[i+1]) {
                decIndex = i;
                break;
            }
        }
        int swapIndex =  -1;
        if(decIndex == -1) {
            reverse(nums);
            return;
        }
        for(int i=nums.length - 1; i>=0; i--) {
            if(nums[i] > nums[decIndex]) {
                swap(i, decIndex, nums);
                break;
            }
        }
        Arrays.sort(nums, decIndex + 1, nums.length);
    }

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums) {
        int i=0;
        int j = nums.length -1;
        while(i<j) {
            swap(i,j, nums);
            i++;
            j--;
        }
    }
}

//TC : O(2n + nlogn) => O(nlogn)
//SC : O(1)

