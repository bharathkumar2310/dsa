package dsa.GFG.puzzle;

public class L9_Is_Triangular {
    int isTriangular(int n) {
        // code here
        long x = 1L + 8L * n;
        long root = (long) Math.sqrt(x);

        if (root * root != x) {
            return 0;
        }

        return ((root - 1) % 2 == 0) ? 1 : 0;
    }
}

//TC : O(1)
//SC : O(1)


// sum is about is the n a sum of first k natural nos are not

//so k(k+1)/2 = n
// if you solve this quafratic equation you will get

//k = (-1 + root(1+8n))/2

//QE formula x = (-b +(or)- root(b^2-4ac))/2



//int isTriangular(int n) {
//    // code here
//    int ans = 0;
//    for(int i=1; i<=n; i++) {
//        ans+=i;
//        if(ans == n) {
//            return 1;
//        }
//        if(ans >n) {
//            return 0;
//        }
//    }
//    return 0;
//}

//TC : O(root n)
//SC : O(1)