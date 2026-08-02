package dsa.GFG.puzzle;

public class L10_Nth_Even_Fibonacci {
    static int nthEvenFibonacci(int n) {
        // code here

        if (n == 1) return 2;
        if (n == 2) return 8;

        int a = 2;
        int b = 8;

        for(int i=3; i<= n; i++) {
            int c = 4 * b + a;
            a = b;
            b =c;
        }

        return b;
    }
}

//TC : O(n)
//SC : O(1)

//Fibonacii of even no's by themselves will form a pattern

// 2 8 34 144

//34 = 8 * 4 + 2
// 144 = 34 * 4 + 8

// 4*b + a

//static int nthEvenFibonacci(int n) {
//    // code here
//    int n1 = n*3;
//
//    int a =0;
//    int b=1;
//
//    for(int i=2; i<= n1; i++) {
//        int c = a + b;
//        a = b;
//        b =c;
//    }
//
//    return b;
//}

//TC : O(3n)
//SC : O(1)
//Every 3rd fibonacci is a even no