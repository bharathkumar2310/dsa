package dsa.bitManipulation;

class L2_3_SetKth_Bit {
    static int setKthBit(int n, int k) {
        // code here
        return (n | (1<<k));
    }
}
