package dsa.bitManipulation;

class L2_2_Check_KthBit_Set {
    static boolean checkKthBit(int n, int k) {
        // code here
        return (n & (1<<k)) != 0;
    }
}
