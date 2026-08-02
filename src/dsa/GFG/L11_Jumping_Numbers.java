package dsa.GFG;

import java.util.*;

//Generate all possible Jumping Numbers using BFS, starting from digits 1 to 9 (and 0 is handled separately).
//For every number, append only lastDigit-1 and lastDigit+1, because only those keep the adjacent digit difference equal to 1.
//Keep the largest generated number ≤ n; BFS ensures every valid jumping number is generated exactly once.



public class L11_Jumping_Numbers {
    static long jumpingNums(long n) {
        // code here
        if(n<=10) {
            return n;
        }
        Queue<Integer> q= new LinkedList<>();
        for (int i=1; i<=10; i++) {
            q.add(i);
        }
        int ans = 0;

        while(!q.isEmpty()) {
            Integer no = q.poll();
            if(no > n) {
                continue;
            }

            ans = Math.max(ans, no);

            int last = no%10;

            if(last > 0) {
                int newNo1 = no * 10 + last - 1;
                q.add(newNo1);
            }
            if(last < 9) {
                int newNo2 = no * 10 + last + 1;
                q.add(newNo2);
            }

        }

        return ans;
    }
}

// TC : O(k)
//SC : O(k)

//k --> no of jumping nos generated till n