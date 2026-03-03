package dsa.Arrays;

public class L4_Longest_SubArray_With_Sum_Equals_K {
    public int longestSubarray(int[] arr, int k) {
        // code here
        int left = 0;
        int right = 0;
        int ans = 0;
        int sum  = 0;

        while(right < arr.length) {
            sum += arr[right];
            while(sum > k) {
                sum -= arr[left];
                left++;
            }

            if(sum == k) {
                ans = Math.max(ans, right - left + 1);
            }

            right++;
        }
        return ans;

    }
}

//TC : O(n)
//SC : O(1)
// this will only work for positive int , for negative it wont work


// better if only pos else optimal if both pos and neg

//    public int longestSubarray(int[] arr, int k) {
//        // code here
//        int ans = 0;
//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(0,-1);
//        int sum  = 0;
//        for(int i=0; i<arr.length; i++) {
//            sum += arr[i];
//            int diff = sum - k;
//            if(map.containsKey(diff)) {
//                ans = Math.max(i-map.get(diff), ans);
//            }
//            if(!map.containsKey(sum)) {
//                map.put(sum, i);
//            }
//        }
//        return ans;
//
//    }


//TC : O(nlogn)
//SC : O(n)

// Brute Force

//class L4_Longest_SubArray_With_Sum_Equals_K {
//    public int longestSubarray(int[] arr, int k) {
//        // code here
//        int ans = 0 ;
//        for(int i=0; i< arr.length; i++) {
//            int sum = 0;
//            for(int j= i; j<arr.length; j++) {
//                sum += arr[j];
//                if(sum == k) {
//                    ans = Math.max(ans, j-i+1);
//                }
//            }
//        }
//        return ans;
//    }
//}

//TC : O(n^2)
//SC : O(1)


//