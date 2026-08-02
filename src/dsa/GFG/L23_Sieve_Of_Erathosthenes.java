package dsa.GFG;

import java.util.*;

public class L23_Sieve_Of_Erathosthenes {

    public ArrayList<Integer> sieve(int n) {
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

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=2;i<=n; i++) {
            if(isPrime[i]) {
                ans.add(i);
            }
        }

        return ans;

    }
}

//TC : O(n log log n)

//SC : O(n)