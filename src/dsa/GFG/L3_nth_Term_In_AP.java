package dsa.GFG;

public class L3_nth_Term_In_AP {
    public static int nthTermOfAP(int a1, int a2, int n) {
        // code here
        int a = a1;
        int d = a2 - a1;
        return a + (n-1) * d;
    }
}

//TC : O(1)
//SC : O(1)
// a + (n-1) * d ---> for nth term
// (n/2) * (2*a + (n-1) *d)----> for sum
//or Sₙ = n/2 × (first + last)---> sum