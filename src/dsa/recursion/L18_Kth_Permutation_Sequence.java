package dsa.recursion;

import java.util.ArrayList;
import java.util.List;

class L18_Kth_Permutation_Sequence {

    public String getPermutation(int n, int k) {
        k--;
        StringBuilder ans = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        int fact = 1;
        for(int i=1; i<=n; i++) {
            fact *= i;
            list.add(i);
        }

        while(list.size() != 0) {
            int x = fact/list.size();
            int ind = k/x;
            int val = list.get(ind);
            ans.append(String.valueOf(val));
            list.remove(ind);
            k = k%x;
            fact = fact/(list.size() + 1);
        }

        return ans.toString();
    }

}

//TC : O(n^2)// because we also remove
//SC : O(n)

//public String getPermutation(int n, int k) {
//    StringBuilder ans = new StringBuilder();
//    List<Integer> num = new ArrayList<>();
//    for(int i=1; i<=n; i++) {
//        num.add(i);
//    }
//    rec(n, k - 1, ans, num);
//    return ans.toString();
//}
//
//void rec(int n,int k, StringBuilder ans, List<Integer> num) {
//    if(n==0) {
//        return;
//    }
//
//    int  fact = fact(n-1);
//    ans.append(num.get(k / fact));
//    num.remove(k / fact);
//    rec(n-1, k%fact, ans, num);
//}
//
//
//int fact(int i) {
//    int mul =1;
//    for(int j=2; j<=i; j++) {
//        mul *= j;
//    }
//    return mul;
//}