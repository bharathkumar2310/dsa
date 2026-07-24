package dsa.stack;

import java.util.ArrayDeque;
import java.util.Deque;
// Add  Element to the first(make sure max element is at the bottom)
public class L16_Sliding_Window_Maximum {

    class Pair {
        int index;
        int ele;

        Pair(int index, int ele) {
            this.index = index;
            this.ele = ele;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Pair> dq = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];
        int l =0;
        for(int i=0; i<nums.length; i++) {
            if(!dq.isEmpty() && i - dq.peekLast().index >= k) {
                dq.pollLast();
            }

            while(!dq.isEmpty () && nums[i] > dq.peekFirst().ele) {
                dq.pollFirst();
            }
            dq.offerFirst(new Pair(i, nums[i]));

            if(i>= k-1) {
                ans[l++] =dq.peekLast().ele;
            }
        }

        return ans;
    }
}

//TC : O(n + n) ---> O(2n)
//SC : O(k) + O(n-k)