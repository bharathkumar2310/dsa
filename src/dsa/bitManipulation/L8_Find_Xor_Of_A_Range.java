package dsa.bitManipulation;

public class L8_Find_Xor_Of_A_Range {

    int findXor(int start, int end) {
        int startXor = findXorOfNNos(start - 1);
        int endXor = findXorOfNNos(end);
        return startXor ^ endXor;
    }

    int findXorOfNNos(int n) {
        if(n%4 == 1) {
            return 1;
        }
        if(n%4 == 2) {
            return n+1;
        }
        if(n%4 == 3) {
            return 0;
        }
        if(n%4 == 0) {
            return n;
        }
        return 0;
    }
}


//1 = 1
//2 = 1^2 = 3 = n + 1
//3 = 1^2^3 = 0
//4 = 1^2^3^4 = 4 = n


//5 = 1^2^3^4^5 = 1
//6 = 1^2^3^4^5^6 = 7 = n + 1
//7 = 1^2^3^4^5^6^7 = 0
//8 = 1^2^3^4^5^6^7^8 = 8 = n

