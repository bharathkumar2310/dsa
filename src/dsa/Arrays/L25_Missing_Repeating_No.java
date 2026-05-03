package dsa.Arrays;

import java.util.ArrayList;

class L25_Missing_Repeating_No {
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        int xMinusy = 0;
        int xsMinusYs = 0;

        for(int i=0;i<arr.length; i++) {
            xMinusy += arr[i];
            xMinusy -= i + 1;
            xsMinusYs += arr[i]*arr[i];
            xsMinusYs -= (i+1)*(i + 1);
        }

        int xPlusy = xsMinusYs/xMinusy;

        int x = (xPlusy + xMinusy) / 2;
        int y = xPlusy - x;

        ArrayList<Integer> ans = new ArrayList<>();

        ans.add(x);
        ans.add(y);
        return ans;
    }
}

//TC : O(n)
//SC : O(1)



//ArrayList<Integer> findTwoElement(int arr[]) {
//    // code here
//    int xOry = 0;
//    for(int i=0; i<arr.length; i++) {
//        xOry ^= (i+1);
//        xOry ^= arr[i];
//    }
//
//    int j=0;
//
//    while((xOry & (1<<j)) == 0) {
//        j++;
//    }
//
//
//    int firstBit = 1<<j;
//
//    int ans1 = 0;
//    int ans2 = 0;
//
//    for(int i=0; i<arr.length; i++) {
//        if((arr[i] & firstBit) > 0) {
//            ans1^=arr[i];
//        }
//        if(((i+1) & firstBit) > 0) {
//            ans1^= i+1;
//        }
//        if((arr[i] & firstBit) == 0) {
//            ans2^=arr[i];
//        }
//        if(((i+1) & firstBit) == 0) {
//            ans2^= i+1;
//        }
//    }
//
//    ArrayList<Integer> ans = new ArrayList<>();
//    for(int i=0; i<arr.length; i++) {
//        if(arr[i] == ans1) {
//            ans.add(ans1);
//            ans.add(ans2);
//            return ans;
//        }
//    }
//    ans.add(ans2);
//    ans.add(ans1);
//    return ans;
//
//}

