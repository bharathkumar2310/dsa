package dsa.GFG;

import java.util.*;

public class L24_Sum_Of_Prime_Nos_Till_N {
    public int prime_Sum(int n) {
        // code here
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1]  = false;

        for(int i=2; i*i<=n; i++) {
            if (isPrime[i]){
                for(int j= i*i; j<=n; j+=i) {
                    isPrime[j] = false;
                }
            }

        }

        int sum = 0;

        for(int i=2;i<=n; i++) {
            if(isPrime[i]) {
                sum += i;
            }
        }

        return sum;
    }
}


//TC : O(n log log n)

//SC : O(n)