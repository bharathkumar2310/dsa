package dsa.bitManipulation;

class L2_4_Clear_ith_bit {
    int clearBit(int N, int K) {

        return N & ~(1 << K);

    }
}
