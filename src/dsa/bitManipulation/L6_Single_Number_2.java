package dsa.bitManipulation;

class L6_Single_Number_2 {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;

        for(int i=0; i<nums.length; i++) {
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;
    }
}


//public int singleNumber(int[] nums) {
//    int ans = 0;
//    for(int i=0; i<32; i++) {
//        int count = 0;
//        int pow = 1<<i;
//
//        for(int j=0; j< nums.length; j++) {
//
//            int val = nums[j] & pow;
//            if(val != 0) {
//                count++;
//            }
//        }
//        if(count % 3 == 1) {
//            ans = ans | (pow);
//
//        }
//    }
//    return ans;
//}



//public int singleNumber(int[] nums) {
//    Arrays.sort(nums);
//    int j = 1;
//    int ans = -(int)1e9;
//    while(j<nums.length) {
//        if(nums[j] != nums[j-1]) {
//            ans = nums[j-1];
//            break;
//        }
//        j=j+3;
//    }
//
//    return ans!=-(int)1e9 ? ans : nums[nums.length -1];
//}