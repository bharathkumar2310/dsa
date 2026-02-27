package dsa.slidingWindow2pointer;

import java.util.HashMap;
import java.util.Map;

class L5_Fruit_Into_Basket {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int ans = 0;
        while(right < fruits.length) {
            freqMap.put(fruits[right], freqMap.getOrDefault(fruits[right], 0) + 1);
            if(freqMap.size() > 2) {
                freqMap.put(fruits[left], freqMap.getOrDefault(fruits[left], 0) - 1);
                if(freqMap.get(fruits[left]) == 0) {
                    freqMap.remove(fruits[left]);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
