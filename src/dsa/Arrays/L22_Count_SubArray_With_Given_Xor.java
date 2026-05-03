package dsa.Arrays;

import java.util.HashMap;
import java.util.Map;

public class L22_Count_SubArray_With_Given_Xor {
    public long subarrayXor(int arr[], int k) {
        // code here
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int ans = 0;
        int xor = 0;

        for(int i = 0; i<arr.length; i++) {
            xor^=arr[i];
            int xor1= xor^ k;
            if(map.containsKey(xor1)) {
                ans += map.get(xor1);
            }

            map.put(xor, map.getOrDefault(xor,0) +1 );
        }
        return ans;
    }
}

//TC : O(n)  or O(nlogn)--> based on map
//SC : O(n)