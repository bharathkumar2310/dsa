package dsa.stack;

import java.util.Stack;

public class L11_Asteroid_Collisions {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<asteroids.length; i++) {
            while(!st.isEmpty() && asteroids[i] <0 && st.peek() > 0 && Math.abs(asteroids[i]) > st.peek()) {
                st.pop();
            }
            if(!st.isEmpty() && asteroids[i] <0 && st.peek() > 0 && Math.abs(asteroids[i]) == st.peek()) {
                st.pop();
                continue;
            }
            if(st.isEmpty() || asteroids[i] > 0 || st.peek() < 0) {
                st.push(asteroids[i]);
            }

        }

        int[] ans = new int[st.size()];
        int i= st.size() -1;
        while(!st.isEmpty()) {
            ans[i--] = st.pop();
        }
        return ans;
    }
}

//TC : O(n) + O(n) = O(2n)
//SC : O(n)
