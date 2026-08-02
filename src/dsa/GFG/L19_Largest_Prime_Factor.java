package dsa.GFG;

// for a even factor only 2 is prime so first divide completely by 2
//Search only up to √n, because every factor greater than √n has a corresponding factor smaller than √n.
//Whenever a factor is found, divide it out completely, shrinking n and removing that prime forever.
//The remaining n (if > 2) is the largest prime factor, because all smaller prime factors have already been removed.


// just keep dividing be each no till they are not divided
public class L19_Largest_Prime_Factor {
    static int largestPrimeFactor(int n) {
        // code here
        int ans = 0;

        while(n%2 == 0) {
            ans = 2;
            n = n/2;
        }

        for(int i=3; i*i<=n; i= i+2) {
            while(n%i == 0) {
                ans = i;
                n=n/i;
            }
        }

        if(n > 2) {
            return n;
        }

        return ans;

    }
}



//for (int i = 2; i * i <= n; i++) {
//        while (n % i == 0) {
//ans = i;
//n /= i;
//    }
//            }
//
//            if (n > 1)
//ans = n;

//this is also correct but if we just divide by 2 itself first we no need to check for other even nos

//TC : O(root n)
//SC : O(1)

//static int largestPrimeFactor(int n) {
//    // code here
//    int ans = 0;
//    for(int i=2; i<=n; i++) {
//        if(isPrimeFactor(i,n)) {
//            ans = i;
//        }
//    }
//    return ans;
//}
//
//static boolean isPrimeFactor(int i, int n) {
//    if(n % i != 0) {
//        return false;
//    }
//
//    for(int j=2; j*j <=i; j++) {
//        if(i%j == 0) {
//            return false;
//        }
//    }
//    return true;
//}

//TC : O(n root n)
//SC : O(1)