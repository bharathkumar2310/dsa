package dsa.Arrays;

import java.util.HashMap;
import java.util.Map;

public class L17_Count_SubArray_Sum_Equals_k {
    public int cntSubarrays(int[] arr, int k) {
        // code here
        int sum =0;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
            if(map.containsKey(sum - k)) {
                ans+= map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }
}


//TC : O(n)  or O(nlogn)--> based on map
//SC : O(n)