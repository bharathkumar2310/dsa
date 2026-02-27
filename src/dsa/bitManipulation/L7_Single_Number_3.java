package dsa.bitManipulation;

class L7_Single_Number_3 {
    public int[] singleNumber(int[] nums) {
        int xor = 0;

        for(int i=0; i<nums.length; i++) {
            xor ^= nums[i];
        }

        int bit=0;
        while((xor & (1<<bit))== 0) {
            bit++;
        }

        int first = 0;
        int second = 0;

        for(int i=0; i<nums.length; i++) {
            if((nums[i] & (1<<bit))  == 0) {
                first ^= nums[i];
            }
            else{
                second ^= nums[i];
            }
        }

        int[] ans = new int[2];
        ans[0] = first;
        ans[1] = second;
        return ans;


    }
}
