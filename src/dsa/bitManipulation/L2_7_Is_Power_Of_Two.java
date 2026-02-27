package dsa.bitManipulation;

class L2_7_Is_Power_Of_Two {
    public static boolean isPowerofTwo(int n) {
        // code here
        if(n==0) {
            return false;
        }
        return (n& n-1) == 0;
    }
}