package dsa.Arrays;

import java.util.Arrays;

public class L5_Two_Sum {

    boolean twoSum(int arr[], int target) {
        // code here
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            if(arr[left] + arr[right] == target) {
                return true;
            }

            else if(arr[left] + arr[right] > target) {
                right--;
            }
            else{
                left ++;
            }
        }
        return false;
    }
}

//TC : O(nlogn)
//SC : O(1)


// better soln

//boolean twoSum(int arr[], int target) {
//    // code here
//    Map<Integer, Integer> map = new HashMap<>();
//    for(int i=0; i<arr.length; i++) {
//        if(map.containsKey(target - arr[i])) {
//            return true;
//        }
//        map.put(arr[i], 1);
//    }
//
//    return false;
//}


// worst case

//    boolean twoSum(int arr[], int target) {
//        // code here
//        for(int i=0; i<arr.length; i++) {
//            for(int j=i+1; j<arr.length; j++) {
//                if(arr[i] + arr[j] == target) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }


//TC : O(n^2)
//SC : O(1)