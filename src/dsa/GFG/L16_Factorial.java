package dsa.GFG;

public class L16_Factorial {
    int factorial(int n) {
        // code here
        int ans  = 1;
        for(int i=2; i<=n; i++) {
            ans*=i;
        }
        return ans;
    }
}

//TC : O(n)
//SC : O(1)


//int factorial(int n) {
//    return rec(n);
//}
//
//int rec(int n) {
//    if(n==0) {
//        return 1;
//    }
//    return n * rec(n-1);
//}


//TC : O(n)
//SC : O(n)