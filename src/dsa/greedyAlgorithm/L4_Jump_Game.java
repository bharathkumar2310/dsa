package dsa.greedyAlgorithm;

class L4_Jump_Game {
    public boolean canJump(int[] nums) {
        int maxIndex =0;
        for(int i=0;i<nums.length ; i++) {
            if(maxIndex < i) {
                return false;
            }
            maxIndex  = Math.max(maxIndex, i+ nums[i]);
        }
        return true;
    }
}

//TC : O(n)
//SC : O(1)