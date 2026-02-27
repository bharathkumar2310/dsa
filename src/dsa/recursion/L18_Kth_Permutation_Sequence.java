package dsa.recursion;

import java.util.ArrayList;
import java.util.List;

class L18_Kth_Permutation_Sequence {
    public String getPermutation(int n, int k) {
        StringBuilder ans = new StringBuilder();
        List<Integer> num = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            num.add(i);
        }
        rec(n, k - 1, ans, num);
        return ans.toString();
    }

    void rec(int n,int k, StringBuilder ans, List<Integer> num) {
        if(n==0) {
            return;
        }

        int  fact = fact(n-1);
        ans.append(num.get(k / fact));
        num.remove(k / fact);
        rec(n-1, k%fact, ans, num);
    }


    int fact(int i) {
        int mul =1;
        for(int j=2; j<=i; j++) {
            mul *= j;
        }
        return mul;
    }
}
