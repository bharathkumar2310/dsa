package dsa.Arrays;
// Dutch National Flag Algorithm
public class L6_Sort_0_1_2 {
    public void sort012(int[] arr) {
        // code here
        int low = -1;
        int mid = 0;
        int end = arr.length - 1;

        while(mid <= end) {
            if(arr[mid]== 1) {
                mid++;
            }
            else if(arr[mid] == 0) {
                swap(mid, low + 1, arr);
                mid++;
                low++;
            }

            else if(arr[mid] == 2) {
                swap(mid, end, arr);
                end--;
            }
        }
    }
    public void swap(int x, int y, int[] arr) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}

//TC : O(n)
//SC : O(1)



//better

//public void sort012(int[] arr) {
//    // code here
//    int ones = 0;
//    int twos = 0;
//    int zeros = 0;
//    for(int i=0; i<arr.length; i++) {
//        if(arr[i] == 0) {
//            zeros++;
//        }
//        if(arr[i] == 1) {
//            ones++;
//        }
//        if(arr[i] == 2) {
//            twos++;
//        }
//    }
//    int k =0;
//    while(zeros > 0) {
//        arr[k] = 0;
//        zeros--;
//        k++;
//    }
//    while(ones > 0) {
//        arr[k] = 1;
//        ones--;
//        k++;
//    }
//    while(twos > 0) {
//        arr[k] = 2;
//        twos--;
//        k++;
//    }
//}

//TC : O(2n)
//SC : O(1)




// worst
// normal sort
//TC: O(nlogn)
//SC: O(1)
