package dsa.bitManipulation;

public class L2_5_Toggle_ith_Bit {
    int toggle(int N, int K) {

        return N ^ (1 << K);

    }
}
