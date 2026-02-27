package dsa.bitManipulation;

public class L2_6_Remove_Last_Set_Bit_RightMost {
    int removeLastSetBit(int N) {

        return N & (N-1);

    }
}
