package dsa.Arrays;

public class L7_MajorityElement {
    int majorityElement(int arr[]) {
        // code here
        int count  = 0;
        int ele = -(int)1e9;
        for(int i = 0; i<arr.length; i++) {
            if(count == 0 || ele == arr[i]) {
                ele = arr[i];
                count++;
            }
            else if(ele != arr[i]) {
                count--;
            }
        }

        int count1 = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == ele) {
                count1++;
            }
        }

        if(count1 > arr.length/2) {
            return ele;
        }
        return -1;
    }
}
//TC : O(2n)
//SC : O(1)

// better

//int majorityElement(int arr[]) {
//    // code here
//    Map<Integer, Integer> map = new HashMap<>();
//
//    for(int i=0; i<arr.length; i++) {
//        map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
//        if(map.get(arr[i]) > arr.length /2) {
//            return arr[i];
//        }
//    }
//    return -1;
//}

//TC : O(nlogn)
//SC : O(n)




//worst
//int majorityElement(int arr[]) {
//    // code here
//    for(int i=0; i<arr.length; i++) {
//        int count = 1;
//        for(int j=i+1; j<arr.length; j++) {
//            if(arr[j] == arr[i]) {
//                count++;
//            }
//        }
//        if(count > arr.length/2) {
//            return arr[i];
//        }
//    }
//
//    return -1;
//}

//TC : O(n^2)
//SC : O(1)