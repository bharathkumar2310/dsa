package dsa.GFG;

public class L22_is_Prime {
    static boolean isPrime(int n) {
        // code here
        if(n == 0 || n==1) {
            return false;
        }
        for(int i=2; i*i<=n; i++) {
            if(n%i==0) {
                return false;
            }
        }

        return true;
    }
}


//TC : O(root n)
//SC : O(1)

//We can skip even nos after checking 2
//static boolean isPrime(int n) {
//    if (n <= 1) return false;
//    if (n == 2) return true;
//    if (n % 2 == 0) return false;
//
//    for (int i = 3; i * i <= n; i += 2) {
//        if (n % i == 0)
//            return false;
//    }
//
//    return true;
//}