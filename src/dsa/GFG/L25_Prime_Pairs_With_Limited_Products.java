package dsa.GFG;

import java.util.*;

public class L25_Prime_Pairs_With_Limited_Products {
    public int[] primePairs(int n) {
        // Code here
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
                for(int j=2; i*j<=n; j++) {
                    if(isPrime[j]) {
                        ans.add(i);
                        ans.add(j);
                    }
                }
            }
        }

        int[] ans1 = new int[ans.size()];
        for(int i=0; i<ans.size(); i++) {
            ans1[i]= ans.get(i);
        }

        return ans1;

    }
}


//TC : O(n log log n)

//SC : O(n)