package dsa.Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class L12_Leader_In_Array {
    static ArrayList<Integer> leaders(int arr[]) {
        int greatest = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i= arr.length -1; i>=0; i--) {
            if(arr[i] >= greatest) {
                ans.add(arr[i]);
            }
            greatest = Math.max(arr[i] , greatest);
        }
        Collections.reverse(ans);
        return ans;
    }
}

//TC : O(n) + O(nlogn) => O(nlogn)
//SC : O(n) for ans list

