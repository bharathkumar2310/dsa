package dsa.bitManipulation;

class L2_8_Find_No_Of_Set_Bits {
    static int setBits(int n) {
        // code here
        int count = 0;
        while(n> 0) {
            n = n& n-1;
            count++;
        }
        return count;
    }
}


//static int setBits(int n) {
//    // code here
//    int count = 0;
//    while(n> 1) {
//        if(n%2 == 1) {
//            count++;
//        }
//        n=n/2;
//
//    }
//    if(n == 1){
//        count++;
//    }
//    return count;
//}

// The above can be re written as


//static int setBits(int n) {
//    // code here
//    int count = 0;
//    while(n> 1) {
//        count+= n & 1;
//        n= n>>1;
//    }
//    if(n == 1){
//        count++;
//    }
//    return count;
//}
